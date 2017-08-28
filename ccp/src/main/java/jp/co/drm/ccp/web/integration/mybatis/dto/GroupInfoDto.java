package jp.co.drm.ccp.web.integration.mybatis.dto;

import java.io.Serializable;

public class GroupInfoDto implements Serializable {

	private String groupId;

	private String groupNm;

	private String moduleCd;

	private String moduleNm;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupNm() {
		return groupNm;
	}

	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
	}

	public String getModuleCd() {
		return moduleCd;
	}

	public void setModuleCd(String moduleCd) {
		this.moduleCd = moduleCd;
	}

	public String getModuleNm() {
		return moduleNm;
	}

	public void setModuleNm(String moduleNm) {
		this.moduleNm = moduleNm;
	}

}
