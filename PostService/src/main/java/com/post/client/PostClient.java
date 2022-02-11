package com.post.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.post.entity.Post;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "POST-CLIENT")
public interface PostClient {

	@GetMapping("/posts")
	public List<Post> getAllPosts();
	
	@GetMapping("/posts")
	public List<Post> getPostsById(@RequestParam("id") Long id);
	
	@GetMapping("/posts")
	public List<Post> getPostsByUserId(@RequestParam("userId") Long userId);
}
