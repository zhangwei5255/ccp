package jp.co.drm.ccp.web.presentation.controller;

import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.ccp.web.biz.service.LoginService;
import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;
import jp.co.drm.ccp.web.presentation.validator.LoginValidator;
import jp.co.drm.cpp.web.common.SessionKey;

@RestController
@RequestMapping(value = "/login")
// public class LoginRestController extends BaseController{
public class LoginRestController extends BaseController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	LoginService loginService;

	@Inject
	LoginValidator loginValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator); // (2)
	}

	@RequestMapping(value = "/next", method = { RequestMethod.GET, RequestMethod.POST })
	public void next(@Validated @RequestBody LoginDomain domain) {
		LoginDto dto = loginService.selectUserInfoById(domain.getUserId());
		HttpSession session = request.getSession();
		session.setAttribute(SessionKey.LOGIN.value(), dto);
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public void logout() {
		HttpSession session = request.getSession();
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String key = attributeNames.nextElement();
			session.setAttribute(key, null);
		}
	}

	@RequestMapping(value = "/selectUserInfoById", method = { RequestMethod.GET, RequestMethod.POST })
	public LoginDto selectUserInfoById() {
		LoginDto dto = loginService.selectUserInfoById("super");
		return dto;
	}


	@RequestMapping(value = "/testBaseDao", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean testBaseDao() {
		LoginDomain domain = new LoginDomain();
		domain.setUserId("ddd");
		domain.setPwd("dddd");
		boolean ret = loginService.isExsits(domain);
		return  ret;
	}

}
