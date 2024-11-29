package com.audree.audreeprintservice.dto;

public class ResponseDto {
	private String message;
	private boolean success;
	
	//Getter and Setter
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean getSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
