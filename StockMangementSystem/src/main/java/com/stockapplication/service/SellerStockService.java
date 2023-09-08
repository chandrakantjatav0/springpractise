package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.SellerStock;
import com.stockapplication.request.SellerStockRequest;
import com.stockapplication.response.SellerStockResponse;

public interface SellerStockService {

	SellerStockResponse allocateStock(SellerStockRequest sellerStockRequest) throws ResourceNotFoundException;

	List<SellerStockResponse> getAllSellerStock();

	SellerStock findByProductIdAndSellerId(Integer productid, Integer sellerid);

	SellerStock findByProductId(Integer productid);

}
