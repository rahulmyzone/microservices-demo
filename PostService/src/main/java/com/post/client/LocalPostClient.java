package com.post.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.post.entity.Post;

@FeignClient(url = "http://post-service", name = "POST-SERVICE")
public interface LocalPostClient {

	@GetMapping("/posts/user/{userId}")
	public List<Post> getPostsByUser(@PathVariable("userId") Long userId);
}
