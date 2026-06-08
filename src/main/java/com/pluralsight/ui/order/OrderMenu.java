package com.pluralsight.ui.order;

import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.ui.order.bonusbundle.BundlePassMenuScreen;
import com.pluralsight.ui.order.checkout.CheckoutMenuScreen;
import com.pluralsight.ui.order.epurse.EPurseMenuScreen;
import com.pluralsight.ui.order.retail.RetailAccessoryMenuScreen;
import com.pluralsight.ui.order.transit.TransitCardMenu;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleSelector;

import java.util.*;

public class OrderMenu implements MenuScreen {
	private final ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private static final Scanner scanner = new Scanner(System.in);
	private static final int WIDTH = 65;
	private final ArrayList<MenuScreen> menuScreens;

	// creating a constructor that runs whenever a new OrderMenu object is created
	public OrderMenu() {
		var shoppingCart = new ShoppingCart();      // allows the ShoppingCart to be shared by all order menu screens.
		menuScreens = new ArrayList<>();      // an arrylist that will hold each of the menu option
		menuScreens.add(new TransitCardMenu(shoppingCart));    // creates a transit service menu and allows the same shopping cart to be used by other menus.
//		menuScreens.add(new BundlePassMenuScreen(shoppingCart));
//		menuScreens.add(new RetailAccessoryMenuScreen(shoppingCart));
//		menuScreens.add(new EPurseMenuScreen(shoppingCart));
//		menuScreens.add(new CheckoutMenuScreen(shoppingCart));
	}

	@Override
	public String showMenuName() {
		return "Order Menu";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("ORDER MENU", WIDTH);

		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

		for (MenuScreen menuScreen : menuScreens) {
			selectorBuilder.addSelection(menuScreen.showMenuName());
		}

		int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

		if (userInput == 0) {
			System.out.println("Returning to Home Menu.");
		}

	}

	public void displayOrderMenu() {

	}


}