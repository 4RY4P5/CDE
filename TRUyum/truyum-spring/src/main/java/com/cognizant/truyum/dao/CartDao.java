package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;

import com.cognizant.truyum.model.Cart;

public interface CartDao {

	void addCartItem(long userId, long menuItemId)
			throws ParseException, ClassNotFoundException, IOException;

	Cart getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException;

	void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException;

}