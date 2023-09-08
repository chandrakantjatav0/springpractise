package com.food.ordering.system.response;

import java.util.Date;

import com.food.ordering.system.constants.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemResponse {
	private Long id;
	private Long quantity;
	// fooditem
	private Long fooditemid;
	private String name;
	private String description;

	// order
	private Long orderid;
	//private Integer orderquantity;
	private Double totalAmount;
	private Date orderdate;
	private OrderStatus orderstatus;
}
