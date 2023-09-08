package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.RestaurantRequest;
import com.food.ordering.system.response.RestaurantResponse;

public interface RestaurantService {

	RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) throws ResourceNotFoundException;

	List<RestaurantResponse> getAllRestaurant();

}
