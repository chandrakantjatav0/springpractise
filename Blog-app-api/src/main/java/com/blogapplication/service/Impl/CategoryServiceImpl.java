package com.blogapplication.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.helper.CategoryHelper;
import com.blogapplication.model.Category;
import com.blogapplication.repostitory.CategoryRepository;
import com.blogapplication.request.CategoryRequest;
import com.blogapplication.response.CategoryResponse;
import com.blogapplication.service.CategoryService;

import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryHelper categoryHelper;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public CategoryResponse addCategory(CategoryRequest categoryRequest) throws ResourceNotFoundException {
		Category category = categoryHelper.categoryFromCategoryRequest(categoryRequest);
		categoryRepo.save(category);
		return categoryHelper.categoryResponseFromCategory(category);
	}

	@Override
	public List<CategoryResponse> getAllCategory() {
		List<Category> list = categoryRepo.findAll();
		return list.stream().map(categoryHelper::categoryResponseFromCategory).collect(Collectors.toList());

	}

	@Override
	public CategoryResponse getCategoryById(Integer categoryId) throws ResourceNotFoundException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category id not found"));
		return categoryHelper.categoryResponseFromCategory(category);
	}

	@Override
	public String softDeleteCategory(Integer categoryId) throws ResourceNotFoundException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not Found"));
		category.setDeleted(true);
		categoryRepo.save(category);
		return "soft deleted this Category";

	}
	@Override
	public String deleteCategory(Integer categoryId) throws ResourceNotFoundException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not Found"));
		categoryRepo.delete(category);
		return "Category Deleted SucessFully";
	}

}
