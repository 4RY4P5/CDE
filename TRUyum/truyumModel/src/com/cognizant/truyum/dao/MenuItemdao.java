package com.cognizant.truyum.dao;

import java.io.IOException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemdao {
	List<MenuItem> getMenuItemListAdmin() throws IOException, ClassNotFoundException;

	List<MenuItem> getMenuItemListCustomer() throws IOException;

	void modifyMenuItem(MenuItem menuItem) throws IOException;

	MenuItem getMenuItem(long menuItemId);

}
