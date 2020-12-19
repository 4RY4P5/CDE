package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuitemDaoSqlImplTest {
    
    public static void testGetMenuItemListAdmin()throws IOException{
        MenuItemDaoSqlImpl menuitemdaosql=new MenuItemDaoSqlImpl();
        List<MenuItem> menulist=menuitemdaosql.getMenuItemListAdmin();
        for(MenuItem menu: menulist)
        {
            System.out.println(menu.toString());
        }
    }
    
    public static void testGetMenuItemListCustomer()throws IOException{

        MenuItemDaoSqlImpl menuitemdaosql= new MenuItemDaoSqlImpl();
        List<MenuItem> menulist=menuitemdaosql.getMenuItemListAdmin();
        for(MenuItem menu: menulist)
        {
            System.out.println(menu.toString());
        }
    }

    public static void testGetMenuItem(){
        MenuItemDaoSqlImpl menuitemdaosql= new MenuItemDaoSqlImpl();
        MenuItem item=menuitemdaosql.getMenuItem(1);
        System.out.println(item.toString());
    }

    public static void testModifyMenuItem(int j) throws ParseException,IOException{
        MenuItem modifiedItem = new MenuItem(j, "Sandwich", (float) 90.0, true, DateUtil.convertToDate("18/08/2018"),
				"Main Course",true);
		MenuItemDaoSqlImpl menuitemdaosql = new MenuItemDaoSqlImpl();
		menuitemdaosql.modifyMenuItem(modifiedItem);
        System.out.println("Menu Item Modified");
     
    }

   public static void main(String[] args) throws ParseException,IOException {
       testGetMenuItemListAdmin();
       testGetMenuItemListCustomer();
       testModifyMenuItem(1);
       testGetMenuItem();
   }
    
}
