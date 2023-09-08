package com.food.ordering.system.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
	PLACED("PLACED"), PENDING("PENDING"), DELIVERED("DELIVERED"), CONFIRMED("CONFIRMED");

	String displayname;
}