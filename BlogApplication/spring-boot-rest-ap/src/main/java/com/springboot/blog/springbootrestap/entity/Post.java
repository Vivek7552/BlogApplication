package com.springboot.blog.springbootrestap.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="posts", uniqueConstraints = {@UniqueConstraint(columnNames= {"title"})})
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    @Column(name="title",nullable=false)
	private String title;
    @Column(name="description",nullable=false)
	private String description;
    @Column(name="content",nullable=false)
	private String content;
    @OneToMany(mappedBy="post",cascade=CascadeType.ALL ,orphanRemoval=true)
    private Set<Comment> comments=new HashSet<>();
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Post(long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public Post() {
		super();
	}
	
	
}
