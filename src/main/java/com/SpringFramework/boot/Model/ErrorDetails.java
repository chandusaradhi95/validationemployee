package com.SpringFramework.boot.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

	private String errorMessage;
	private String errorCode;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorDetails(String errorMessage, String errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode =  errorCode;
	}
}
