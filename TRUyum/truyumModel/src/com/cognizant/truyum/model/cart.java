package com.cognizant.truyum.model;
import java.util.List;


public class cart {
    private List<MenuItem> menuItemlist;
    private double total;

    public List<MenuItem> getMenuItemList()
    {
		return this.menuItemlist;
    }

    public void setMenuItemList(List<MenuItem> menu) {
        this.menuItemlist = menu;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public cart(List<MenuItem> menu, double total) {
        this.total = total;
        menuItemlist = menu;
    }
}
