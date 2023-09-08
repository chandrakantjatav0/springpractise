package com.food.ordering.system.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuantityRequest {
	
	Long productId;
	
	Long quantity;

}
