package jp.co.drm.cpp.web.common;


public enum SessionKey {


	LOGIN(SessionKey.class.getName() +  "0000000", "ログイン"),
	WAREHOUSING_MNG(SessionKey.class.getName() + "0101", "入庫管理"),
	WAREHOUSING_MNG_001(SessionKey.class.getName() + "0101001", "入庫通知伝票一覧"),
	LOGOUT(SessionKey.class.getName() + "9999999", "ログアウト");


	private final String value;

	private final String comment;


	SessionKey(String value, String comment) {
		this.value = value;
		this.comment = comment;
	}


	/**
	 * Return the integer value of this status code.
	 */
	public String value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getComment() {
		return this.comment;
	}



	/**
	 * Return a string representation of this status code.
	 */
	@Override
	public String toString() {
		return this.value;
	}


	/**
	 * Return the enum constant of this type with the specified numeric value.
	 * @param code the numeric value of the enum to be returned
	 * @return the enum constant with the specified numeric value
	 * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
	 */
	public static SessionKey asEnum(String code) {
		for (SessionKey key : values()) {
			if (key.value.equals(code)) {
				return key;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + code + "]");
	}


}

