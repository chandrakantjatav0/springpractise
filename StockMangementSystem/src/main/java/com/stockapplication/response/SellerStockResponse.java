package com.stockapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerStockResponse {
	private Integer id;
	private long sellerstockquantity;

	// seller
	private Integer sellerid;
	private String sellername;
	private String location;
	private String username;
	private String password;

	// product
	private Integer productid;
	private String productname;
	private String description;
	private Double sellingPrice;
	private Double purchasePrice;
}