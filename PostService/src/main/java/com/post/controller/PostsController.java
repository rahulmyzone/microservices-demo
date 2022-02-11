package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.client.LocalCommentsClient;
import com.post.client.PostClient;
import com.post.entity.Post;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostClient postClient;
	
	@Autowired
	private LocalCommentsClient localCommentsClient;
	
	@GetMapping("all")
	public List<Post> getAllPosts() {
		
		return this.postClient.getAllPosts();
	}
	
	@GetMapping("{id}")
	public List<Post> getPostsById(@PathVariable("id") Long id) {
		
		List<Post> posts = this.postClient.getPostsById(id);
		posts.stream().forEach(post -> post.setComments(this.localCommentsClient.getCommentsByPost(post.getId())));
		return posts;
	}

	
	@GetMapping("/user/{userId}")
	public List<Post> getPostsByUserId(@PathVariable("userId") Long userId) {
		
		List<Post> posts = this.postClient.getPostsByUserId(userId);
		posts.stream().forEach(post -> post.setComments(this.localCommentsClient.getCommentsByPost(post.getId())));
		return posts;
	}
	
}
