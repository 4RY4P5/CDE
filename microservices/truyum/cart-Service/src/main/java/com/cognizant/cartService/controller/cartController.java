package com.cognizant.cartService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.cartService.CartServiceApplication;
import com.cognizant.cartService.exception.CartEmptyException;
import com.cognizant.cartService.model.Cart;
import com.cognizant.cartService.service.CartService;


@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService cartService;
	private static Logger log= LoggerFactory.getLogger(CartServiceApplication.class);
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable long userId,@PathVariable long menuItemId) {
		log.info("Start add to cart ");
		cartService.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/{userId}")
	public Cart getAllCartItems(@PathVariable long userId) throws CartEmptyException{
		log.info("Start get all cart item ");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable long userId, @PathVariable long menuItemId) throws CartEmptyException {
		log.info("Start remove from cart");
		cartService.removeCartItem(userId,menuItemId);
	}
	

}
