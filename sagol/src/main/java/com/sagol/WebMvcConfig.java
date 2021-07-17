package com.sagol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sagol.interceptor.loginInterceptor;
import com.sagol.util.HTMLCharacterEscapes;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	loginInterceptor logininterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(logininterceptor)
//				.addPathPatterns("/")
//				.addPathPatterns("/cc/*")
//				.addPathPatterns("/club/*")
//				.addPathPatterns("/comp/*")
//				.addPathPatterns("/qna/*")
//				.addPathPatterns("/request/*")
//				.addPathPatterns("/login/*")
//				.addPathPatterns("/user/*")
//				.excludePathPatterns("/login/login")
//				.excludePathPatterns("/user/insertuser");

	}

	// Lucy Xss filter ���� : form�����͸� �ǰ� ResponseBody json Ÿ���� ������ ���� �ʾ� ���� But ���� ���
	// ���ɼ��� �ּ�ó��
//	@Bean
//	public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean() {
//		FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new XssEscapeServletFilter());
//		registrationBean.setOrder(1);
//		registrationBean.addUrlPatterns("/*");
//		return registrationBean;
//	}

	//�ѱ� ���ڵ� Filter
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return characterEncodingFilter;
	}

	/**
	 * xss Prevention Filter Request �����ʹ� �����ϴ°��� �°ڴ� �;� ���� �״�� DB�� ���� Response �����͸�
	 * ó���ؼ� XSS ���� ���
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(htmlEscapingConveter());
	}

	@Bean
	public HttpMessageConverter<?> htmlEscapingConveter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		MappingJackson2HttpMessageConverter escapingConverter = new MappingJackson2HttpMessageConverter();
		escapingConverter.setObjectMapper(objectMapper);

		return escapingConverter;
	}

}
