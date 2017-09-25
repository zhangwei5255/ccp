package jp.co.drm.base.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.co.drm.util.MsgUtils;

public abstract class BaseController {

	public static final String STR_SPLIT_DOT = ".";

	@Autowired
	Properties itemProperties;

	@Autowired
	HttpServletRequest request;

	@Autowired
	MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private Object[] handleException(HttpServletRequest req, MethodArgumentNotValidException e) {
		//WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		//Properties itemProperties = (LinkedProperties) ctx.getBean("itemProperties");
		//ReloadableResourceBundleMessageSource messageSource = (ReloadableResourceBundleMessageSource)ctx.getBean("messageSource");
		//MessageSource messageSource = (MessageSource)ctx.getBean("messageSource");
		//MessageSource messageSource = ctx.getBean(MessageSource.class);

		BindingResult bindingResult = e.getBindingResult();

		Map<String, String> mapMsg = new HashMap<String, String>();

		for (FieldError err : bindingResult.getFieldErrors()) {
			// KEY
			String key = err.getObjectName() + STR_SPLIT_DOT + err.getField();

			if (mapMsg.keySet().contains(key)) {
				continue;
			}
			// key err.getField()
			List<Object> lstArg = new ArrayList<Object>();

			if (err.getArguments() != null) {
				Stream.of(err.getArguments()).forEach(p -> {
					if (p instanceof DefaultMessageSourceResolvable) {
						DefaultMessageSourceResolvable dms = (DefaultMessageSourceResolvable) p;
						Object filed = itemProperties.getProperty(dms.getCodes()[0]);
						lstArg.add(filed);
					} else {
						lstArg.add(p);
					}

				});

				String msg = MsgUtils.getInstance().getMessage(err.getDefaultMessage(),
						lstArg.toArray(new Object[lstArg.size()]));

				mapMsg.put(key, msg);

			}else{
				String msg = MsgUtils.getInstance().getMessage(err.getDefaultMessage());
				mapMsg.put(key, msg);
			}
		}

		Object[] errMsgs = itemProperties.keySet().stream().filter(k -> mapMsg.containsKey(k))
								.map(k -> mapMsg.get(k)).toArray();
		return errMsgs;

	}

}
