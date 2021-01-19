package com.cognizant.truyum.service;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {
	private static CartService cartService;
	

	@BeforeClass
	public static void initializeService() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
		context.scan("com.cognizant.truyum");
		//context.refresh();
		cartService = (CartService) context.getBean("cartService");

	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItemsExceptionIfEmpty() throws CartEmptyException {
		cartService.addCartItem(10, 1);
		cartService.removeCartItem(10, 1);
		cartService.getAllCartItems(10);
	}

	@Test
	public void testAddCartItem() throws CartEmptyException {

		cartService.addCartItem(1, 1);
		List<MenuItem> menuItemList = cartService.getAllCartItems(1).getMenuItemList();
		assertEquals("testAddCartItem", (long) 1, menuItemList.get(menuItemList.size()- 1).getId());
	}

	@Test
	public void testRemoveCartItem() throws CartEmptyException {

		cartService.addCartItem(1, 2);
		cartService.removeCartItem(1, 1);
		List<MenuItem> menuItemList = cartService.getAllCartItems(1).getMenuItemList();
		assertTrue("testRemoveCartItem",
				(menuItemList.size() == 0) || (((menuItemList.get(menuItemList.size() - 1)).getId()) != 1));
	}

}