package com.food.ordering.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.request.FoodItemRequest;
import com.food.ordering.system.response.FoodItemResponse;
import com.food.ordering.system.serviceImpl.FoodItemServiceImpl;

@RestController
@RequestMapping("/api/foodorder/fooditem")
public class FoodItemController {
	@Autowired
	FoodItemRepository foodItemRepository;
	@Autowired
	FoodItemServiceImpl foodItemServiceImpl;

	@PostMapping("create")
	public ResponseEntity<FoodItemResponse> addFoodItem(@RequestBody FoodItemRequest foodItemRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(foodItemServiceImpl.addFoodItem(foodItemRequest), HttpStatus.CREATED);
	}

	@GetMapping("getAll")
	public List<FoodItemResponse> getAllFoodItem() {
		return foodItemServiceImpl.getAllFoodItem();
	}
}
