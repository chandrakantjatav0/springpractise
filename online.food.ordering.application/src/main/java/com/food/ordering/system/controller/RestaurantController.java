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
import com.food.ordering.system.request.RestaurantRequest;
import com.food.ordering.system.response.RestaurantResponse;
import com.food.ordering.system.serviceImpl.RestaurantServiceImpl;

@RestController
@RequestMapping("/api/foodorder/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantServiceImpl restaurantServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<RestaurantResponse> addRestaurant(@RequestBody RestaurantRequest restaurantRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(restaurantServiceImpl.addRestaurant(restaurantRequest), HttpStatus.CREATED);
	}

	@GetMapping("getAll")
	public List<RestaurantResponse> getAllRestaurant() {
		return restaurantServiceImpl.getAllRestaurant();

	}
}
