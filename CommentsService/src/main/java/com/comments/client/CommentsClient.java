package com.comments.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comments.entity.Comment;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "COMMENTS-SERVICE")
public interface CommentsClient {

	@GetMapping("/comments")
	public List<Comment> getAllComments();
	
	@GetMapping("/comments")
	public List<Comment> getCommentById(@RequestParam("id") Integer id);
	
	@GetMapping("/comments")
	public List<Comment> getCommentByPostId(@RequestParam("postId") Integer postId);
}
