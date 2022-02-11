package com.example.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Post;


@FeignClient(name = "post-service")
public interface LocalPostClient {

	@GetMapping("/posts/user/{userId}")
	public List<Post> getPostsByUser(@PathVariable("userId") Integer userId);
}
