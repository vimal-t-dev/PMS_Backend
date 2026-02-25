package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userservice.register(user);	
		}
	
	@PostMapping("/login")
	public User login(@RequestParam String email,
	                  @RequestParam String password) 
	{
	    return userservice.login(email, password);
	}
}
