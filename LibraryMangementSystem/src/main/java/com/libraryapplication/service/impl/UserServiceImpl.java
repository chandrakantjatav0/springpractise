package com.libraryapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.libraryapplication.dto.UserDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.mapper.UserMapper;
import com.libraryapplication.model.User;
import com.libraryapplication.repository.UserRepository;
import com.libraryapplication.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto userDto) throws ResourceNotFoundException {
		User user = new User();
		if (userDto.getUserId() != null) {
			user = this.userRepo.findById(userDto.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User not found!.."));
		}
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		user.setPhoneNo(userDto.getPhoneNo());
		userRepo.save(user);
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user = userRepo.findAll();
		return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Integer userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!.."));
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public String softDeleteUser(Integer id) throws ResourceNotFoundException {
		// we need to Check whether Book exist in DB or not
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found!.."));
		user.setDeleted(false);
		userRepo.save(user);
		return "Soft deleted this Record!..";
	}

	@Override
	public String deleteUser(Integer id) throws ResourceNotFoundException {
		userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not Found !.."));
		userRepo.deleteById(id);
		return "User deleted Successfully!...";
	}

}
