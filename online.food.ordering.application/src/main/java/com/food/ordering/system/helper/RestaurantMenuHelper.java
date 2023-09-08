package com.food.ordering.system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.entity.Restaurant;
import com.food.ordering.system.entity.RestaurantMenu;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.repository.RestaurantMenuRepository;
import com.food.ordering.system.repository.RestaurantRepository;
import com.food.ordering.system.request.RestaurantMenuRequest;
import com.food.ordering.system.response.RestaurantMenuResponse;

@Component
public class RestaurantMenuHelper {
	@Autowired
	RestaurantMenuRepository restaurantMenuRepository;
	@Autowired
	FoodItemRepository foodItemRepository;
	@Autowired
	RestaurantRepository restaurantRepository;

	public RestaurantMenu restaurantMenuFromRestaurantMenuRequest(RestaurantMenuRequest restaurantMenuRequest)
			throws ResourceNotFoundException {
		RestaurantMenu restaurantMenu;
		if (restaurantMenuRequest.getId() != null) {
			restaurantMenu = this.restaurantMenuRepository.findById(restaurantMenuRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No item found by this id on Restaurant Menu!."));
		} else {
			restaurantMenu = new RestaurantMenu();
		}
		//restaurantMenu.setCuisine(restaurantMenuRequest.getCuisine());

		// fooditem
		FoodItem foodItem = foodItemRepository.findById(restaurantMenuRequest.getFooditemid())
				.orElseThrow(() -> new ResourceNotFoundException("No fooditem found by this id on Restaurant Menu!."));
		restaurantMenu.setFoodItem(foodItem);

		// restaurant
		Restaurant restaurant = restaurantRepository.findById(restaurantMenuRequest.getRestaurantid()).orElseThrow(
				() -> new ResourceNotFoundException("No restaurant  found by this id on Restaurant Menu!."));
		restaurantMenu.setRestaurant(restaurant);

		return restaurantMenu;
//---------------------------------------------
//		list fooditem empty
//		foreach fooditemid 
//		emptyu list mei add (repo.findbyid(id)
//		empty list mei fooditem RE
//		restaurnt mei fooditem set 
//
//		List<Long> fooditemid = restaurantMenuRequest.getFooditemid();
//		List<FoodItem> foodItems = new ArrayList<>();
//		for (Long id : fooditemid) {
//			foodItems.add(foodItemRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("no food item found by this id")));
//		}
//		restaurantMenu.setFoodItems(foodItems);

//		restaurantMenu.setCuisine(CuisineType.CHINESE);

	}

	public RestaurantMenuResponse restaurantMenuResponseFromRestaurantMenu(RestaurantMenu restaurantMenu) {
		RestaurantMenuResponse restaurantMenuResponse = new RestaurantMenuResponse();
		restaurantMenuResponse.setId(restaurantMenu.getId());
		//restaurantMenuResponse.setCuisine(restaurantMenu.getCuisine());

//		//foodItem
//		List<FoodItem> foodItems = restaurantMenu.getFoodItems();
////		List<String> names= new ArrayList<>();
//		for (FoodItem i : foodItems) {
//			restaurantMenuResponse.setFooditemid(i.getId());
//			restaurantMenuResponse.setName(i.getName());
//			restaurantMenuResponse.setDescription(i.getDescription());
//			restaurantMenuResponse.setPrice(i.getPrice());
//		}
		// foodItem
		restaurantMenuResponse.setFooditemid(restaurantMenu.getFoodItem().getId());
		restaurantMenuResponse.setName(restaurantMenu.getFoodItem().getName());
		restaurantMenuResponse.setDescription(restaurantMenu.getFoodItem().getDescription());
		restaurantMenuResponse.setPrice(restaurantMenu.getFoodItem().getPrice());
	
		// restaurant
		restaurantMenuResponse.setRestaurantid(restaurantMenu.getRestaurant().getId());
		restaurantMenuResponse.setRestaurantname(restaurantMenu.getRestaurant().getName());
		restaurantMenuResponse.setLocation(restaurantMenu.getRestaurant().getLocation());
		return restaurantMenuResponse;
	}
}
