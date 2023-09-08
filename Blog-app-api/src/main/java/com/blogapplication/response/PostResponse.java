package com.blogapplication.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
	private Integer postId;
	private String postName;
	private boolean deleted = false;

	// category
	// private CategoryResponse categoryResponse;
	private Integer categoryId;
	private String postType;
	// User
	private Integer userId;
	private String userName;
	private String email;

	// comment
	List<CommentResponse> commentResponses;
//	private Integer commentId;
//	private String comments;
}
