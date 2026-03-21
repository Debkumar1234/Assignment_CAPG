package com.springboot.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Exception.DuplicateEntryException;
import com.springboot.dto.UserDto;
import com.springboot.model.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;


	@Override
	public List<UserDto> findAll() {
		
		List<User> list =  userRepository.findAll();
		
		List<UserDto> userDtoList = list.stream()
		.map((user)->modelMapper.map(user, UserDto.class))
		.toList();
		
		return userDtoList;
	}

	@Override
	public UserDto register(UserDto userDto) {
		User user1 = userRepository.findByEmail(userDto.getEmail()).orElse(null);
		if(user1 != null) {
			throw new DuplicateEntryException("Data already present in database");
		}
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}
}
