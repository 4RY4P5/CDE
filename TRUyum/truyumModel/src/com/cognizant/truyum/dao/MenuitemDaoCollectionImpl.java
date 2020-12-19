
package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.truyum.util.DateUtil;
import com.cognizant.truyum.model.MenuItem;

public class MenuitemDaoCollectionImpl implements MenuItemdao {

	private static List<MenuItem> menuItemList = null;

	public MenuitemDaoCollectionImpl()throws ParseException,IOException,NullPointerException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", (float) 129.0, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", (float) 149.0, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", (float) 57.0, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", (float) 32.0, true,DateUtil.convertToDate("02/11/2022"), "Dessert", true));

		}
	
	}
   

	@Override
    public List<MenuItem> getMenuItemListAdmin()throws IOException{
        return menuItemList;
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId) {
        for (MenuItem itemInMenulist : menuItemList) 
        {
			if (menuItemId == itemInMenulist.getId())
				return itemInMenulist;
		}
		return null;
	}

    @Override
    public List<MenuItem> getMenuItemListCustomer()throws IOException{
        List<MenuItem> customerList = new ArrayList<>();
		for (MenuItem menuItem : menuItemList) {
			if (((menuItem.getDateOfLaunch()).equals(new Date()))
					|| (menuItem.getDateOfLaunch()).before(new Date()) && menuItem.getActive()) {
				customerList.add(menuItem);
			}
		}
		return customerList;
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) {
        for (MenuItem itemInMenulist : menuItemList) 
        {
            if (menuItem.equals(itemInMenulist)) //compare id
            {
				menuItemList.remove(itemInMenulist);
				menuItemList.add(menuItem);
				break;
			}
		}
	}    

    

    
}