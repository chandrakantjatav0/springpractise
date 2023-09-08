package com.food.ordering.system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.request.FoodItemRequest;
import com.food.ordering.system.response.FoodItemResponse;

@Component
public class FoodItemHelper {
	@Autowired
	FoodItemRepository foodItemRepository;
//	@Autowired
//	RestaurantMenuRepository restaurantMenuRepository;

	public FoodItem foodItemFromFoodItemRequest(FoodItemRequest foodItemRequest) throws ResourceNotFoundException {
		FoodItem foodItem;
		if (foodItemRequest.getId() != null) {
			foodItem = this.foodItemRepository.findById(foodItemRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Food item found byu this Id!.."));
		} else {
			foodItem = new FoodItem();
		}
		foodItem.setName(foodItemRequest.getName());
		foodItem.setDescription(foodItemRequest.getDescription());
		foodItem.setPrice(foodItemRequest.getPrice());
		return foodItem;

	}

	public FoodItemResponse foodItemResponseFromFoodItem(FoodItem foodItem) {
		FoodItemResponse foodItemResponse = new FoodItemResponse();
		foodItemResponse.setId(foodItem.getId());
		foodItemResponse.setName(foodItem.getName());
		foodItemResponse.setDescription(foodItem.getDescription());
		foodItemResponse.setPrice(foodItem.getPrice());
		// restaurantMenu
//		foodItemResponse.setRestaurantMenuid(foodItem.getId());
		return foodItemResponse;
	}

}
