package com.sagol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2818771387862713327L;
	public static final String errorCode = "Bad Request";

	public BadRequestException() {
		this(errorCode);
	}

	public BadRequestException(String errorcode) {
		super(errorcode);
	}
    public String getErrorCode() {
        return errorCode;
    }

}
