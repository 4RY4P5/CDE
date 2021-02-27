package com.cognizant.cartService.dao;

import org.springframework.stereotype.Component;

import com.cognizant.cartService.exception.CartEmptyException;
import com.cognizant.cartService.model.Cart;

@Component
public interface CartDao {

	void addCartItem(long userId, long menuItemId);
	Cart getAllCartItems(long userId) throws CartEmptyException;	
	void removeCartItem(long userId, long menuItemId) throws CartEmptyException;

}
