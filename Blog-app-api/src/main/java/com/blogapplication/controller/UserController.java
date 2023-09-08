package com.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.UserRequest;
import com.blogapplication.response.UserResponse;
import com.blogapplication.service.Impl.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blogApp/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/save")
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) throws ResourceNotFoundException {
		return new ResponseEntity<>(userService.addUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<UserResponse> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer userId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteUser(@PathVariable("id") Integer userId) throws ResourceNotFoundException {
		return new ResponseEntity<>(userService.softDeleteUser(userId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId) throws ResourceNotFoundException {
		return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
	}
}
