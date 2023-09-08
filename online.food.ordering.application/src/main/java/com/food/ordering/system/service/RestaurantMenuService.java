package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.entity.RestaurantMenu;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.request.RestaurantMenuRequest;
import com.food.ordering.system.response.RestaurantMenuResponse;

public interface RestaurantMenuService {

	RestaurantMenuResponse addMenu(RestaurantMenuRequest restaurantMenuRequest) throws ResourceNotFoundException;

	List<RestaurantMenuResponse> getAllMenuItem();

	RestaurantMenu findByRestaurantIdandFoodItemId(Long restaurantid, Long fooditemid);

}
