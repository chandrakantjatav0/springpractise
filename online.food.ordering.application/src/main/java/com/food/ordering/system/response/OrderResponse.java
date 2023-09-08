package com.food.ordering.system.response;

import java.util.Date;

import com.food.ordering.system.constants.OrderStatus;
import com.food.ordering.system.constants.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	private Long id;
	//private Integer quantity;
	private Double totalAmount = 0.0;
	private Date orderdate;
	private OrderStatus orderstatus;

	// customer
	private Long customerid;
	private String customername;
	private String customeremail;
	private String customerlocation;
	private PaymentType paymenttype;
	private String customerusername;
	private String customerpassword;

	// restaurantMenu
	private Long restaurantmenuid;
	//private CuisineType cuisine;
}