package com.cognizant.truyum.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {
	private static MenuItemService menuItemService;

	@BeforeClass
	public static void initializeService() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
		context.scan("com.cognizant.truyum");
		//context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
	}

	@Test
	public void testGetMenuItemListAdminSize() {
		assertEquals( 5, menuItemService.getMenuItemListAdmin().size());
	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 1, "Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		for (MenuItem listItem : menuItemService.getMenuItemListAdmin()) {
			if (listItem.equals(menuItem)) {
				assertEquals("testMenuItemName", menuItem.getName(), listItem.getName());
				assertEquals("testMenuItemPrice", menuItem.getPrice(), listItem.getPrice(),0.00);
				assertEquals("testMenuItemActive", menuItem.isActive(),	listItem.isActive());
				assertEquals("testMenuItemDateOfLaunch", menuItem.getDateOfLaunch(), listItem.getDateOfLaunch());
				assertEquals("testMenuItemCategory", menuItem.getCategory(), listItem.getCategory());
				assertEquals("testMenuItemFreeDelivery", menuItem.isFreeDelivery(), listItem.isFreeDelivery());

			}
		}
	}

	@Test
	public void testGetMenuItemListCustomerSize() {
		assertEquals( 3, menuItemService.getMenuItemListCustomer().size());

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 4, "French Fries", (float) 57.0, false,
				DateUtil.convertToDate("02/07/2017"), "Starters", true);
		for (MenuItem menuItemInList : menuItemService.getMenuItemListCustomer()) {
			assertFalse("testGetMenuItemListCustomerNotContainsFrenchFries", menuItemInList.equals(menuItem));
		}
	}

	@Test
	public void testGetMenuItem() {
		assertEquals("testGetMenuItem", (long) 1, menuItemService.getMenuItem(1).getId());
	}

	@Test
	public void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 1, "Big Sandwich", (float) 199.0, true,
				DateUtil.convertToDate("15/03/2019"), "Main Course", true);
		menuItemService.modifyMenuItem(menuItem);
		assertEquals("testModifyMenuItemName", menuItem.getName(), menuItemService.getMenuItem(1).getName());
		assertEquals("testModifyMenuItemPrice", menuItem.getPrice(), menuItemService.getMenuItem(1).getPrice(),0.00);
		assertEquals("testModifyMenuItemDateOfLaunch", menuItem.getDateOfLaunch(),
				menuItemService.getMenuItem(1).getDateOfLaunch());
		//undo the modification
		MenuItem menuItem1 = new MenuItem((long) 1, "Sandwich", (float) 99.0, true,
				DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		menuItemService.modifyMenuItem(menuItem1);

	}

	//@AfterClass
	//public static void deIntializeService() {
	//	context.close();
	//}

}
