package jp.co.drm.ccp.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jp.co.drm.ccp.web.exception.HttpSessionRequiredException;
import jp.co.drm.cpp.web.common.SessionKey;


public class LoginRequiredInterceptor extends HandlerInterceptorAdapter {
	private  final Logger logger = LogManager.getLogger(this.getClass());
	private final String LOGIN_ERR_HTML = "/err/loginRequired.html";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// セッションタイムアウトの場合、
		if(request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid()){
			throw new HttpSessionRequiredException();
		}

		Object userData = request.getSession().getAttribute(SessionKey.LOGIN.value());


		if (userData == null) {
			String contextPath = request.getContextPath();
			logger.info("ログイン認証エラー画面へ遷移します。");
			response.sendRedirect(contextPath + LOGIN_ERR_HTML);
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//modelAndView.setViewName("/errorpage/error");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
