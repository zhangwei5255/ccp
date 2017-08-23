package jp.co.drm.ccp.web.biz.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.drm.ccp.base.integration.mybatis.dao.MstUserDao;
import jp.co.drm.ccp.web.biz.service.LoginService;
import jp.co.drm.ccp.web.integration.mybatis.dao.LoginDao;
import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
    private HttpServletRequest request;

	@Resource
	private MstUserDao mstUserDao;

	@Resource
	private LoginDao loginDao;

	@Override
	public boolean chkLoginInfo(LoginDomain domain) {

		boolean blnRet = false;


		return blnRet;
	}


	@Override
	public void login(LoginDomain domain) {
		/*		HttpSession session = request.getSession();
		session.setAttribute(ConstVals.SESSION_LOGIN_USER_INFO, dto);*/

	}

	@Override
	public LoginDto selectUserInfoById(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		return loginDao.selectUserInfoById(userid);
	}











}
