package jp.co.drm.ccp.web.integration.mybatis.dto;

import java.io.Serializable;
import java.util.List;

public class LoginDto implements Serializable {

    private String userId;

    private String userNm;

    private List<GroupInfoDto> groupInfoDtos;

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

	public List<GroupInfoDto> getGroupInfoDtos() {
		return groupInfoDtos;
	}

	public void setGroupInfoDtos(List<GroupInfoDto> groupInfoDtos) {
		this.groupInfoDtos = groupInfoDtos;
	}

}
