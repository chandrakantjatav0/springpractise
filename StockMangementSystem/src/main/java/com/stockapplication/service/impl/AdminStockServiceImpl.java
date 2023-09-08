 package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.AdminStockHelper;
import com.stockapplication.model.Admin;
import com.stockapplication.model.AdminStock;
import com.stockapplication.model.Product;
import com.stockapplication.repository.AdminRepository;
import com.stockapplication.repository.AdminStockRepository;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.request.AdminStockRequest;
import com.stockapplication.response.AdminStockResponse;
import com.stockapplication.service.AdminStockService;

@Service
public class AdminStockServiceImpl implements AdminStockService {
	@Autowired
	private AdminStockRepository adminStockRepo;
	@Autowired
	private AdminStockHelper adminStockHelper;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public AdminStockResponse addStock(AdminStockRequest adminStockRequest) throws ResourceNotFoundException {

		Product product = productRepo.findById(adminStockRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No product found by this Id"));

		Admin admin = adminRepo.findById(adminStockRequest.getAdminid())
				.orElseThrow(() -> new ResourceNotFoundException("No Admin was  found by this Id"));

		AdminStock adminStock = adminStockRepo.findByProductIdandAdminId(adminStockRequest.getProductid(),
				adminStockRequest.getAdminid());
		if (adminStock == null) {
			adminStock = new AdminStock();
			// adminStock.setStockquantity(null);
			adminStock.setStockquantity(adminStockRequest.getStockquantity());
			adminStock.setProduct(product);
			adminStock.setId(adminStockRequest.getId());
			adminStock.setAdmin(admin);

		} else {
			Long stockquantity = adminStock.getStockquantity();
			adminStock.setStockquantity(stockquantity + adminStockRequest.getStockquantity());
		}
		adminStockRepo.save(adminStock);
		return adminStockHelper.adminStockResponseFromAdminStock(adminStock);
	}

	@Override
	public List<AdminStockResponse> getAllAdminStock() {
		List<AdminStock> list = adminStockRepo.findAll();
		return list.stream().map(adminStockHelper::adminStockResponseFromAdminStock).collect(Collectors.toList());
	}

	@Override
	public AdminStock findByProductId(Integer id) {
		return adminStockRepo.findByProductId(id);
	}

}
