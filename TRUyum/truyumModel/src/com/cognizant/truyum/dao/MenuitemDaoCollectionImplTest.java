package com.cognizant.truyum.dao;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuitemDaoCollectionImplTest {

    public static void testGetMenuItemListAdmin()throws IOException,ClassNotFoundException,ParseException
    {
       MenuItemdao menuItemDao = new MenuitemDaoCollectionImpl();
       List<MenuItem>menuitemList = menuItemDao.getMenuItemListAdmin();
       for (MenuItem menuItem :menuitemList) {
           System.out.println(menuItem.toString());

       }
   }

   public static void testGetMenuItemListCustomer()throws IOException,ParseException{
       MenuItemdao menuitemDao = new MenuitemDaoCollectionImpl();
       List<MenuItem>menuitemList = menuitemDao.getMenuItemListCustomer();
       for (MenuItem menuItem :menuitemList) {
           System.out.println(menuItem.toString());

       }
   }

   public static void testModifyMenuItem() throws ParseException,IOException{
       MenuItem menuItem = new MenuItem((long) 1, "Sandwich", (float) 90.0, true, DateUtil.convertToDate("18/08/2018"),
               "Main Course", true);
       MenuItemdao menuitemDao = new MenuitemDaoCollectionImpl();
       menuitemDao.modifyMenuItem(menuItem);
       System.out.println(menuitemDao.getMenuItem(menuItem.getId()).toString());
   }

	public static void main(String[] args)throws ParseException,IOException,ClassNotFoundException{
	    testGetMenuItemListAdmin();//method calling
        testGetMenuItemListCustomer();
        testModifyMenuItem();

	}

}