package com.springboot.service;

import java.util.List;

import com.springboot.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();

	UserDto register(UserDto userDto);
}
