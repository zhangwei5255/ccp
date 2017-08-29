package jp.co.drm.ccp.web.presentation.domain;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.drm.base.presentation.domain.BaseDomain;

public class LoginDomain extends BaseDomain {

	@NotBlank
	private String userId;

	@NotBlank
	private String pwd;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
