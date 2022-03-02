package com.springboot.blog.springbootrestap.response;

import java.util.List;

import com.springboot.blog.springbootrestap.payload.CommentDto;
import com.springboot.blog.springbootrestap.payload.Data;
import com.springboot.blog.springbootrestap.payload.PostDto;

public class CommentResponse {

	boolean status;
	int code;
	String message;
	CommentDto data;
	public CommentResponse(boolean status, int code, String message, CommentDto data) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public CommentResponse() {
		super();
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommentDto getData() {
		return data;
	}
	public void setData(CommentDto data) {
		this.data = data;
	}
	
	
}
