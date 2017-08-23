package jp.co.drm.base.presentation.domain;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDomain implements Serializable {

	private List<String> messages;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
