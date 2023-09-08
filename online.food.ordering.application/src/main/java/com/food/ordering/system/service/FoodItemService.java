package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.FoodItemRequest;
import com.food.ordering.system.response.FoodItemResponse;

public interface FoodItemService {

	FoodItemResponse addFoodItem(FoodItemRequest foodItemRequest) throws ResourceNotFoundException;

	List<FoodItemResponse> getAllFoodItem();

	FoodItem findById(Long productId);
	
	

}
