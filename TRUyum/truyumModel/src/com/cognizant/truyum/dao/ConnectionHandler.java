package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	
	private static Connection con=null;
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    try{
			Properties props=new Properties();
			FileInputStream fis = new FileInputStream("\\truyumModel\\src\\connection.properties");
			props.load(fis);
			
			Class.forName(props.getProperty("driver"));

			// create the connection now
          con = DriverManager.getConnection(props.getProperty("connection-url"),props.getProperty("user"),props.getProperty("password"));
			fis.close();
		}
	    catch(IOException e){
	        e.printStackTrace();
	    }
        
        return con;
       
       
	}
}
