package com.pluralsight.ui.order;

import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.ui.order.transit.TransitCardMenu;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.*;

public class OrderMenu implements MenuScreen {

	private static final Scanner scanner = new Scanner(System.in);
	private static final int WIDTH = 50;
	private final ArrayList<MenuScreen> menuScreenNames;

	// creating a constructor that runs whenever a new OrderMenu object is created
	public OrderMenu() {
		var shoppingCart = new ShoppingCart();      // allows the ShoppingCart to be shared by all order menu screens.
		menuScreenNames = new ArrayList<>();      // an arraylist that will hold each of the menu option

		menuScreenNames.add(new TransitCardMenu(shoppingCart));    // creates a transit service menu and allows the same shopping cart to be used by other menus.
//		menuScreenNames.add(new BundlePassMenuScreen(shoppingCart));
//		menuScreenNames.add(new RetailAccessoryMenuScreen(shoppingCart));
//		menuScreenNames.add(new EPurseMenuScreen(shoppingCart));
//		menuScreenNames.add(new CheckoutMenuScreen(shoppingCart));
	}

	@Override
	public String showMenuName() {
		return "Order Menu";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("ORDER MENU", WIDTH);
		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

		for (MenuScreen menuScreen : menuScreenNames) {
			selectorBuilder.addSelection(menuScreen.showMenuName());
		}

		int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

		if (userInput == 0) {
			System.out.println("Returning to Home Menu.");
		}

		int index = userInput - 1;
		Navigator.goToNextScreen(menuScreenNames.get(index));

	}
}