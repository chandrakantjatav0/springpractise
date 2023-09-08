package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Product;
import com.stockapplication.model.Seller;
import com.stockapplication.model.SellerStock;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.repository.SellerRepository;
import com.stockapplication.repository.SellerStockRepository;
import com.stockapplication.request.SellerStockRequest;
import com.stockapplication.response.SellerStockResponse;

@Component
public class SellerStockHelper {

	@Autowired
	SellerStockRepository sellerStockRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	SellerRepository sellerRepo;

	public SellerStock sellerStockFromSellerStockRequest(SellerStockRequest sellerStockRequest)
			throws ResourceNotFoundException {
		SellerStock sellerStock = new SellerStock();

		if (sellerStockRequest.getId() == null) {
			sellerStock = this.sellerStockRepo.findById(sellerStockRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No  seller's Stock found by this id"));
		}
		// seller mapping
		Seller seller = sellerRepo.findById(sellerStockRequest.getSellerid())
				.orElseThrow(() -> new ResourceNotFoundException("No product  found by this id"));
		sellerStock.setSeller(seller);

		// product mapping
		Product product = productRepo.findById(sellerStockRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No.product found by this Id!.."));
		sellerStock.setProduct(product);

		return sellerStock;
	}

	public SellerStockResponse sellerStockResponseFromSellerStock(SellerStock sellerStock) {
		SellerStockResponse sellerStockResponse = new SellerStockResponse();
		sellerStockResponse.setId(sellerStock.getId());
		sellerStockResponse.setSellerstockquantity(sellerStock.getSellerstockquantity());

		// seller mapping
		sellerStockResponse.setSellerid(sellerStock.getSeller().getId());
		sellerStockResponse.setSellername(sellerStock.getSeller().getName());
		sellerStockResponse.setLocation(sellerStock.getSeller().getLocation());
		sellerStockResponse.setUsername(sellerStock.getSeller().getUsername());
		sellerStockResponse.setPassword(sellerStock.getSeller().getPassword());

		// product mapping
		sellerStockResponse.setProductid(sellerStock.getProduct().getId());
		sellerStockResponse.setProductname(sellerStock.getProduct().getName());
		sellerStockResponse.setDescription(sellerStock.getProduct().getDescription());
		sellerStockResponse.setSellingPrice(sellerStock.getProduct().getSellingPrice());
		sellerStockResponse.setPurchasePrice(sellerStock.getProduct().getPurchasePrice());

		return sellerStockResponse;
	}
}
