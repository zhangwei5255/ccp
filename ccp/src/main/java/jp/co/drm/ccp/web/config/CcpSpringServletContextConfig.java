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
		String[] includePatterns = new String[] { "/**" };
		String[] excludePatterns = new String[] {  "/",
				"/login/**", "/login.html", "/component/**", "/css/**",
				"/err/**", "/js/**",
				//"/favicon.ico",
				"/img/**", "/images/**", "/resources/**"};
		// SPRING4.0以降
		return new MappedInterceptor(includePatterns, excludePatterns, loginRequiredInterceptor());
	}


/*	@Bean
    @Primary
    public ProxyFactoryBean testProxyFactoryBean() {
        ProxyFactoryBean testProxyFactoryBean = new ProxyFactoryBean();
        testProxyFactoryBean.setTarget();
        testProxyFactoryBean.setInterceptorNames("testMethodInterceptor");
        return testProxyFactoryBean;
    }*/


}
