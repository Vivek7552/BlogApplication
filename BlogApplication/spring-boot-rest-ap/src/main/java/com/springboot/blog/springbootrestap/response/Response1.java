package com.springboot.blog.springbootrestap.response;

import java.util.List;

import com.springboot.blog.springbootrestap.payload.Data;
import com.springboot.blog.springbootrestap.payload.PostDto;

public class Response1 {


	boolean status;
	int code;
	String message;
	List<PostDto> data;
	
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
	
	public List<PostDto> getData() {
		return data;
	}
	public void setData(List<PostDto> data) {
		this.data = data;
	}
	public Response1(boolean status, int code, String message, List<PostDto> postDto) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = postDto;
	}
	
	public Response1() {
		super();
	}
	
	
	
}
