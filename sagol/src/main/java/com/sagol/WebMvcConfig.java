package com.sagol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sagol.interceptor.loginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	loginInterceptor logininterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logininterceptor)
				.addPathPatterns("/")
				.addPathPatterns("/cc/*")
				.addPathPatterns("/club/*")
				.addPathPatterns("/comp/*")
				.addPathPatterns("/qna/*")
				.addPathPatterns("/request/*")
				.addPathPatterns("/login/*")
				.addPathPatterns("/user/*")
				.excludePathPatterns("/login/login")
				.excludePathPatterns("/user/insertuser");

	}

}
