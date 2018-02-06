package jp.co.drm.ccp.web.presentation.domain;

import java.io.Serializable;

public class KeyVal implements Serializable{

	private String key;
	private String val;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}

}
