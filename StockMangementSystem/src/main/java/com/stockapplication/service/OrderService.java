package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Order;
import com.stockapplication.request.OrderRequest;
import com.stockapplication.response.OrderResponse;

public interface OrderService {

	OrderResponse orderByCustomer(OrderRequest orderRequest) throws ResourceNotFoundException;

	Order findByProductIdandSellerId(Integer productid, Integer sellerid);

	List<OrderResponse> getAllOrders();

}
