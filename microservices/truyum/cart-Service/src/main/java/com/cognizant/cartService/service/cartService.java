package com.cognizant.cartService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cartService.dao.CartDao;
import com.cognizant.cartService.exception.CartEmptyException;
import com.cognizant.cartService.model.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public void addCartItem(long userId, long menuItemId) {
		cartDao.addCartItem(userId,menuItemId);
	}
	
	public Cart getAllCartItems(long userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException{
		cartDao.removeCartItem(userId, menuItemId);
	}

}
