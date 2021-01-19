
package com.cognizant.truyum.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService {
	@Autowired(required=true)
	@Qualifier("menuItemDaoCollectionImpl")
	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		try {
			return menuItemDao.getMenuItemListAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		try {
			return menuItemDao.getMenuItemListCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;

	}

	public void modifyMenuItem(MenuItem menuItem) {
		try {
			menuItemDao.modifyMenuItem(menuItem);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public MenuItem getMenuItem(long menuItemId) {
		try {
			return menuItemDao.getMenuItem(menuItemId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}