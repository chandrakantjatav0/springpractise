package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.Order;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.OrderHelper;
import com.food.ordering.system.repository.FoodItemRepository;
import com.food.ordering.system.repository.OrderRepository;
import com.food.ordering.system.request.OrderRequest;
import com.food.ordering.system.response.OrderResponse;
import com.food.ordering.system.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderHelper orderHelper;
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) throws ResourceNotFoundException {
		Order order;
		order = orderHelper.orderFromOrderRequest(orderRequest);
		orderRepository.save(order);
		// OrderLineItem
		return orderHelper.orderResponseFromOrder(order);
	}

	@Override
	public List<OrderResponse> getAllOrders() {
		List<Order> list = orderRepository.findAll();
		return list.stream().map(orderHelper::orderResponseFromOrder).collect(Collectors.toList());
	}

	@Override
	public Order findByCustomerIdandRestauranMenutId(Long customerId, Long restaurantMenuId) {
		return orderRepository.findByCustomer_IdAndRestaurantMenu_Id(customerId, restaurantMenuId);
	} 

//	@Override
//	public String  CalculateTotalAmount(OrderRequest orderRequest) throws ResourceNotFoundException {
//		Order order = orderRepository.findById(orderRequest.getId())
//				.orElseThrow(() -> new ResourceNotFoundException("No order was generted by this Id!.."));
//		double totalAmount = 0.0;
//		 StringBuilder message = new StringBuilder("Namaste \n Your Ordered Items:\n");
//		// List<FoodItemRequest> foodItems = orderRequest.getFoodItems();
//		 // orderRequest.getQuantity();
//	  List<FoodItem> foodItems = foodItemRepository.findAll();
////		for(OrderRequest item : orderRequest.getQuantity()) {
////			FoodItem foodItem = foodItemRepository.findById(item.getId())
////					.orElseThrow(() -> new ResourceNotFoundException("No foodItem was found  by this Id!.."));
//		double itemAmount = foodItem.getPrice() * orderRequest.getQuantity();
//		  message.append(foodItem.getName())
//          .append(" (Quantity: ")
//          .append(orderRequest.getQuantity())
//          .append(") - Price: $")
//          .append(foodItem.getPrice())
//          .append(" - Subtotal: $")
//          .append(itemAmount)
//          .append("\n");
//		totalAmount += itemAmount;
//		}
//		 message.append("\nTotal Amount: $").append(totalAmount);
//		order.setTotalAmount(totalAmount);
//		orderRepository.save(order);
//		return message.toString() ;
//	}

}
