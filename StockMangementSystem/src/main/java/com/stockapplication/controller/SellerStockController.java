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
import com.stockapplication.request.SellerStockRequest;
import com.stockapplication.response.SellerStockResponse;
import com.stockapplication.service.impl.SellerStockServiceImpl;

@RestController
@RequestMapping("/api/stocknew/sellerStock")
public class SellerStockController {
	@Autowired
	SellerStockServiceImpl sellerStockService;

	@PostMapping("/allocateStock")
	public ResponseEntity<SellerStockResponse> allocateStock(@RequestBody SellerStockRequest sellerStockRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(sellerStockService.allocateStock(sellerStockRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<SellerStockResponse> getAllSellerStock() {
		return sellerStockService.getAllSellerStock();
	}

}
