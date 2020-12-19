package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;

import com.cognizant.truyum.model.*;


public class CartDaoSqlImplTest {

public static void testAddCartItem()throws IOException,CartEmptyException,ParseException {
CartDao cartDao = new CartDaoSqlImpl();
cartDao.addCartItem(1, 1);
cart usercart = cartDao.getAllCartItems(1);
for (MenuItem menuItem : usercart.getMenuItemList())
    System.out.println(menuItem.toString());
}

public static void testGetAllCartItems()
    throws  CartEmptyException, IOException {
CartDao cartDao = new CartDaoSqlImpl();
 cart usercart = cartDao.getAllCartItems(1);
 
for (MenuItem menuItem : usercart.getMenuItemList())
    System.out.println(menuItem.toString());
}

public static void testRemoveCartItem()
    throws  IOException, CartEmptyException {
CartDao cartDao = new CartDaoSqlImpl();
cartDao.removeCartItem(1, 1);
cart usercart = cartDao.getAllCartItems(1);
for (MenuItem menuItem : usercart.getMenuItemList())
    System.out.println(menuItem.toString());
}

    public static void main(String[] args)
			throws   IOException,CartEmptyException,ParseException {

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	

}