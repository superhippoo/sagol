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
import com.sagol.interceptor.adminInterceptor;
import com.sagol.interceptor.loginInterceptor;
import com.sagol.util.HTMLCharacterEscapes;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	loginInterceptor logininterceptor;

	@Autowired
	adminInterceptor admininterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(logininterceptor)
//				.addPathPatterns("/")
//				.addPathPatterns("/cc/*")
//				.addPathPatterns("/club/*")
//				.addPathPatterns("/clubmem/*")
//				.addPathPatterns("/comp/*")
//				.addPathPatterns("/qna/*")
//				.addPathPatterns("/request/*")
//				.addPathPatterns("/login/*")
//				.addPathPatterns("/user/*")
//				.excludePathPatterns("/login/login")
//				.excludePathPatterns("/user/insertuser")
//				.excludePathPatterns("/user/sendauthmail")
//				.excludePathPatterns("/user/checkauthcd")
//		        .excludePathPatterns("/user/isexistbykakaoemail")
//		        .excludePathPatterns("/user/isexistbycompemail");
//
//		
//		registry.addInterceptor(admininterceptor)
//				.addPathPatterns("/comp/*")
//				.addPathPatterns("/cc/*")
//				.addPathPatterns("/user/selectuserlist");



	}

	// Lucy Xss filter 적용 : form데이터만 되고 ResponseBody json 타입의 적용이 되지 않아 제거 But 추후 사용
	// 가능성에 주석처리
//	@Bean
//	public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean() {
//		FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new XssEscapeServletFilter());
//		registrationBean.setOrder(1);
//		registrationBean.addUrlPatterns("/*");
//		return registrationBean;
//	}

	//한글 인코딩 Filter
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return characterEncodingFilter;
	}

	/**
	 * xss Prevention Filter Request 데이터는 보존하는것이 맞겠다 싶어 원본 그대로 DB에 보관 Response 데이터를
	 * 처리해서 XSS 공격 방어
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
