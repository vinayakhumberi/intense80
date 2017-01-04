package com.i80.web;

public class AppResponse_O {

	private String code;
	private String data;
	private String description;
	
	public AppResponse_O() {}
	
	public AppResponse_O(String code, String data, String description) {
		this.code = code;
		this.data = data;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
