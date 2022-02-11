package com.example.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.userservice.dto.User;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    public List<User> getUsers();
    
    @GetMapping("/users")
    public List<User> getUser(@RequestParam("id") Long id);

}