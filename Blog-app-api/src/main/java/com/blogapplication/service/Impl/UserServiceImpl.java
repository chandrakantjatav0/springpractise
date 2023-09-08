package com.blogapplication.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.helper.UserHelper;
import com.blogapplication.model.User;
import com.blogapplication.repostitory.UserRepository;
import com.blogapplication.request.UserRequest;
import com.blogapplication.response.UserResponse;
import com.blogapplication.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserHelper userHelper;

	@Override
	public UserResponse addUser(UserRequest userRequest) throws ResourceNotFoundException {
		User user = userHelper.userFromUserRequest(userRequest);
		userRepo.save(user);
		return userHelper.userResponseFromUser(user);
	}

	@Override
	public List<UserResponse> getAllUser() {
		List<User> list = userRepo.findAll();
		return list.stream().map(userHelper::userResponseFromUser).collect(Collectors.toList());
	}

	@Override
	public UserResponse getUserById(Integer userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No user Available with this Id"));
		return userHelper.userResponseFromUser(user);
	}

	@Override
	public String softDeleteUser(Integer userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No user available with this Id"));
		user.setDeleted(true);
		userRepo.save(user);
		return "SoftDeleted this User";
	}

	@Override
	public String deleteUser(Integer userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No user Found With This Id"));
		userRepo.delete(user);
		return "User Deleted Successfully";
	}

}
