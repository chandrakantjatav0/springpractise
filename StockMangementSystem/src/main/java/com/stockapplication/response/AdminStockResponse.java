package com.stockapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminStockResponse {

	private Integer id;
	private long stockquantity;

	// product
	private Integer productid;
	private String productName;
	private String description;
	private Double sellingPrice;
	private Double purchasePrice;

	// Admin
	private Integer adminid;
	private String adminname;
	private String username;
	private String password;
}