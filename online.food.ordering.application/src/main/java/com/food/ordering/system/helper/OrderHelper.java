package com.food.ordering.system.helper;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.entity.Customer;
import com.food.ordering.system.entity.FoodItem;
import com.food.ordering.system.entity.Order;
import com.food.ordering.system.entity.OrderLineItem;
import com.food.ordering.system.entity.RestaurantMenu;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.repository.CustomerRepository;
import com.food.ordering.system.repository.OrderLineItemRepository;
import com.food.ordering.system.repository.OrderRepository;
import com.food.ordering.system.repository.RestaurantMenuRepository;
import com.food.ordering.system.request.OrderRequest;
import com.food.ordering.system.request.ProductQuantityRequest;
import com.food.ordering.system.response.OrderResponse;
import com.food.ordering.system.service.FoodItemService;

@Component
public class OrderHelper {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RestaurantMenuRepository restaurantMenuRepository;
	@Autowired
	FoodItemService foodItemService;
	@Autowired
	OrderLineItemRepository orderLineItemRepository;

	public Order orderFromOrderRequest(OrderRequest orderRequest) throws ResourceNotFoundException {
		Order order;
		if (orderRequest.getId() != null) {
			order = this.orderRepository.findById(orderRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Order Was Created by this Id!.."));
		} else {
			order = new Order();
		}

		// order.setTotalAmount(orderRequest.getTotalAmount());
//		order.setPrice(orderRequest.getPrice());
		order.setOrderdate(new Date());
		order.setOrderstatus(orderRequest.getOrderstatus());
		order.setTotalAmount(orderRequest.getTotalAmount());

		// Customer
		Customer customer = customerRepository.findById(orderRequest.getCustomerid())
				.orElseThrow(() -> new ResourceNotFoundException("No Customer was found by this Id!.."));
		order.setCustomer(customer);

		// restaurantMenu
		RestaurantMenu restaurantMenu = restaurantMenuRepository.findById(orderRequest.getRestaurantmenuid())
				.orElseThrow(() -> new ResourceNotFoundException("No menu was found in this Restaurant by this Id!.."));
		order.setRestaurantMenu(restaurantMenu);
		Double totalAmount=0.00;
		
		List<ProductQuantityRequest> productQuantityRequest = orderRequest.getProductQuantityRequest();
		for (ProductQuantityRequest productQuantity : productQuantityRequest) {
			OrderLineItem orderLineItem = new OrderLineItem();
			orderLineItem.setOrder(order);
			orderLineItem.setQuantity(productQuantity.getQuantity());
			FoodItem foodItem = foodItemService.findById(productQuantity.getProductId());
			orderLineItem.setFoodItem(foodItem);
			totalAmount=totalAmount+foodItem.getPrice()*productQuantity.getQuantity();
			orderLineItemRepository.save(orderLineItem);
		}
		order.setTotalAmount(totalAmount);
		return order;
	}

	public OrderResponse orderResponseFromOrder(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setTotalAmount(order.getTotalAmount());
		orderResponse.setOrderdate(order.getOrderdate());
		orderResponse.setOrderstatus(order.getOrderstatus());
		// customer
		orderResponse.setCustomerid(order.getCustomer().getId());
		orderResponse.setCustomername(order.getCustomer().getName());
		orderResponse.setCustomeremail(order.getCustomer().getEmail());
		orderResponse.setCustomerlocation(order.getCustomer().getLocation());
		orderResponse.setPaymenttype(order.getCustomer().getPaymenttype());
		orderResponse.setCustomerusername(order.getCustomer().getUsername());
		orderResponse.setCustomerpassword(order.getCustomer().getPassword());
		// restaurantMenu
		orderResponse.setRestaurantmenuid(order.getRestaurantMenu().getId());
		// orderResponse.setCuisine(order.getRestaurantMenu().getCuisine());
		return orderResponse;

	}
}
