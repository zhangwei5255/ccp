package jp.co.drm.framework.core.exception;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * <p>
 * このクラスは、HTTPステータスコード 401が返されたときにスローされる例外です。
 * </p>
 */
@SuppressWarnings("serial")
public class UnauthorizedException extends HttpClientErrorException {

	public UnauthorizedException() {
		super(HttpStatus.UNAUTHORIZED);
	}

    /**
     * コンストラクタです。
     * @param responseHeaders レスポンスヘッダー情報
     * @param responseBody レスポンスボディ情報
     * @param responseCharset レスポンスキャラセット
     */
    public UnauthorizedException(HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.name(), responseHeaders, responseBody, responseCharset);
    }

}
