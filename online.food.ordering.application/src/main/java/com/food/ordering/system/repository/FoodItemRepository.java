package com.food.ordering.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.ordering.system.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}
