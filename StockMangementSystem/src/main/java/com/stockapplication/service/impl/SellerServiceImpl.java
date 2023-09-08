package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.SellerHelper;
import com.stockapplication.model.Seller;
import com.stockapplication.repository.SellerRepository;
import com.stockapplication.request.SellerRequest;
import com.stockapplication.response.SellerResponse;
import com.stockapplication.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerHelper sellerHelper;
	@Autowired
	private SellerRepository sellerRepo;

	@Override
	public String addSeller(SellerRequest sellerRequest) throws ResourceNotFoundException {
		BCryptPasswordEncoder bycrpt = new BCryptPasswordEncoder();
		String encryptPwd = bycrpt.encode(sellerRequest.getPassword());
		sellerRequest.setPassword(encryptPwd);

		Seller seller = sellerHelper.sellerFromSellerRequest(sellerRequest);
		sellerRepo.save(seller);
		return "Seller saved in Database Succcesfully ";
	} 

	@Override
	public String authenticateSeller(SellerRequest sellerRequest) throws ResourceNotFoundException {
		BCryptPasswordEncoder bycrpt = new BCryptPasswordEncoder();
		Seller seller = sellerRepo.findByUsername(sellerRequest.getUsername());
		if (bycrpt.matches(sellerRequest.getPassword(), seller.getPassword())) {
			return "Authenticated Seller..";
		} else {
			return "Incorrect Password";
		}
	}

	@Override
	public List<SellerResponse> getAllSeller() {
		List<Seller> sellerList = sellerRepo.findAll();
		return sellerList.stream().map(sellerHelper::sellerResponseFromSeller).collect(Collectors.toList());
	}

	@Override
	public Seller findById(Integer sellerid) throws ResourceNotFoundException {
		 return sellerRepo.findById(sellerid).orElseThrow(() -> new ResourceNotFoundException("No seller was Found by this Id!.."));
	}

}
