package com.food.ordering.system.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "order_line_item")
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allOrdersQuantity")
	private Long id;
	private Long quantity;
	
	private Double amount = 0.0;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodItem_id")
	private FoodItem foodItem;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id")
	Order order;
}
