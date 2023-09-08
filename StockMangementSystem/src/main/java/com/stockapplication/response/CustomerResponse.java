package com.stockapplication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
	private Integer id;
	private String name;
	private String address;
	private String username;
	private String password;
}
