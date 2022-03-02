package com.springboot.blog.springbootrestap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.springbootrestap.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	
   List<Comment> findByPostId(long id);
  
}
