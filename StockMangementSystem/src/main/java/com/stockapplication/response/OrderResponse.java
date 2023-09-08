package com.stockapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	
	private Integer id;
	private long orderQuantity;

	// customer
	private Integer customerid;
	private String customername;
	private String customeraddress;
	private String customerusername;
	private String customerpassword;
	// product
	private Integer productid;
	private String productname;
	private String description;
	private Double sellingPrice;
	private Double purchasePrice;
	// seller
	private Integer sellerid;
	private String sellername;
	private String location;
	private String sellerusername;
	private String sellerpassword;
}