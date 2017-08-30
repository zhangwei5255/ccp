package jp.co.drm.ccp.web.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.drm.ccp.base.integration.mybatis.dao.MstUserDao;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstUser;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstUserExample;
import jp.co.drm.ccp.web.biz.service.LoginService;
import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
    private HttpServletRequest request;

	@Resource
	private MstUserDao mstUserDao;

/*	@Resource
	private LoginDao loginDao;*/

	@Override
	public boolean isExsits(LoginDomain domain) {

		boolean blnRet = false;

		MstUserExample example = new MstUserExample();
		MstUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(domain.getUserId());
		criteria.andPwdEqualTo(domain.getPwd());

		List<MstUser> lst = mstUserDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(lst)){
			blnRet = true;
		}

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
		//return loginDao.selectUserInfoById(userid);
		return null;
	}











}
