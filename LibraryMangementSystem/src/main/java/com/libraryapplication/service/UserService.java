package com.libraryapplication.service;

import java.util.List;

import com.libraryapplication.dto.UserDto;
import com.libraryapplication.exception.ResourceNotFoundException;

public interface UserService {
	UserDto createUser(UserDto userDto) throws ResourceNotFoundException;

	List<UserDto> getAllUser();

	UserDto getUserById(Integer id) throws ResourceNotFoundException;

	//UserDto updateUser(UserDto userDto, Integer id) throws ResourceNotFoundException;

	String softDeleteUser(Integer id) throws ResourceNotFoundException;

	String deleteUser(Integer id) throws ResourceNotFoundException;
}
