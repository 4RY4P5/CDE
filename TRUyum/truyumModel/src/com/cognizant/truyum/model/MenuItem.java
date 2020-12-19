
package com.cognizant.truyum.model;

import java.util.Date;


public class MenuItem {
	private long id;
	private String name; 
	private String category;
	private float price;
	private boolean active;
	private boolean freeDelivery;
	private Date dateOfLaunch;
	
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getDateOfLaunch() {
		return this.dateOfLaunch;
	}
	
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	
	public boolean getFreeDelivery() {
		return this.freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	
public MenuItem(long id, String name, float price, boolean active,Date dateOfLaunch,String category, boolean freeDelivery) {
	this.id = id;
	this.name = name;
	this.category = category;
	this.price = price;
	this.active = active;
	this.freeDelivery = freeDelivery;
	this.dateOfLaunch = dateOfLaunch;
}

public boolean equals (MenuItem obj)
{
	return id == obj.id;
}

public String toString() {
	return "Id=" + id + ", Name=" + name + ", Price=" + price + ", Active=" + active + ", Date Of Launch="
			+ dateOfLaunch + ", Category=" + category + ", FreeDelivery=" + freeDelivery ;
}
}