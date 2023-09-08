package com.food.ordering.system.request;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.food.ordering.system.constants.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
	private Long id;
	List<ProductQuantityRequest> ProductQuantityRequest;
	private Double totalAmount;
	private Date orderdate;
	private OrderStatus orderstatus;

	// customer
	private Long customerid;
	// restaurantMenu
	private Long restaurantmenuid;
}