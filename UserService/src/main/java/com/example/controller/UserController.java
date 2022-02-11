package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.User1;
import com.example.service.LocalPostClient;
import com.example.service.UserClient;
import com.userservice.dto.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserClient userClient;
    
    @Autowired
    private LocalPostClient localPostClient;

    @GetMapping("/all")
    public List<User> getUser() {

        //User1 user = this.userService.getUser(userId);
        //http://localhost:9002/contact/user/1311

        //List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);

    	List<User> users = this.userClient.getUsers();
        //user.setContacts(contacts);
        return users;

    }
    
    @GetMapping("{userId}")
    public List<User> getUserById(@PathVariable Long userId) {
    	List<User> user = this.userClient.getUser(userId);
    	user.get(0).setPosts(localPostClient.getPostsByUser(user.get(0).getId()));
    	return user;
    }

}