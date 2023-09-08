package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.FoodItemHelper;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.request.FoodItemRequest;
import com.food.ordering.system.response.FoodItemResponse;
import com.food.ordering.system.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	@Autowired
	FoodItemRepository foodItemRepository;
	@Autowired
	FoodItemHelper foodItemHelper;

	@Override
	public FoodItemResponse addFoodItem(FoodItemRequest foodItemRequest) throws ResourceNotFoundException {
		FoodItem foodItem = foodItemHelper.foodItemFromFoodItemRequest(foodItemRequest);
		foodItemRepository.save(foodItem);
		return foodItemHelper.foodItemResponseFromFoodItem(foodItem);
	}

	@Override
	public List<FoodItemResponse> getAllFoodItem() {
		List<FoodItem> allItem = foodItemRepository.findAll();
		return allItem.stream().map(foodItemHelper::foodItemResponseFromFoodItem).collect(Collectors.toList());
	}

	@Override
	public FoodItem findById(Long productId) {
		 Optional<FoodItem> optional = foodItemRepository.findById(productId);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		return null;
	}

}
