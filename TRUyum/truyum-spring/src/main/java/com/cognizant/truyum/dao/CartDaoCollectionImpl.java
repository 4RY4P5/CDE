package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import java.io.IOException;
import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.*;

@Component("cartDaoCollectionImpl")
public class CartDaoCollectionImpl implements CartDao {
	private LinkedHashMap<Long, Cart> userCarts;
	@Autowired
	@Qualifier("menuItems")
	private MenuItemDao menuItemDao;
	
	
	public CartDaoCollectionImpl() {

	}
	@Autowired
	public CartDaoCollectionImpl(LinkedHashMap<Long, Cart> userCarts) {
		super();
		this.userCarts = userCarts;
	}

	
	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public LinkedHashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(LinkedHashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	public void addCartItem(long userId, long menuItemId)
			throws ParseException, ClassNotFoundException, IOException {
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> newList = cart.getMenuItemList();
			newList.add(menuItem);
			cart.setMenuItemList(newList);
			userCarts.put(userId, cart);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
			List<MenuItem> newList = cart.getMenuItemList();
			newList.add(menuItem);
			cart.setMenuItemList(newList);
			userCarts.put(userId, cart);
		}

	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);
		List<MenuItem> itemList = cart.getMenuItemList();
		if (itemList == null || itemList.size() < 1)
			throw new CartEmptyException();
		else {
			double total = 0;
			for (MenuItem menuItem : itemList) {
				total += menuItem.getPrice();
			}
			cart.setTotal(total);
		}
		return cart;
	}

	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		List<MenuItem> itemList = cart.getMenuItemList();
		for (MenuItem menuItem : itemList) {
			if (menuItem.getId() == menuItemId) {
				itemList.remove(menuItem);
				break;
			}
			cart.setMenuItemList(itemList);
			userCarts.put(userId, cart);
		}
	}

}

