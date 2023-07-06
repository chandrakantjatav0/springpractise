package com.libraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Integer userId;
	private String userName;
	private long phoneNo;
	private String email;
	private boolean Deleted = false;

}
