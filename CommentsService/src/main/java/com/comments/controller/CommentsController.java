package com.comments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comments.client.CommentsClient;
import com.comments.entity.Comment;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentsClient commentsClient;
	
	@RequestMapping("/all")
	public List<Comment> getAllComments() {
		return this.commentsClient.getAllComments();
	}
	
	@RequestMapping("{id}")
	public List<Comment> getCommentById(@PathVariable("id") Integer id) {
		return this.commentsClient.getCommentById(id);
	}
	
	@RequestMapping("/post/{postId}")
	public List<Comment> getCommentByPostId(@PathVariable("postId") Integer postId) {
		return this.commentsClient.getCommentByPostId(postId);
	}
}
