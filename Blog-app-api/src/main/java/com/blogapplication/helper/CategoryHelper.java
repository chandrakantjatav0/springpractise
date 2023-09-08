package com.blogapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.model.Category;
import com.blogapplication.model.Post;
import com.blogapplication.repostitory.CategoryRepository;
import com.blogapplication.repostitory.PostRepository;
import com.blogapplication.request.CategoryRequest;
import com.blogapplication.response.CategoryResponse;

@Component
public class CategoryHelper {
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private PostRepository postRepo;

	public Category categoryFromCategoryRequest(CategoryRequest categoryRequest) throws ResourceNotFoundException {
		Category category = new Category();
		if (categoryRequest.getCategoryId() != null) {
			category = this.categoryRepo.findById(categoryRequest.getCategoryId())
					.orElseThrow(() -> new ResourceNotFoundException("you are all caught up from your feed"));
		}
		category.setPostType(categoryRequest.getPostType());
// Post Mapping
		Post post = postRepo.findById(categoryRequest.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Post Id not Found"));
		category.setPost(post);
		return category;
	}

	public CategoryResponse categoryResponseFromCategory(Category category) {
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategoryId(category.getCategoryId());
		categoryResponse.setPostType(category.getPostType());
//Post Mapping 
		categoryResponse.setPostId(category.getPost().getPostId());
		categoryResponse.setPostName(category.getPost().getPostName());
		return categoryResponse;

	}

}