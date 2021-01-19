package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;

import com.cognizant.truyum.model.*;
public class CartDaoCollectionImplTest {
	public static void main(String[] args)
			throws CartEmptyException, ParseException, IOException, ClassNotFoundException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem()
			throws CartEmptyException, ParseException,IOException, ClassNotFoundException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1);
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem.toString());
		}
		
	}

	public static void testGetAllCartItems()
			throws CartEmptyException, IOException, ClassNotFoundException {
		CartDao cartDao = new CartDaoCollectionImpl();
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testRemoveCartItem() throws  IOException, ClassNotFoundException{
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 1);
		try {
			Cart cart = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem.toString());
			}
		} catch (CartEmptyException e) {
			System.out.println("Item Removed Successfully");
		}
	}

}
