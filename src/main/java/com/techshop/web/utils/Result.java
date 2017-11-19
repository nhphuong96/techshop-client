package com.techshop.web.utils;

public class Result {

	private Long id;
	private String message;
	private Boolean success;
	
	public Result() {}
	public Result(Long id, String message, Boolean isSuccess) {
		this.id = id;
		this.message = message;
		this.success = isSuccess;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
}
