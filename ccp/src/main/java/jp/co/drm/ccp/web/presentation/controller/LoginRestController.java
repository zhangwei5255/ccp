package jp.co.drm.ccp.web.presentation.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.ccp.web.biz.service.LoginService;
import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;



@RestController
@RequestMapping(value="/login")
//public class LoginRestController extends BaseController{
public class LoginRestController extends BaseController{

	@Autowired
    private HttpServletRequest request;


	@Autowired
	LoginService loginService;
//
//	@RequestMapping(value="/next",method = {RequestMethod.GET, RequestMethod.POST})
//	public LoginDomain next(HttpServletRequest request,@Validated @RequestBody  LoginDomain domain){
//		LoginDomain retDomain = null;
//		LoginCriteria criteria = new LoginCriteria();
//		criteria.setUserpassword(domain.getUserpassword());
//		Boolean isEmail = EmailValidator.getInstance().isValid(domain.getUserid());
//		if(isEmail){
//			criteria.setEmail(domain.getUserid());
//			retDomain = loginService.loginByEmail(criteria);
//
//		}else{
//			criteria.setUserid(domain.getUserid());
//			retDomain = loginService.loginByUserId(criteria);
//		}
//
//		return retDomain;
//
//	}

	@RequestMapping(value="/logout",method = {RequestMethod.GET, RequestMethod.POST})
	public void logout(){
		HttpSession session = request.getSession();
		Enumeration<String> attributeNames = session.getAttributeNames();
		while(attributeNames.hasMoreElements()){
			String key = attributeNames.nextElement();
			session.setAttribute(key, null);
		}
	}


	@RequestMapping(value="/selectUserInfoById",method = {RequestMethod.GET, RequestMethod.POST})
	public LoginDto selectUserInfoById(){
		LoginDto dto = loginService.selectUserInfoById("super");
		return dto;
	}

}
