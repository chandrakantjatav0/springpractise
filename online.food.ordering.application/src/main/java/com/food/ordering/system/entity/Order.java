package com.food.ordering.system.entity;

import java.util.Date;

import com.food.ordering.system.constants.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = " orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double totalAmount = 0.0;

	@Column(name = "order-date")
	private Date orderdate;
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus orderstatus;

	// customer
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	// restaurantMenu
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantMenu_id")
	RestaurantMenu restaurantMenu;

}
