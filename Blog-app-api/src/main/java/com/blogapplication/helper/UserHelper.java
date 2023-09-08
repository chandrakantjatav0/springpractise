package com.blogapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.model.User;
import com.blogapplication.repostitory.PostRepository;
import com.blogapplication.repostitory.UserRepository;
import com.blogapplication.request.UserRequest;
import com.blogapplication.response.UserResponse;

@Component
public class UserHelper {
	@Autowired
	UserRepository userRepo;
	@Autowired
	PostRepository postRepo;

	public User userFromUserRequest(UserRequest userRequest) throws ResourceNotFoundException {
		User user = new User();
		if (userRequest.getUserId() != null) {
			user = this.userRepo.findById(userRequest.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("No user Available from this name!."));
		}
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		return user;
	}

//		// post mapping
//		Post post = postRepo.findById(userRequest.getPostId())
//				.orElseThrow(() -> new ResourceNotFoundException("Post not fOunded with this id"));
//		user.setPost(userRequest.get);
//		//user

	public UserResponse userResponseFromUser(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(user.getUserId());
		userResponse.setUserName(user.getUserName());
		userResponse.setEmail(user.getEmail());
		return userResponse;
//		// post mapping
//		userResponse.setPostId(user.getPost().getPostId());
//		userResponse.setPostName(user.getPost().getPostName());

	}
}
