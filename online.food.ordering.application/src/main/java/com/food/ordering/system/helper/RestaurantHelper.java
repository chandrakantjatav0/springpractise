package com.food.ordering.system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.Restaurant;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.RestaurantRepository;
import com.food.ordering.system.request.RestaurantRequest;
import com.food.ordering.system.response.RestaurantResponse;

@Component
public class RestaurantHelper {
	@Autowired
	RestaurantRepository restaurantRepository;

	public Restaurant restaurantFromRestaurantRequest(RestaurantRequest restaurantRequest)
			throws ResourceNotFoundException {
		Restaurant restaurant;
		if (restaurantRequest.getId() != null) {
			restaurant = this.restaurantRepository.findById(restaurantRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Restaurant Found By this Id!."));
		} else {
			restaurant = new Restaurant();
		}
		restaurant.setName(restaurantRequest.getName());
		restaurant.setLocation(restaurantRequest.getLocation());
		return restaurant;
	}

//	private CuisineType mapCuisine(String cuisine) {
//		return CuisineType.valueOf(cuisine.toUpperCase());
//	}

	public RestaurantResponse restaurantResponseFromRestaurant(Restaurant restaurant) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurantResponse.setId(restaurant.getId());
		restaurantResponse.setName(restaurant.getName());
		restaurantResponse.setLocation(restaurant.getLocation());
		return restaurantResponse;

	}

}
