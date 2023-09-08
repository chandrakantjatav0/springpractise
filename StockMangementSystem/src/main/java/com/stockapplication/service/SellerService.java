package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Seller;
import com.stockapplication.request.SellerRequest;
import com.stockapplication.response.SellerResponse;

public interface SellerService {

	String addSeller(SellerRequest sellerRequest) throws ResourceNotFoundException;

	String authenticateSeller(SellerRequest sellerRequest) throws ResourceNotFoundException;

	List<SellerResponse> getAllSeller();

	Seller findById(Integer sellerid) throws ResourceNotFoundException;

	//SellerResponse getById(long id);

	//Seller findByUsername(String username);

}
