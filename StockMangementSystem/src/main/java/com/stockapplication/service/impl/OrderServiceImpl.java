package com.stockapplication.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.OrderHelper;
import com.stockapplication.model.Customer;
import com.stockapplication.model.Order;
import com.stockapplication.model.Product;
import com.stockapplication.model.Seller;
import com.stockapplication.model.SellerStock;
import com.stockapplication.repository.CustomerRepository;
import com.stockapplication.repository.OrderRepository;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.repository.SellerStockRepository;
import com.stockapplication.request.OrderRequest;
import com.stockapplication.response.OrderResponse;
import com.stockapplication.service.OrderService;
import com.stockapplication.service.SellerService;
import com.stockapplication.service.SellerStockService;;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderHelper orderHelper;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	ProductRepository productRepo;
//	@Autowired
//	SellerRepository sellerRepo;
	@Autowired
	SellerStockRepository sellerStockRepo;
	@Autowired
	SellerStockService sellerStockService;
	@Autowired
	SellerService sellerService;

	@SuppressWarnings("null")
	@Override
	public OrderResponse orderByCustomer(OrderRequest orderRequest) throws ResourceNotFoundException {

		Order order = null;

		Long stocks = 0l;

		Seller seller = sellerService.findById(orderRequest.getSellerid());

		Product product = productRepo.findById(orderRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No Product was Found by this Id!.."));

		Customer customer = customerRepo.findById(orderRequest.getCustomerid())
				.orElseThrow(() -> new ResourceNotFoundException("No Customer was Found by this Id!.."));

		SellerStock sellerStock = sellerStockService.findByProductIdAndSellerId(orderRequest.getProductid(),
				orderRequest.getSellerid());

		if (sellerStock == null) {
			sellerStock = new SellerStock();
			sellerStock.setProduct(product);
			sellerStock.setSeller(seller);

		} else {
			if (sellerStock.getSellerstockquantity() < orderRequest.getOrderQuantity()) {
				throw new ResourceNotFoundException("Quantity not available!..");
			}
		}

		// order = orderRepo.findByProductIdandSellerId(orderRequest.getProductid(),
		// orderRequest.getSellerid());

		if (orderRequest.getId() != null && orderRequest.getId() > 0) {
			Optional<Order> optional = orderRepo.findById(orderRequest.getId());
			if (optional.isPresent()) {
				order = optional.get();
				order.setOrderQuantity(stocks);
				order.setOrderQuantity(order.getOrderQuantity() + orderRequest.getOrderQuantity());
			}
		}
		if (order == null) {
			order = new Order();
			order.setProduct(product);
			order.setCustomer(customer);
			order.setSeller(seller);
			order.setOrderQuantity(orderRequest.getOrderQuantity());
		}

		stocks = sellerStock.getSellerstockquantity() != null ? sellerStock.getSellerstockquantity() : 0l;

		sellerStock.setSellerstockquantity(stocks - orderRequest.getOrderQuantity());

		orderRepo.save(order);
		sellerStockRepo.save(sellerStock);
		return orderHelper.orderResponseFromOrder(order);
	}

	@Override
	public Order findByProductIdandSellerId(Integer productid, Integer sellerid) {
		return orderRepo.findByProductIdandSellerId(productid, sellerid);
	}

	@Override
	public List<OrderResponse> getAllOrders() {
		List<Order> orderList = orderRepo.findAll();
		return orderList.stream().map(orderHelper::orderResponseFromOrder).collect(Collectors.toList());
	}

}
