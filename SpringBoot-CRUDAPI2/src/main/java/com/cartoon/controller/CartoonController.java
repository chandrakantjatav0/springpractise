package com.cartoon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartoon.model.Cartoon;
import com.cartoon.service.impl.CartoonServiceImpl;

@RestController
@RequestMapping("/api/cartoonn")
public class CartoonController {
	private CartoonServiceImpl cartoonService;

	public CartoonController(CartoonServiceImpl cartoonService) {
		super();
		this.cartoonService = cartoonService;
	}

	// Build Create a REST API
	//http:localhost:9090/api/cartoonn/save
	@PostMapping("/save")
	public ResponseEntity<Cartoon> saveCartoon(@RequestBody Cartoon cartoon) {
		return new ResponseEntity<Cartoon>(cartoonService.saveCartoon(cartoon), HttpStatus.CREATED);
	}
}