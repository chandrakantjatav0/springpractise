package com.food.ordering.system.entity;

import jakarta.persistence.CascadeType;
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
@Table(name = "restaurant_menu")
public class RestaurantMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Enumerated(EnumType.STRING)
//	@Column(name = "cuisine")
//	private CuisineType cuisine;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodItem_id")
	FoodItem foodItem;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	Restaurant restaurant;

}
