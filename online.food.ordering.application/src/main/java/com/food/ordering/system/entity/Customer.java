package com.food.ordering.system.entity;

import com.food.ordering.system.constants.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String location;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_type")
	private PaymentType paymenttype;
	private String username;
	private String password;

//	// order
//	@OneToMany(mappedBy = "customer")
//	List<Order> orders;

}
