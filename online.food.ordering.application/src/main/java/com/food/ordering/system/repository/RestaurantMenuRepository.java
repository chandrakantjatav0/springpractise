package com.food.ordering.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.ordering.system.entity.RestaurantMenu;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

	RestaurantMenu findByRestaurantIdAndFoodItemId(Long restaurantId, Long foodItemId);

}
