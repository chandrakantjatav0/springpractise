package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.AdminStock;
import com.stockapplication.request.AdminStockRequest;
import com.stockapplication.response.AdminStockResponse;

public interface AdminStockService {

	AdminStockResponse addStock(AdminStockRequest adminStockRequest) throws ResourceNotFoundException;

	List<AdminStockResponse> getAllAdminStock();
	
	AdminStock findByProductId(Integer id);
}
