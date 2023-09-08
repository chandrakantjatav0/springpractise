package com.blogapplication.service;

import java.util.List;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.UserRequest;
import com.blogapplication.response.UserResponse;

public interface UserService {
	UserResponse addUser(UserRequest userRequest) throws ResourceNotFoundException;

	List<UserResponse> getAllUser();

	UserResponse getUserById(Integer userId) throws ResourceNotFoundException;

	String softDeleteUser(Integer userId) throws ResourceNotFoundException;

	String deleteUser(Integer userId) throws ResourceNotFoundException;

}
