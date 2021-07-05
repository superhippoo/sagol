package com.sagol.dto;

import com.sagol.enums.statusEnum;

public class message {
	

	private statusEnum status;
    private String message;
    private Object data;

	
	public statusEnum getStatus() {
		return status;
	}

	public void setStatus(statusEnum status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

    public message() {
        this.status = statusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }
	
}
