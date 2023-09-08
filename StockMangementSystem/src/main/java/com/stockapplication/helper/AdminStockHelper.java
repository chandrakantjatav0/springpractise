package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Admin;
import com.stockapplication.model.AdminStock;
import com.stockapplication.model.Product;
import com.stockapplication.repository.AdminRepository;
import com.stockapplication.repository.AdminStockRepository;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.request.AdminStockRequest;
import com.stockapplication.response.AdminStockResponse;

@Component
public class AdminStockHelper {
	@Autowired
	private AdminStockRepository adminStockRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private AdminRepository adminRepo;

	public AdminStock adminStockFromAdminStockRequest(AdminStockRequest adminStockRequest)
			throws ResourceNotFoundException {
		AdminStock adminStock;
		if (adminStockRequest.getId() != null) {
			adminStock = adminStockRepo.findById(adminStockRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Stock wad found by this Id!.. "));
		} else {
			adminStock = new AdminStock();
		}

		adminStock.setStockquantity(adminStockRequest.getStockquantity());

		// product mapping
		Product product = productRepo.findById(adminStockRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No.product found by this Id!.."));
		adminStock.setProduct(product);

		// Admin mapping
		Admin admin = adminRepo.findById(adminStockRequest.getAdminid())
				.orElseThrow(() -> new ResourceNotFoundException("No. Admin found by this Id!.."));
		adminStock.setAdmin(admin);

		return adminStock;
	}

	public AdminStockResponse adminStockResponseFromAdminStock(AdminStock adminStock) {
		AdminStockResponse adminStockResponse = new AdminStockResponse();
		adminStockResponse.setId(adminStock.getId());
		adminStockResponse.setStockquantity(adminStock.getStockquantity());
		// product mapping
		adminStockResponse.setProductid(adminStock.getProduct().getId());
		adminStockResponse.setProductName(adminStock.getProduct().getName());
		adminStockResponse.setDescription(adminStock.getProduct().getDescription());
		adminStockResponse.setSellingPrice(adminStock.getProduct().getSellingPrice());
		adminStockResponse.setPurchasePrice(adminStock.getProduct().getPurchasePrice());
		// Admin mapping
		adminStockResponse.setAdminid(adminStock.getAdmin().getId());
		adminStockResponse.setAdminname(adminStock.getAdmin().getName());
		adminStockResponse.setUsername(adminStock.getAdmin().getUsername());
		adminStockResponse.setPassword(adminStock.getAdmin().getPassword());

		return adminStockResponse;
	}
}
