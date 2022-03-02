package com.springboot.blog.springbootrestap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.springbootrestap.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
         
	}
