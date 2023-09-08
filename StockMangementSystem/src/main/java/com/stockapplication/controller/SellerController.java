package com.stockapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.SellerRequest;
import com.stockapplication.response.SellerResponse;
import com.stockapplication.service.impl.SellerServiceImpl;

@RestController
@RequestMapping("/api/stocknew/seller")
public class SellerController {
	@Autowired
	private SellerServiceImpl sellerServiceImpl;

	@PostMapping("/save")
	public String addSeller(@RequestBody SellerRequest sellerRequest) throws ResourceNotFoundException {
		return sellerServiceImpl.addSeller(sellerRequest);
	}

	@PostMapping("/authenticateSeller")
	public String authenticateSeller(@RequestBody SellerRequest sellerRequest) throws ResourceNotFoundException {
		return sellerServiceImpl.authenticateSeller(sellerRequest);
	}

	@GetMapping("/getAll")
	public List<SellerResponse> getAllSeller() {
		return sellerServiceImpl.getAllSeller();
	}

}
