package com.blogapplication.service;

import java.util.List;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.CategoryRequest;
import com.blogapplication.response.CategoryResponse;

public interface CategoryService {
	CategoryResponse addCategory(CategoryRequest categoryRequest) throws ResourceNotFoundException;

	List<CategoryResponse> getAllCategory();

	CategoryResponse getCategoryById(Integer categoryId) throws ResourceNotFoundException;

   String softDeleteCategory(Integer categoryId) throws ResourceNotFoundException;

	String deleteCategory(Integer categoryId) throws ResourceNotFoundException;
}
