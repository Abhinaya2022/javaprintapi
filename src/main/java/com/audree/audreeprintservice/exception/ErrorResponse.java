package com.audree.audreeprintservice.exception;

public class ErrorResponse {
	private String message;
	private String path;
	private String timestamp;
	private int status;

	public ErrorResponse(String message, String path, String timestamp, int status) {
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
		this.status = status;
	}
}
