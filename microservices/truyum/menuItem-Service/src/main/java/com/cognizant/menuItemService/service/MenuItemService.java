package com.cognizant.menuItemService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuItemService.dao.MenuItemDao;
import com.cognizant.menuItemService.model.MenuItem;



@Service
public class MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;

	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemDao.getMenuItemListAdmin();
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemDao.getMenuItemListCustomer();
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
	
}
