package com.naratmal.mvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ExceptionConfig {

	@Bean // Bean 등록을 위한 어노테이션
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		
		Properties pro = new Properties(); // 처리할 exception과 이동할 페이지를 매핑할 프로퍼티 생성
		pro.put("처리할 exception", "이동할 페이지"); // 처리할 exception과 이동할 페이지 입력
		
		exceptionResolver.setExceptionMappings(pro); // exceptionResolver에 매핑한 프로퍼티 입력
		
		return exceptionResolver;
	}
}