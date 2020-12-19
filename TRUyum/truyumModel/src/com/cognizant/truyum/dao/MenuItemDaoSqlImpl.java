package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemdao {


	@Override
    public List<MenuItem> getMenuItemListAdmin()throws IOException {
        List<MenuItem> menulist=new ArrayList<>();
        try {
            Connection con = ConnectionHandler.getConnection();
			PreparedStatement query = con.prepareStatement("SELECT * FROM MENU_ITEM");
			ResultSet result = query.executeQuery();
			while (result.next()) {
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
                     menulist.add(item);
            }
            con.close();
           
           
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return menulist;
    }

    @Override
    public List<MenuItem> getMenuItemListCustomer()throws IOException{
        
        List<MenuItem> menulist=new ArrayList<>();
        try {
            Connection con = ConnectionHandler.getConnection();
			PreparedStatement query = con.prepareStatement("SELECT * FROM MENU_ITEM WHERE ACTIVE = 'Yes' AND DATE_OF_LAUNCH <= DATE(NOW())");
			ResultSet result = query.executeQuery();
			while (result.next()) {
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
                 menulist.add(item);
            }
            con.close();
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return menulist;
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem)throws IOException{
    try {
        Connection con = ConnectionHandler.getConnection();
            PreparedStatement query = con.prepareStatement("UPDATE MEN_ITEM SET  NAME=?, PRICE=?, ACTIVE=?, DATE_OF_LAUNCH=?, CATEGORY=?, FREE_DELIVERY=? WHERE ITEM_ID=?");

            boolean active;
            boolean freeDelivery;
            if( menuItem.getActive())
                    { active=true;}
            else
                   { active=false;}
            if(menuItem.getFreeDelivery() )
                   freeDelivery= true;
                  else
                   freeDelivery= false;
            
            query.setString(1, menuItem.getName());
			query.setFloat(2, menuItem.getPrice());
			query.setBoolean(3, active);
			query.setDate(4, (java.sql.Date) menuItem.getDateOfLaunch());
			query.setString(5, menuItem.getCategory());
			query.setBoolean(6, freeDelivery);
            query.setLong(7, menuItem.getId());
            query.executeUpdate();
            con.close();
        
    } catch (Exception e) {
        e.printStackTrace();
     }
    

    }

    @Override
    public MenuItem getMenuItem(long menuItemId){
        MenuItem item= null;
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM MENU_ITEM WHERE ITEM_ID=?");
            query.setLong(1,menuItemId);
			ResultSet result = query.executeQuery();
			while (result.next()) {
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

              item= new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
    }
    con.close();
    
}
catch(Exception e)
{
    e.printStackTrace();
}
return item;
}
}