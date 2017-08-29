package jp.co.drm.framework.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.drm.framework.core.exception.handler.GlobalExceptionResolver;


@Configuration
public class SpringServletContextConfig {


	@Bean
	public GlobalExceptionResolver globalExceptionResolver() {
		return new GlobalExceptionResolver();
	}



}
