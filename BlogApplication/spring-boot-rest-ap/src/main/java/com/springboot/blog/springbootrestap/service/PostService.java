package com.springboot.blog.springbootrestap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.springboot.blog.springbootrestap.entity.Post;
import com.springboot.blog.springbootrestap.exception.ResourceNotFoundException;
import com.springboot.blog.springbootrestap.payload.PostDto;
import com.springboot.blog.springbootrestap.repository.PostRepository;
@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	
	public Post ConvertToEntity(PostDto postDto )
	{
		Post post=new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
		
	}
	
	public PostDto ConvertToDto(Post post)
	{
		PostDto postDto=new PostDto();
	    postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		return postDto;
		
	}
	public PostDto createPost(PostDto postDto)
	{
		Post post=ConvertToEntity(postDto);
		Post newPost=postRepository.save(post);
		PostDto newPostDto=ConvertToDto(newPost);
		
		return newPostDto;
		
	}
	
	public List<PostDto> getAllPost()
	{	
		List<Post> posts=postRepository.findAll();
		return posts.stream().map(post -> ConvertToDto(post)).collect(Collectors.toList());
		
		
	}
	
	public PostDto GetPostById(long id) throws Exception
	{
		
		Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post not found"));
		
		PostDto postDto=ConvertToDto(post);
		return postDto;
	}
	
	public PostDto UpdatePost(PostDto postDto,long id)
	{
		Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post not found"));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post updatedPost=postRepository.save(post);
		return ConvertToDto(updatedPost);
	}
	
	public void DeletePost(long id)
	{
		Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post not found"));
		postRepository.delete(post);
	}
}
