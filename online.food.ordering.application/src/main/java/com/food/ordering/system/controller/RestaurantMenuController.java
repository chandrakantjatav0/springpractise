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
import com.food.ordering.system.request.RestaurantMenuRequest;
import com.food.ordering.system.response.RestaurantMenuResponse;
import com.food.ordering.system.serviceImpl.RestaurantMenuServiceImpl;

@RestController
@RequestMapping("/api/foodorder/restaurantMenu")
public class RestaurantMenuController {
	@Autowired
	RestaurantMenuServiceImpl restaurantMenuServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<RestaurantMenuResponse> addMenu(@RequestBody RestaurantMenuRequest restaurantMenuRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(restaurantMenuServiceImpl.addMenu(restaurantMenuRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<RestaurantMenuResponse> getAllRestaurant() {
		return restaurantMenuServiceImpl.getAllMenuItem();
	}

}
