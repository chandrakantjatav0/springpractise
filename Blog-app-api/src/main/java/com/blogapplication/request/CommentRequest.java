package com.blogapplication.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
	private Integer commentId;
	private String comments;
	private boolean deleted = false;
	// post
	private Integer postId;
	//comment
	private Integer userId;
	
	

}