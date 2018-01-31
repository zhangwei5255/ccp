package jp.co.drm.ccp.web.presentation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.misumi.wos.util.SubsidiaryUtil;
import jp.misumi.wos.util.SubsidiaryUtil.NumberType;

@RestController
@RequestMapping(value = "/SubsidiaryUtil")
// public class LoginRestController extends BaseController{
public class SubsidiaryUtilController extends BaseController {

	private final Logger logger = LogManager.getLogger(this.getClass());



	@Autowired
	private HttpServletRequest request;

	@Autowired
	ResourceLoader resourceLoader;

	@RequestMapping(value = "/getDateTime", method = { RequestMethod.GET, RequestMethod.POST })
	public String getDateTime(@RequestParam("input") String input, @RequestParam("type") String type) throws ParseException {

		String ftm;
		if(input.length() > 10) {
			ftm = "yyyy/MM/dd HH:mm";
		}else {
			ftm = "yyyy/MM/dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(ftm);
		Date date = sdf.parse(input);

		String str = SubsidiaryUtil.getDatetime("IND", date, type, "IND");
		return str;
	}

	@RequestMapping(value = "/getSelectableLanguageCode", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> getSelectableLanguageCode(){
		return SubsidiaryUtil.getSelectableLanguageCode();

	}

	@RequestMapping(value = "/getFormattedNumber", method = { RequestMethod.GET, RequestMethod.POST })
	public String getFormattedNumber(@RequestParam("input") String input, @RequestParam("type") String type) {
		if(StringUtils.isBlank(type)) {
			return SubsidiaryUtil.getFormattedNumber(input);
		}

		NumberType nmType = SubsidiaryUtil.getNumberType(type);

		return SubsidiaryUtil.getFormattedNumber(input, nmType);

	}




}
