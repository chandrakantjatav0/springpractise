package com.stockapplication.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest {
	private Integer id;
	private String name;
	private String location;
	private String username;
	private String password;
}
