package com.blogapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
	private Integer commentId;
	private String comments;
	private boolean deleted = false;

	// post
	private Integer postId;
	private String postName;
	// Comment
	private Integer userId;
	private String userName;
	private String email;
	
}
