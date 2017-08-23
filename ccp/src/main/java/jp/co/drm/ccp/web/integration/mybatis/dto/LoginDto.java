package jp.co.drm.ccp.web.integration.mybatis.dto;

import java.io.Serializable;
import java.util.List;

import jp.co.drm.ccp.base.integration.mybatis.entity.MstModule;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstRole;

public class LoginDto implements Serializable {

    private String userId;

    private String userNm;

    private MstRole mstRole;

    private List<MstModule> mstModules;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public MstRole getMstRole() {
		return mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

	public List<MstModule> getMstModules() {
		return mstModules;
	}

	public void setMstModules(List<MstModule> mstModules) {
		this.mstModules = mstModules;
	}

}
