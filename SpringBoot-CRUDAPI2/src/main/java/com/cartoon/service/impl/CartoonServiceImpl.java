
package com.cartoon.service.impl;

import org.springframework.stereotype.Service;

import com.cartoon.model.Cartoon;
import com.cartoon.repository.CartoonRepository;
import com.cartoon.service.CartoonService;

@Service
public class CartoonServiceImpl implements CartoonService {

	private CartoonRepository cartoonrepository;

	public CartoonServiceImpl(CartoonRepository cartoonrepository) {
		super();
		this.cartoonrepository = cartoonrepository;
	}

	@Override
	public Cartoon saveCartoon(Cartoon cartoon) {
		return cartoonrepository.save(cartoon);
	}
}