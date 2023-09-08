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
import com.stockapplication.request.AdminStockRequest;
import com.stockapplication.response.AdminStockResponse;
import com.stockapplication.service.impl.AdminStockServiceImpl;

@RestController
@RequestMapping("/api/stocknew/adminStock")
public class AdminStockController {
	@Autowired
	private AdminStockServiceImpl adminStockServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<AdminStockResponse> addStock(@RequestBody AdminStockRequest adminStockRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(adminStockServiceImpl.addStock(adminStockRequest),
				HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<AdminStockResponse> getAdminStock() {
		return adminStockServiceImpl.getAllAdminStock();
	}

}
