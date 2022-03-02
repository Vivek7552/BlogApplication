package com.springboot.blog.springbootrestap.controller;

import java.util.List;

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

import com.springboot.blog.springbootrestap.payload.PostDto;
import com.springboot.blog.springbootrestap.response.Response;
import com.springboot.blog.springbootrestap.response.Response1;
import com.springboot.blog.springbootrestap.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	

	@PostMapping
	public Response createPost(@RequestBody PostDto postDto) {
		
		return new Response(true,201,"Post Created successfully",postService.createPost(postDto));
		
	}
	
	@GetMapping
	public Response1 getAllPost(){
		return  new Response1(true,201,"fetched all posts successfully",postService.getAllPost());
	}
	
	@GetMapping("/{id}")
	public Response  GetPostById(@PathVariable(name="id") long id) throws Exception
	{
		return new Response(true,201,"Post fetched successfully",postService.GetPostById(id));
	}
	
	@PutMapping("/{id}")
	public Response updatePost(@RequestBody PostDto postDto ,@PathVariable(name="id") long id)
	{
		return new Response(true,202,"Updated post Successfully",postService.UpdatePost(postDto,id));
	}
	
	@DeleteMapping("/{id}")
	public  Response deletePost(@PathVariable long id)
	{
		postService.DeletePost(id);
		return new Response(true,204,"Post Deleted Successfully");
		
	}
}
