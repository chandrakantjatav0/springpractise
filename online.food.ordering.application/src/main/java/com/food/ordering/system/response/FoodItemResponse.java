package com.food.ordering.system.response;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fooditem")
public class FoodItemResponse {
	private Long id;
	private String name;
	private String description;
	private Double price;
}