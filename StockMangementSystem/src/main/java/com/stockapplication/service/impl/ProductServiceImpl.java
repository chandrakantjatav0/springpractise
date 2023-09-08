package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.ProductHelper;
import com.stockapplication.model.Product;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.request.ProductRequest;
import com.stockapplication.response.ProductResponse;
import com.stockapplication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductHelper productHelper;
	@Autowired
	ProductRepository productRepo;

	@Override
	public ProductResponse addProduct(ProductRequest productRequest) throws ResourceNotFoundException {
		Product product = productHelper.productFromProductRequest(productRequest);
		productRepo.save(product);
		return productHelper.productResponseFromProduct(product);
	}

	@Override
	public List<ProductResponse> getAllProduct() {
		List<Product> list = productRepo.findAll();
		return list.stream().map(productHelper::productResponseFromProduct).collect(Collectors.toList());
	}

}
