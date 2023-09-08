package com.stockapplication.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminStockRequest {

	private Integer id;
	private long stockquantity;
	
	//product
	private  Integer productid;
	//Admin 
	private Integer adminid;

}