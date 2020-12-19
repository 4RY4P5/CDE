package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.cognizant.truyum.model.*;
public class CartDaoSqlImpl implements CartDao{

	@Override
	public void addCartItem(long userId, long menuItemId)throws IOException{
		try {
            Connection con= ConnectionHandler.getConnection();
            PreparedStatement query=con.prepareStatement("SELECT * FROM USER WHERE USER_ID=?");
            query.setLong(1, userId);
            ResultSet result= query.executeQuery();
            if(!result.next())//no user in user table add new user
            {
                query=con.prepareStatement("INSERT INTO USER VALUES(?,?)");
                query.setLong(1, userId);
                query.setString(2, "Sam");
                query.executeUpdate();
            }
            query=con.prepareStatement("INSERT INTO CART VALUES(?,?)");
            query.setLong(1,userId);
            query.setLong(2, menuItemId);
            query.executeUpdate();
            con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
       
	}

	@Override
	public cart getAllCartItems(long userId) throws CartEmptyException,IOException {
        cart usercart=new cart(null, 0);
        try{
        Connection con=ConnectionHandler.getConnection();
        PreparedStatement query=con.prepareStatement("SELECT * FROM MENU_ITEM JOIN CART ON CART.ITEM_ID=MENU_ITEM.ITEM_ID AND USER_ID=?");
        query.setLong(1, userId);
        ResultSet result=query.executeQuery();
        while(result.next())
        {
            long id= result.getLong("ITEM_ID");
                String name= result.getString("NAME");
                float price= result.getFloat("PRICE");
                boolean active;
                boolean freeDelivery;
                if( result.getString("ACTIVE").equals("YES"))
                        { active=true;}
                else
                       { active=false;}
                
                Date dateOfLaunch=result.getDate("DATE_OF_LAUNCH");
                String category=result.getString("CATEGORY");
                
                if(result.getString("FREE_DELIVERY").equals("YES") )
                 freeDelivery= true;
                else
                 freeDelivery= false;

             MenuItem item= new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
            usercart.getMenuItemList().add(item);
        }
        query=con.prepareStatement("SELECT SUM(PRICE) AS TOTPRICE FROM MENU_ITEM JOIN CART ON CART.ITEM_ID=MENU_ITEM.ITEM_ID AND USER_ID=?");
        query.setLong(1, userId);
        result=query.executeQuery();
        while(result.next())
        {
            usercart.setTotal(result.getLong("TOTPRICE"));
        }
        con.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    return usercart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException,IOException {
	
		
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement query = con
					.prepareStatement("DELETE FROM CART WHERE USER_ID = ? AND ITEM_ID= ? ");
			query.setLong(1, userId);
			query.setLong(2, menuItemId);
            query.executeUpdate();
            con.close();
            
		} catch (Exception e) {
			e.printStackTrace();
		} 
		}

	

	}

    

