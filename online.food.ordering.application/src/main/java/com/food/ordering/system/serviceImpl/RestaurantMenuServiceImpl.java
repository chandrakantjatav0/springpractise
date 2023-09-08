package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.RestaurantMenu;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.RestaurantMenuHelper;
import com.food.ordering.system.repository.RestaurantMenuRepository;
import com.food.ordering.system.request.RestaurantMenuRequest;
import com.food.ordering.system.response.RestaurantMenuResponse;
import com.food.ordering.system.service.RestaurantMenuService;

@Service
public class RestaurantMenuServiceImpl implements RestaurantMenuService {
	@Autowired
	RestaurantMenuRepository restaurantMenuRepository;
	@Autowired
	RestaurantMenuHelper restaurantMenuHelper;

	@Override
	public RestaurantMenuResponse addMenu(RestaurantMenuRequest restaurantMenuRequest)
			throws ResourceNotFoundException {
		RestaurantMenu restaurantMenu = restaurantMenuHelper
				.restaurantMenuFromRestaurantMenuRequest(restaurantMenuRequest);
		restaurantMenuRepository.save(restaurantMenu);
		return restaurantMenuHelper.restaurantMenuResponseFromRestaurantMenu(restaurantMenu);
	}

	@Override
	public List<RestaurantMenuResponse> getAllMenuItem() {
		List<RestaurantMenu> list = restaurantMenuRepository.findAll();
		return list.stream().map(restaurantMenuHelper::restaurantMenuResponseFromRestaurantMenu)
				.collect(Collectors.toList());
	}

	@Override
	public RestaurantMenu findByRestaurantIdandFoodItemId(Long restaurantid, Long fooditemid) {
		return restaurantMenuRepository.findByRestaurantIdAndFoodItemId(restaurantid, fooditemid);
	}

}
