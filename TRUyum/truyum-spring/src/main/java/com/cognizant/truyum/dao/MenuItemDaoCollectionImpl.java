
package com.cognizant.truyum.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("MenuItemDaoCollectionImpl")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private List<MenuItem> menuItemList;
	
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Autowired
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;

	}



    public List<MenuItem> getMenuItemListAdmin()throws IOException{
        return menuItemList;
	}
	
	
	public MenuItem getMenuItem(long menuItemId) {
        for (MenuItem itemInMenulist : menuItemList) 
        {
			if (menuItemId == itemInMenulist.getId())
				return itemInMenulist;
		}
		return null;
	}

    
    public List<MenuItem> getMenuItemListCustomer()throws IOException{
        List<MenuItem> customerList = new ArrayList<>();
		for (MenuItem menuItem : menuItemList) {
			if (((menuItem.getDateOfLaunch()).equals(new Date()))
					|| (menuItem.getDateOfLaunch()).before(new Date()) && menuItem.isActive()) {
				customerList.add(menuItem);
			}
		}
		return customerList;
    }

   
    public void modifyMenuItem(MenuItem menuItem)throws IOException {
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

    public MenuItemDaoCollectionImpl() {

	}

    
}
