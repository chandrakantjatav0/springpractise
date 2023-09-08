package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Product;
import com.stockapplication.repository.ProductRepository;
import com.stockapplication.request.ProductRequest;
import com.stockapplication.response.ProductResponse;

@Component
public class ProductHelper {
	@Autowired
	private ProductRepository productRepo;

	public Product productFromProductRequest(ProductRequest productRequest) throws ResourceNotFoundException {
		Product product = new Product();
		if (productRequest.getId() != null) {
			product = this.productRepo.findById(productRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No. product available from this Id."));
		}
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPurchasePrice(productRequest.getPurchasePrice());
		product.setSellingPrice(productRequest.getSellingPrice());
		return product;
	}

	public ProductResponse productResponseFromProduct(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setDescription(product.getDescription());
		productResponse.setPurchasePrice(product.getPurchasePrice());
		productResponse.setSellingPrice(product.getPurchasePrice());
		return productResponse;

	}
}
