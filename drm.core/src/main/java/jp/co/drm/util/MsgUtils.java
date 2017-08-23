package jp.co.drm.util;

import java.text.MessageFormat;

public class MsgUtils {

	private static MsgUtils msgUtils;

	private MsgUtils(){

	}

	public static MsgUtils getInstance(){
		if(msgUtils == null){
			msgUtils = new MsgUtils();
		}

		return msgUtils;
	}


	public String getMessage(String pattern , Object ... args){
		return MessageFormat.format(pattern, args);
	}

}
