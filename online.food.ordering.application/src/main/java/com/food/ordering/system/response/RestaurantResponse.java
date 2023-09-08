package com.food.ordering.system.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
	private Long id;
	private String name;
	private String location;


}
