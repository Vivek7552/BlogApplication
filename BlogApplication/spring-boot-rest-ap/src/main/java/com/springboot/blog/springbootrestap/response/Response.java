package com.springboot.blog.springbootrestap.response;

import java.util.List;

import com.springboot.blog.springbootrestap.payload.Data;
import com.springboot.blog.springbootrestap.payload.PostDto;

public class Response {

	boolean status;
	int code;
	String message;
	Data data;
	List<PostDto> Data;
	
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
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Response(boolean status, int code, String message, PostDto postDto) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = postDto;
	}
	
	public Response(boolean status, int code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}
	public Response() {
		super();
	}
	
	
	
}
