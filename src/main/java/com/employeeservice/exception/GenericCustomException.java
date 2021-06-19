package com.employeeservice.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class GenericCustomException extends RuntimeException {
	
	private HttpStatus responseHttpStatus;
	private String responseMessageAppendParameter;
	private Throwable t;
	
	public HttpStatus getResponseHttpStatus() {
		return responseHttpStatus;
	}
	
	public void setResponseHttpStatus(HttpStatus responseHttpStatus) {
		this.responseHttpStatus=responseHttpStatus;
	}
	
	public void setResponseMessageAppendParameter(String responseMessageAppendParameter) {
		this.responseMessageAppendParameter=responseMessageAppendParameter;
	}
	
	public void setThrowable(Throwable t) {
		this.t=t;
	}
	
	public GenericCustomException(String message,HttpStatus httpStatus) {
		super(message);
		this.setResponseHttpStatus(httpStatus);
		this.setResponseMessageAppendParameter(message);
	}
	
	public GenericCustomException(String message,Throwable t,HttpStatus httpStatus) {
		super(message);
		this.setResponseHttpStatus(httpStatus);
		this.setResponseMessageAppendParameter(message);
		this.setThrowable(t);
	}
}
