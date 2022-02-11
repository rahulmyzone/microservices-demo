package com.post.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.entity.Comment;

@FeignClient(name = "comment-service")
public interface LocalCommentsClient {

	@RequestMapping("/comments/post/{postId}")
	public List<Comment> getCommentsByPost(@PathVariable("postId") Integer postId);
}
