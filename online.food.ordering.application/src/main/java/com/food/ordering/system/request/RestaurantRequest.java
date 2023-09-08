package com.food.ordering.system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
	private Long id;
	private String name;
	private String location;

}
