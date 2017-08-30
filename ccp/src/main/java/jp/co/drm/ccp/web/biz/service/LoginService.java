package jp.co.drm.ccp.web.biz.service;

import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;

public interface LoginService {

	 boolean isExsits(LoginDomain domain);

	 void login(LoginDomain domain);

	 LoginDto selectUserInfoById(String userid);
}
