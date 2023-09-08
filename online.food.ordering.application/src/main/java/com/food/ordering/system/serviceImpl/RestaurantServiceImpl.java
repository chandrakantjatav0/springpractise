package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.Restaurant;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.RestaurantHelper;
import com.food.ordering.system.repository.RestaurantRepository;
import com.food.ordering.system.request.RestaurantRequest;
import com.food.ordering.system.response.RestaurantResponse;
import com.food.ordering.system.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	RestaurantHelper restaurantHelper;

	@Override
	public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantHelper.restaurantFromRestaurantRequest(restaurantRequest);
		restaurantRepository.save(restaurant);
		return restaurantHelper.restaurantResponseFromRestaurant(restaurant);
	}

	@Override
	public List<RestaurantResponse> getAllRestaurant() {
		List<Restaurant> restaurant = restaurantRepository.findAll();
		return restaurant.stream().map(restaurantHelper::restaurantResponseFromRestaurant).collect(Collectors.toList());
	}

}
