package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.ProductRequest;
import com.stockapplication.response.ProductResponse;

public interface ProductService {
	
	
	ProductResponse addProduct(ProductRequest productRequest) throws ResourceNotFoundException;

	List<ProductResponse> getAllProduct();

}
