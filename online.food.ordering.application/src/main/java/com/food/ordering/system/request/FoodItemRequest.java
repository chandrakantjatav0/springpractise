package com.food.ordering.system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemRequest {
	private Long id;
	private String name;
	private String description;
	private Double price;

}