package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CartDaoCollectionImplTest  {
    
    public static void testAddCartItem()throws IOException,ParseException{
        CartDaoCollectionImpl usercartdao = new CartDaoCollectionImpl();
        usercartdao.addCartItem(1,1);
        usercartdao.addCartItem(1,2);
        usercartdao.addCartItem(1,3);
        
    }
    public static void testGetAllCartItems() throws CartEmptyException,IOException {
        CartDaoCollectionImpl usercartdao = new CartDaoCollectionImpl();
        cart usercart=usercartdao.getAllCartItems(1);
        List<MenuItem> menulist=usercart.getMenuItemList();
        for(MenuItem item: menulist)
        {
            System.out.println(item.toString());
        }
    }
    public static void testRemoveCartItem() throws CartEmptyException,IOException{

        CartDaoCollectionImpl usercart = new CartDaoCollectionImpl();
        usercart.removeCartItem(101, 2);
        
    }
    public static void main(String[] args)throws CartEmptyException,IOException,ParseException{
        testAddCartItem();
        testGetAllCartItems();
        testRemoveCartItem();
    }
}
