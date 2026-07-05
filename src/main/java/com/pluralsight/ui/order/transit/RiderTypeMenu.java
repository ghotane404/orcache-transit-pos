package com.pluralsight.ui.order.transit;


import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.ui.order.transit.addon.TransitPassAddOnMenu;
import com.pluralsight.util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RiderTypeMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	private final ArrayList<RiderType> riderTypes;
	private final ShoppingCart shoppingCart;
	private final TransitCardConfiguration transitCardConfiguration;


	public RiderTypeMenu(ShoppingCart shoppingCart, TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		riderTypes = new ArrayList<>();
		riderTypes.add(new RiderType("Adult", 3.00));
		riderTypes.add(new RiderType("Senior", 1.00));
		riderTypes.add(new RiderType("Youth", 2.00));
	}

	@Override
	public String showMenuName() {
		return "Select Rider Type";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("SELECT RIDER TYPE", WIDTH);

		ConsoleFormatter.divider(WIDTH);
		System.out.printf("%-2s %-8s %20s%n", "#", "RIDER TYPE", "FARE");
		ConsoleFormatter.divider(WIDTH);

		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

		for(RiderType riderType : riderTypes) {
			selectorBuilder.addSelection(
					String.format("%-20s %12s", riderType.getName(),
					String.format("$ %.2f", riderType.getPrice()))
			);
		}

		ConsoleSelector selector = selectorBuilder.build();
		int userInput = selector.showSelectionAndGetUserInput();

		if(userInput == 0) return;

		int index = userInput - 1;

		RiderType selectedRiderType = riderTypes.get(index);
		System.out.print(Ansi.color("Please enter the quantity to purchase: ", Ansi.YELLOW));

		int quantity = UserInputHelper.getIntegerInput(1, 999);

		transitCardConfiguration.setERiderType(selectedRiderType);
		transitCardConfiguration.setRiderTypeQuantity(quantity);



		Navigator.goToNextScreen(new TransitPassAddOnMenu(shoppingCart, transitCardConfiguration));

	}
}
