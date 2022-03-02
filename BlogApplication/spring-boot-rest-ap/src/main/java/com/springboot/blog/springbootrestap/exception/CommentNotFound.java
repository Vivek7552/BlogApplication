package com.springboot.blog.springbootrestap.exception;

import org.springframework.http.HttpStatus;

public class CommentNotFound extends RuntimeException {
	
	private HttpStatus status;
	private String message;
	public CommentNotFound(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public CommentNotFound() {
		super();
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
