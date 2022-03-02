package com.springboot.blog.springbootrestap.payload;

public class PostDto implements Data {
	
	
	
	private String title;
	private String description;
	private String content;
	public PostDto( String title, String description, String content) {
		super();
		
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PostDto() {
		super();
	}
	
	

}
