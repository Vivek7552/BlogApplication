package com.springboot.blog.springbootrestap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.springbootrestap.entity.Comment;
import com.springboot.blog.springbootrestap.payload.CommentDto;
import com.springboot.blog.springbootrestap.response.CommentResponse;
import com.springboot.blog.springbootrestap.response.CommentResponse1;
import com.springboot.blog.springbootrestap.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	
	
	@PostMapping("posts/{postId}/comments")
	public CommentResponse CreateComment(@PathVariable(value="postId") long id ,@RequestBody CommentDto commentDto)
	{
		return new CommentResponse(true,203,"Comment created",commentService.CreateComment(id,commentDto));
	}
	
	@GetMapping("posts/{postId}/comments")
	public CommentResponse1 GetAllComment(@PathVariable(value="postId") long id )
	{
		return new CommentResponse1(true,212,"Fetched all comments",commentService.GetAllComment(id));
	}
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public CommentResponse getCommentById(@PathVariable(value="postId")long post_Id,@PathVariable(value="id") long id)
	{
		return new CommentResponse(true,207,"Comment fetched successfully",commentService.GetCommentById(post_Id, id));
	}
	
	@PutMapping("/posts/{postId}/comments/{id}")
	public CommentResponse updateCommentById(@PathVariable(value="postId")long post_Id,@PathVariable(value="id") long id,@RequestBody CommentDto commentDto)
	{
		return new CommentResponse(true,209,"Comment updated",commentService.UpdateCommentById(post_Id, id,commentDto));
	}
	
	@DeleteMapping("/posts/{postId}/comments/{id}")
	public CommentResponse deleteCommentById(@PathVariable(value="postId")long post_Id,@PathVariable(value="id") long id)
	{
		return new CommentResponse(true,211,"Comment deleted",commentService.DeleteCommentById(post_Id, id));
	}
}
