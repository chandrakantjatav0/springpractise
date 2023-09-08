package com.stockapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.ProductRequest;
import com.stockapplication.response.ProductResponse;
import com.stockapplication.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api/stocknew/product")
public class ProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(productServiceImpl.addProduct(productRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<ProductResponse> getAllProduct() {
		return productServiceImpl.getAllProduct();
	}

}
