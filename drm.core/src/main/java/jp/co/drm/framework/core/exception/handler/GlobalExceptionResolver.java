package jp.co.drm.framework.core.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 例外のハンドラクラスです。
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private  final Logger logger = LogManager.getLogger(this.getClass());

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception ex) {

		logger.info(ExceptionUtils.getStackTrace(ex));

		ModelAndView mav = new ModelAndView();

		if (ex instanceof HttpStatusCodeException) {
			HttpStatusCodeException hsce = (HttpStatusCodeException) ex;

			// JSで例外処理するため、ステータスを設定する「400:正常、400以外：異常」
			// 異常の場合、AJAXのfailメソッドを実行する
			response.setStatus(hsce.getStatusCode().value());

			if(hsce.getStatusCode() == HttpStatus.REQUEST_TIMEOUT){
				 logger.info("セッションタイムアウト画面へ遷移します。");
				 mav.setViewName("/err/sessonTimeout.html");
			}
			return mav;
		}

		// システムエラー
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return mav;

	}

}