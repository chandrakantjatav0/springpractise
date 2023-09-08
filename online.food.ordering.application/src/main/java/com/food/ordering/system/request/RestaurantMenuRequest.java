package com.food.ordering.system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantMenuRequest {
	private Long id;
	//private CuisineType cuisine;

	/// fooditem
	private Long fooditemid;
	// restaurant
	private Long restaurantid;
}
