package com.cognizant.truyum.dao;

import java.io.IOException;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException;

	List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException;

	void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException;

	MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException;

}