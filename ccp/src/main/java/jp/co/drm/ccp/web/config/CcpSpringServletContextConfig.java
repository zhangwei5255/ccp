package jp.co.drm.ccp.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

import jp.co.drm.ccp.web.interceptor.LoginRequiredInterceptor;

@Configuration
public class CcpSpringServletContextConfig {

	/*
	 * @Bean public GlobalExceptionResolver globalExceptionResolver() { return
	 * new GlobalExceptionResolver(); }
	 */

	/*
	 * @Bean public ErrorPageRegistrar errorPageRegistrar(){ return new
	 * CcpErrorPageRegistrar(); }
	 */

	@Bean
	public LoginRequiredInterceptor loginRequiredInterceptor() {
		return new LoginRequiredInterceptor();
	}

	@Bean
	public MappedInterceptor interceptor() {

		// .excludePathPatterns("/"
		// ,""
		// ,"/login/**"
		// ,"/login.html"
		// ,"/favicon.ico" //test
		// ,"/component/**"
		// ,"/err/**"
		// ,"/js/**"
		// ,"/img/**"
		// ,"/images/**"
		// ,"/resources/**"
		String[] includePatterns = new String[] { "/**" };
		String[] excludePatterns = new String[] {  "/",
				"/login/**", "/login.html", "/component/**", "/css/**",
				"/err/**", "/js/**",
				//"/favicon.ico",
				"/img/**", "/images/**", "/resources/**"};
		return new MappedInterceptor(includePatterns, excludePatterns, loginRequiredInterceptor());
	}

}
