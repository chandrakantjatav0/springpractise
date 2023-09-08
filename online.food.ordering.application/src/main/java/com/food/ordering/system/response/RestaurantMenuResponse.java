package com.food.ordering.system.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantMenuResponse {
	private Long id;
	//private CuisineType cuisine;

	// fooditem
	private Long fooditemid;
	private String name;
	private String description;
	private double price;

	// restaurant
	private Long restaurantid;
	private String restaurantname;
	private String location;
}
