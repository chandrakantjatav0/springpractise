package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Customer;
import com.stockapplication.model.Order;
import com.stockapplication.model.Product;
import com.stockapplication.model.Seller;
import com.stockapplication.repository.CustomerRepository;
import com.stockapplication.repository.OrderRepository;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.repository.SellerRepository;
import com.stockapplication.request.OrderRequest;
import com.stockapplication.response.OrderResponse;

@Component
public class OrderHelper {
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	SellerRepository sellerRepo;
	@Autowired
	CustomerRepository customerRepo;

	public Order orderFromOrderRequest(OrderRequest orderRequest) throws ResourceNotFoundException {
		Order order = new Order();
		if(orderRequest.getId()==null)
		{
			order = orderRepo.findById(orderRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Order was created from this Id"));
		}
		
		order.setOrderQuantity(orderRequest.getOrderQuantity());

		Product product = productRepo.findById(orderRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No product was from this Id"));
		order.setProduct(product);

		Seller seller = sellerRepo.findById(orderRequest.getSellerid())
				.orElseThrow(() -> new ResourceNotFoundException("No seller  was from this Id"));
		order.setSeller(seller);

		Customer customer = customerRepo.findById(orderRequest.getCustomerid())
				.orElseThrow(() -> new ResourceNotFoundException("No customer was from this Id"));
		order.setCustomer(customer);
		
		return order;
	}

	public OrderResponse orderResponseFromOrder(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setOrderQuantity(order.getOrderQuantity());

		// product
		orderResponse.setProductid(order.getProduct().getId());
		orderResponse.setProductname(order.getProduct().getName());
		orderResponse.setDescription(order.getProduct().getDescription());
		orderResponse.setSellingPrice(order.getProduct().getSellingPrice());
		orderResponse.setPurchasePrice(order.getProduct().getPurchasePrice());
		// seller
		orderResponse.setSellerid(order.getSeller().getId());
		orderResponse.setSellername(order.getSeller().getName());
		orderResponse.setLocation(order.getSeller().getLocation());
		orderResponse.setSellerusername(order.getSeller().getUsername());
		orderResponse.setSellerpassword(order.getSeller().getPassword());
		// customer
		orderResponse.setCustomerid(order.getCustomer().getId());
		orderResponse.setCustomername(order.getCustomer().getName());
		orderResponse.setCustomeraddress(order.getCustomer().getAddress());
		orderResponse.setCustomerusername(order.getCustomer().getUsername());
		orderResponse.setCustomerpassword(order.getCustomer().getPassword());
		return orderResponse;
	}

}
