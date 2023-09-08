package com.stockapplication.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	private Integer id;
	private long orderQuantity;
	// customer
	private Integer customerid;
	// product
	private Integer productid;
	// seller
	private Integer sellerid;

}