package com.stockapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponse {
	private Integer id;
	private String name;
	private String location;
	private String username;
	private String password;
}
