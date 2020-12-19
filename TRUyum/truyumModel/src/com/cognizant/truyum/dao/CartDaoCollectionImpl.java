package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import com.cognizant.truyum.model.*;

public class CartDaoCollectionImpl implements CartDao{

    private static HashMap<Long,cart> cartmap;
    
    public CartDaoCollectionImpl()
    {
        cartmap=new HashMap<>();
    }
   
    
    @Override
    public void addCartItem(long userId, long menuItemId)throws IOException,ParseException,NullPointerException {
        MenuitemDaoCollectionImpl menuItem=new MenuitemDaoCollectionImpl();
        MenuItem item = menuItem.getMenuItem(menuItemId);
        if( cartmap.containsKey(userId) ) //add to existing cart
        {
            cart userCart = cartmap.get(userId);
            List<MenuItem> menulistnew =userCart.getMenuItemList();
            menulistnew.add(item);
            userCart.setMenuItemList(menulistnew);
        }
        else //new cart
        {
            List<MenuItem> menulistnew=new ArrayList<>();
            menulistnew.add(item);
            cart userCart = new cart(menulistnew,0.0);
            cartmap.put(userId,userCart);
        
        }


    }
    
    @Override
    public cart getAllCartItems(long userId) throws CartEmptyException,IOException{
    cart userCart=cartmap.get(userId);
    List<MenuItem> userList=userCart.getMenuItemList();
    if(userList.isEmpty())
        {
        throw new CartEmptyException();
        }
    else
        {
            double total=0;
            for(MenuItem item:userList)
            {
                total+=item.getPrice();
            }
        
            userCart.setTotal(total);
    
        }
    return userCart;
    }
	
    @Override
    public void removeCartItem(long userId, long menuItemId) throws CartEmptyException,IOException {

            cart userCart = cartmap.get(userId);
            List<MenuItem> menulistnew =userCart.getMenuItemList();
            if(menulistnew.isEmpty())
            {
                throw new CartEmptyException();
            }
            for(MenuItem item:menulistnew)
            {
                if(menuItemId==item.getId())
                {
                    menulistnew.remove(item);
                    break;
                }

            }
            userCart.setMenuItemList(menulistnew);
            cartmap.put(userId,userCart);
    }
}