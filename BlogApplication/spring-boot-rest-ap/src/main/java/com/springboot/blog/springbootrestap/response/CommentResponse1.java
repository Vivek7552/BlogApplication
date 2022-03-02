package com.springboot.blog.springbootrestap.response;

import java.util.List;

import com.springboot.blog.springbootrestap.payload.CommentDto;

public class CommentResponse1 {

	boolean status;
	int code;
	String message;
	List<CommentDto> data;
	public CommentResponse1(boolean status, int code, String message, List<CommentDto> data) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public List<CommentDto> getData() {
		return data;
	}
	public void setData(List<CommentDto> data) {
		this.data = data;
	}
	public CommentResponse1() {
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
	
	
}
