package com.springboot.blog.springbootrestap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.springbootrestap.entity.Comment;
import com.springboot.blog.springbootrestap.entity.Post;
import com.springboot.blog.springbootrestap.exception.CommentNotFound;
import com.springboot.blog.springbootrestap.exception.ResourceNotFoundException;
import com.springboot.blog.springbootrestap.payload.CommentDto;
import com.springboot.blog.springbootrestap.repository.CommentRepository;
import com.springboot.blog.springbootrestap.repository.PostRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	PostRepository postRepository;
	
	
	
	public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	public CommentDto ConvertToDto(Comment comment)
	{
		CommentDto commentDto=new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setEmail(comment.getEmail());
		commentDto.setBody(comment.getBody());
		commentDto.setName(comment.getName());
		
		return commentDto;
		
	}
	
	public Comment ConvertToEntity(CommentDto commentDto)
	{
		Comment comment=new Comment();
		comment.setId(commentDto.getId());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		comment.setName(commentDto.getName());
		
		return comment;
		
	}
	public CommentDto CreateComment(long post_id,CommentDto commentDto)
	{
		Post post=postRepository.findById(post_id).orElseThrow(
				()-> new ResourceNotFoundException("post not found"));
			
		Comment comment=ConvertToEntity(commentDto);
		comment.setPost(post);
		Comment newComment=commentRepository.save(comment);
		
		return ConvertToDto(newComment);
	
	}
	
	public List<CommentDto> GetAllComment(long post_id)
	{
		List<Comment> comments=commentRepository.findByPostId(post_id);
		
		return comments.stream().map(comment -> ConvertToDto(comment)).collect(Collectors.toList());
	}
	
	public CommentDto GetCommentById(long post_id,long comment_id)
	{
		Post post=postRepository.findById(post_id).orElseThrow(
				()-> new ResourceNotFoundException("post not found"));
		Comment comment=commentRepository.findById(comment_id).orElseThrow(
				()-> new ResourceNotFoundException("Comment not found"));
		
		if(!(comment.getPost().getId()==post.getId()))
		{
			throw new CommentNotFound(HttpStatus.BAD_REQUEST,"Comment does not belong to the post");
		}
		
		
			return ConvertToDto(comment);
		
	}
	
	public CommentDto UpdateCommentById(long post_id,long comment_id,CommentDto commentDto)
	{
		Post post=postRepository.findById(post_id).orElseThrow(
				()-> new ResourceNotFoundException("post not found"));
		Comment comment=commentRepository.findById(comment_id).orElseThrow(
				()-> new ResourceNotFoundException("Comment not found"));
		
		if(!(comment.getPost().getId()==post.getId()))
		{
			throw new CommentNotFound(HttpStatus.BAD_REQUEST,"Comment does not belong to the post");
		}
		
		
			comment.setBody(commentDto.getBody());
			comment.setEmail(commentDto.getEmail());
			comment.setName(commentDto.getName());
			Comment updatedComment=commentRepository.save(comment);
			return ConvertToDto(updatedComment);
		
	}
	
	public  CommentDto DeleteCommentById(long post_id,long comment_id)
	{
		Post post=postRepository.findById(post_id).orElseThrow(
				()-> new ResourceNotFoundException("post not found"));
		Comment comment=commentRepository.findById(comment_id).orElseThrow(
				()-> new ResourceNotFoundException("Comment not found"));
		
		if(!(comment.getPost().getId()==post.getId()))
		{
			throw new CommentNotFound(HttpStatus.BAD_REQUEST,"Comment does not belong to the post");
		}
		
		CommentDto commentDto=ConvertToDto(comment);
		commentRepository.delete(comment);
		return commentDto;
		
	}
}
