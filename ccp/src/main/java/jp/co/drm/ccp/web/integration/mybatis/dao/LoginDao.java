package jp.co.drm.ccp.web.integration.mybatis.dao;

import jp.co.drm.ccp.web.integration.mybatis.dto.LoginDto;

public interface LoginDao {

	LoginDto selectUserInfoById(String userid);
}
