package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.SellerStockHelper;
import com.stockapplication.model.AdminStock;
import com.stockapplication.model.Product;
import com.stockapplication.model.Seller;
import com.stockapplication.model.SellerStock;
import com.stockapplication.repository.AdminStockRepository;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.repository.SellerRepository;
import com.stockapplication.repository.SellerStockRepository;
import com.stockapplication.request.SellerStockRequest;
import com.stockapplication.response.SellerStockResponse;
import com.stockapplication.service.AdminStockService;
import com.stockapplication.service.SellerStockService;

@Service
public class SellerStockServiceImpl implements SellerStockService {
	@Autowired
	SellerStockHelper sellerStockHelper;
	@Autowired
	SellerStockRepository sellerStockRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	SellerRepository sellerRepo;
	@Autowired
	AdminStockRepository adminStockRepo;
	@Autowired
	AdminStockService adminStockService;

	@SuppressWarnings("null")
	@Override
	public SellerStockResponse allocateStock(SellerStockRequest sellerStockRequest) throws ResourceNotFoundException {

		SellerStock sellerStock;

		Long stockquantity = 0l;

		Seller seller = sellerRepo.findById(sellerStockRequest.getSellerid())
				.orElseThrow(() -> new ResourceNotFoundException("No seller Found by this Id"));

		Product product = productRepo.findById(sellerStockRequest.getProductid())
				.orElseThrow(() -> new ResourceNotFoundException("No product Found By this Id"));

		AdminStock adminStock = adminStockService.findByProductId(sellerStockRequest.getProductid());
		if (adminStock != null) {
			if (adminStock.getStockquantity() < sellerStockRequest.getSellerstockquantity()) {
				throw new ResourceNotFoundException("No quantity remain in AdminStock!..");
			}
		} else {
			adminStock = new AdminStock();
		}

		sellerStock = sellerStockRepo.findByProductIdAndSellerId(sellerStockRequest.getProductid(),
				sellerStockRequest.getSellerid());

		if (sellerStock == null) {
			sellerStock = new SellerStock();
			sellerStock.setProduct(product);
			sellerStock.setSellerstockquantity(stockquantity);
			sellerStock.setSeller(seller);

			stockquantity = adminStock.getStockquantity() != null ? adminStock.getStockquantity() : 0l;

		} else {

			stockquantity = adminStock.getStockquantity() != null ? adminStock.getStockquantity() : 0l;

			// sellerStock.setQuantity(sellerStock.getSellerstockquantity() +
			// sellerStockRequest.getSellerstockquantity());
			sellerStock.setSellerstockquantity(
					sellerStock.getSellerstockquantity() + sellerStockRequest.getSellerstockquantity());
		}
		adminStock.setStockquantity(stockquantity - sellerStockRequest.getSellerstockquantity());
		sellerStockRepo.save(sellerStock);
		adminStockRepo.save(adminStock);
		return sellerStockHelper.sellerStockResponseFromSellerStock(sellerStock);
	}

	@Override
	public List<SellerStockResponse> getAllSellerStock() {
		List<SellerStock> list = sellerStockRepo.findAll();
		return list.stream().map(sellerStockHelper::sellerStockResponseFromSellerStock).collect(Collectors.toList());
	}

	@Override
	public SellerStock findByProductIdAndSellerId(Integer productid, Integer sellerid) {
		return sellerStockRepo.findByProductIdAndSellerId(productid, sellerid);
	}

	@Override
	public SellerStock findByProductId(Integer productid) {
		return sellerStockRepo.findByProductId(productid);
	}

}
