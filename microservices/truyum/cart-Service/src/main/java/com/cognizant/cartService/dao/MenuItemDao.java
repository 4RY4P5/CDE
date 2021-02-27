package com.cognizant.cartService.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.cartService.model.MenuItem;

@Component
public interface MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin(); 
	List<MenuItem> getMenuItemListCustomer() ;
	void modifyMenuItem(MenuItem menuItem) ;
	MenuItem getMenuItem(long menuItemId) ;

}
