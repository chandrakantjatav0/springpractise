package com.libraryapplication.mapper;

import com.libraryapplication.dto.UserDto;
import com.libraryapplication.model.User;

public class UserMapper {
	// Convert User JPA Entity into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), user.getPhoneNo(), user.getEmail(),
				user.isDeleted());
		return userDto;
	}

	// Convert UserDto into User JPA Entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(userDto.getUserId(), userDto.getUserName(), userDto.getPhoneNo(), userDto.getEmail(),
				userDto.isDeleted());
		return user;

	}
}
