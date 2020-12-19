package com.cognizant.truyum.dao;


public class CartEmptyException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CartEmptyException()
    {
        System.out.println("Cart is Empty");
    }
}
