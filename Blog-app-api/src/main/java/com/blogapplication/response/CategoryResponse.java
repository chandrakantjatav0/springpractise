package com.blogapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
	private Integer categoryId;
	private String postType;
	private boolean deleted = false;

	// post
	//private PostResponse postResponse;
	private Integer postId;
	private String postName;
}