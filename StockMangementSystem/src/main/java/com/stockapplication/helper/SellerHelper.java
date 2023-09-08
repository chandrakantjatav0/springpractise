package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Seller;
import com.stockapplication.repository.SellerRepository;
import com.stockapplication.request.SellerRequest;
import com.stockapplication.response.SellerResponse;

@Component
public class SellerHelper {
	@Autowired
	SellerRepository sellerRepo;

	public Seller sellerFromSellerRequest(SellerRequest sellerRequest) throws ResourceNotFoundException {
		Seller seller = new Seller();
		if (sellerRequest.getId() != null) {
			seller = this.sellerRepo.findById(sellerRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Seller found by this Id!.."));
		}
		seller.setName(sellerRequest.getName());
		seller.setLocation(sellerRequest.getLocation());
		seller.setUsername(sellerRequest.getUsername());
		seller.setPassword(sellerRequest.getPassword());
		return seller;
	}

	public SellerResponse sellerResponseFromSeller(Seller seller) {
		SellerResponse sellerResponse = new SellerResponse();
		sellerResponse.setId(seller.getId());
		sellerResponse.setName(seller.getName());
		sellerResponse.setLocation(seller.getLocation());
		sellerResponse.setUsername(seller.getUsername());
		sellerResponse.setPassword(seller.getPassword());
		return sellerResponse;

	}
}
