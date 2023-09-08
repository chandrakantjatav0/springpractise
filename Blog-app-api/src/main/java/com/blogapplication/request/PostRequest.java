package com.blogapplication.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
	private Integer postId;
	private String postName;
	private boolean deleted = false;
	// category
	private Integer categoryId;
	// user
	private Integer userId;
	// comment
	private Integer commentId;
	List<Integer> commentIds;
}
