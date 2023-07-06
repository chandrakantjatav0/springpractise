package com.libraryapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapplication.dto.UserDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserServiceImpl userservice;

// Build Create user a REST API
// http://localhost:8080/api/user/save	
	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws ResourceNotFoundException {
		return new ResponseEntity<>(userservice.createUser(userDto), HttpStatus.CREATED);
	}

//______________________________________________________________________________
	// Build get all user REST Api
	// http://localhost:8080/api/user/mapp
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> user = userservice.getAllUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

//______________________________________________________________________________
	// Build get userbyid REST Api
	// http://localhost:8080/api/user/2
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId) throws ResourceNotFoundException {
		return new ResponseEntity<>(userservice.getUserById(userId), HttpStatus.OK);
	}

//______________________________________________________________________________
// Build update user REST Api
// http://localhost:8080/api/user/3	
//	@PutMapping("{id}")
//	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Integer userId)
//			throws ResourceNotFoundException {
//		return new ResponseEntity<>(userservice.updateUser(userDto, userId), HttpStatus.OK);
//	}

	// Build Author softDelete RestApi
	// ttp://localhost:8080/api/user/softDelete/3
	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteUser(@PathVariable("id") Integer userId) throws ResourceNotFoundException {
		return new ResponseEntity<>(userservice.softDeleteUser(userId), HttpStatus.OK);
	}

//_______________________________________________________________________________________
//Build Delete BookById RestApi 
//http://localhost:8080/api/book/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId) throws ResourceNotFoundException {
		return new ResponseEntity<>(userservice.deleteUser(userId), HttpStatus.OK);
	}
}