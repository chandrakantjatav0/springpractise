package com.food.ordering.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.system.entity.OrderLineItem;
import com.food.ordering.system.exception.ResourceNotFoundException;
import com.food.ordering.system.helper.OrderLineItemHelper;
import com.food.ordering.system.repository.OrderLineItemRepository;
import com.food.ordering.system.request.OrderLineItemRequest;
import com.food.ordering.system.response.OrderLineItemResponse;
import com.food.ordering.system.service.OrderLineItemService;

@Service
public class OrderLineItemServiceImpl implements OrderLineItemService {
	@Autowired
	OrderLineItemHelper orderLineItemHelper;
	@Autowired
	OrderLineItemRepository orderLineItemRepository;

	@Override
	public OrderLineItemResponse addOrders(OrderLineItemRequest orderLineItemRequest) throws ResourceNotFoundException {
		try {
			OrderLineItem orderLineItem = orderLineItemHelper
					.orderLineItemFromOrderLineItemRequest(orderLineItemRequest);
			orderLineItemRepository.save(orderLineItem);
			return orderLineItemHelper.orderLineItemResponseFromOrderLineItem(orderLineItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderLineItemResponse> getAllOrderLineItem() {
		List<OrderLineItem> list = orderLineItemRepository.findAll();
		return list.stream().map(orderLineItemHelper::orderLineItemResponseFromOrderLineItem)
				.collect(Collectors.toList());
	}

}
