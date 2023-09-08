package com.stockapplication.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerStockRequest {
	private Integer id;
	private long sellerstockquantity;
	
	//seller 
	private Integer sellerid;
	
	//product 
	private Integer productid;
}