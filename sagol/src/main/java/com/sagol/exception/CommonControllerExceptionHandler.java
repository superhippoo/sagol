package com.sagol.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CommonControllerExceptionHandler extends DefaultErrorAttributes {

    @Override
	@ExceptionHandler(Exception.class)//전역 설정
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    	Map<String, Object> totalresult = new HashMap<String, Object>();
        Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
        
        totalresult.put("status", result.get("status"));
        totalresult.put("data", result);
        totalresult.put("returnmessage", result.get("error"));

        return totalresult;
    }
 
}