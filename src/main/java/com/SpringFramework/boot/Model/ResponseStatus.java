package com.SpringFramework.boot.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStatus {
	
	private String status;
	private String statusCode;
	private ErrorDetails errorDetails;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
