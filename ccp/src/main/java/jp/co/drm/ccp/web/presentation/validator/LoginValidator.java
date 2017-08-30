package jp.co.drm.ccp.web.presentation.validator;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.drm.ccp.web.biz.service.LoginService;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;

@Component
public class LoginValidator implements Validator {

	@Autowired
	LoginService loginService;

	@Autowired
	Properties itemProperties;

	@Autowired
	MessageSource messageSource;

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginDomain.class.isAssignableFrom(clazz); // (2)
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		LoginDomain domain = (LoginDomain) target;

		if (loginService.isExsits(domain) == false) {

			String msg = messageSource.getMessage("login.user.info.exists", null, Locale.getDefault());
			errors.rejectValue("userId", null, msg);
		}

	}

}
