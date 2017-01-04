package com.i80.web;

import com.i80.common.enums.RetcodeEnum;

public class AppResponse<T> {

	private RetcodeEnum retCode;
	private T data;
	private String description;
	
	public AppResponse() {}
	
	public AppResponse(RetcodeEnum code, T data, String description) {
		this.retCode = code;
		this.data = data;
		this.description = description;
	}

	public RetcodeEnum getCode() {
		return retCode;
	}

	public void setCode(RetcodeEnum code) {
		this.retCode = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
