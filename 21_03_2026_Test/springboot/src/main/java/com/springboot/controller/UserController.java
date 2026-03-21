package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.UserDto;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.findAll();
	}
	
	@PostMapping("/register")
	public UserDto registerUser(@RequestBody UserDto userDto) {
		return userService.register(userDto);
	}
}
