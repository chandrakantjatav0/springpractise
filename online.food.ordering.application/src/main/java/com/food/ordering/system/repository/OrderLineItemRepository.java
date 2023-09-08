package com.food.ordering.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.food.ordering.system.entity.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

}