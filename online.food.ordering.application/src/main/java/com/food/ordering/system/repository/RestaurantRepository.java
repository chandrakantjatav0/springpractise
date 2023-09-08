package com.food.ordering.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.ordering.system.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	//CuisineType mapCuisine(String cuisine);
}
