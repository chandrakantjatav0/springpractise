package com.food.ordering.system.request;

import com.food.ordering.system.constants.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
	private Long id;
	private String name;
	private String email;
	private String location;
	private PaymentType paymenttype;
	private String username;
	private String password;

}