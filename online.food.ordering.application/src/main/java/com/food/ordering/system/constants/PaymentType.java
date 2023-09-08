package com.food.ordering.system.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
	UPI("UPI"), COD("COD");

	String displayname;
}

