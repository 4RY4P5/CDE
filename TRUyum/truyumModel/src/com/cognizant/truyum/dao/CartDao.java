package com.cognizant.truyum.dao;


import java.io.IOException;
import java.text.ParseException;

import com.cognizant.truyum.model.cart;
//import com.cognizant.truyum.model.MenuItem
public interface CartDao {

	void addCartItem(long userId, long menuItemId)throws IOException,ParseException ;
	cart getAllCartItems(long userId) throws CartEmptyException,IOException;
	void removeCartItem(long userId, long menuItemId) throws CartEmptyException,IOException;

}