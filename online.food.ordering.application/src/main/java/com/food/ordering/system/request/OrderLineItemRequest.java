package com.food.ordering.system.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemRequest {
	private Long id;
	private Long quantity;

	// fooditem
	private Long fooditemid;

	// order
	private Long orderId;

}
