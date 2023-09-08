package com.blogapplication.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
	private Integer categoryId;
	private String postType;
	private boolean deleted = false;

	// post
	private Integer postId;
}
