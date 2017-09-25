package jp.co.drm.ccp.web.exception;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class HttpSessionRequiredException extends HttpClientErrorException {
	public HttpSessionRequiredException() {
		super(HttpStatus.REQUEST_TIMEOUT, "The session has expired");
	}

    /**
     * コンストラクタです。
     * @param responseHeaders レスポンスヘッダー情報
     * @param responseBody レスポンスボディ情報
     * @param responseCharset レスポンスキャラセット
     */
    public HttpSessionRequiredException(HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(HttpStatus.REQUEST_TIMEOUT, HttpStatus.REQUEST_TIMEOUT.name(), responseHeaders, responseBody, responseCharset);
    }
}
