package com.blogapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private Integer userId;
	private String userName;
	private String email;
	private boolean deleted = false;
	
//	//post
//	private Integer postId;
//	private String postName;
}
