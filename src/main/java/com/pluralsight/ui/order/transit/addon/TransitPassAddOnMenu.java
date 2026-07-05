package com.pluralsight.ui.order.transit.addon;

import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.AddOn;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.ui.order.transit.TransitCardMenu;
import com.pluralsight.util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransitPassAddOnMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	private final ArrayList<AddOn> transitAddOnOptions;

	private final ShoppingCart shoppingCart;
	private final TransitCardConfiguration transitCardConfiguration;

	public TransitPassAddOnMenu(ShoppingCart shoppingCart, TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		transitAddOnOptions = new ArrayList<>();
		transitAddOnOptions.add(new AddOn("All Day Pass",6.00, 2.00, 3.75, transitCardConfiguration.getERiderType()));
		transitAddOnOptions.add(new AddOn("Monthly Pass", 108.00, 36.00, 50.00, transitCardConfiguration.getERiderType()));
		transitAddOnOptions.add(new AddOn("7-Day Pass", 90.00, 70.00, 80.00, transitCardConfiguration.getERiderType()));
	}

	@Override
	public String showMenuName() {
		return "Select Transit Add On";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("SELECT TRANSIT PASS ADD-ON", WIDTH);
		ConsoleFormatter.displayRiderTypeHeader("Pricing for Rider Type: " + transitCardConfiguration.getERiderType().getName(), WIDTH);

		ConsoleFormatter.divider(WIDTH);
		System.out.printf("%-4s %-20s %8s %14s%n", "#", "ADD-ON", "FARE", "ADDITIONAL");
		ConsoleFormatter.divider(WIDTH);

		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

		for (AddOn addOn : transitAddOnOptions) {
			double basePrice = addOn.getPriceFor(transitCardConfiguration.getERiderType());
			double additionalPrice = basePrice * 0.85;

			selectorBuilder.addSelection(String.format("%-20s %10s %13s",
					addOn.getName(),
					String.format("$ %.2f", basePrice),
					String.format("$ %.2f", additionalPrice)
					)
			);
		}

		int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

		if (userInput == 0) return;

		int index = userInput - 1;

		AddOn selectedAddOn = transitAddOnOptions.get(index);
		System.out.print(Ansi.color("Please enter the quantity to purchase: ", Ansi.YELLOW));

		int quantity = UserInputHelper.getIntegerInput(1, 999);

		transitCardConfiguration.setEAddOn(selectedAddOn);
		transitCardConfiguration.setTransitAddOnQuantity(quantity);

		ConsoleFormatter.spaceBetweenPrints(Ansi.color("Added to Cart: \n"
						+ transitCardConfiguration.getEAddOn().getName()
						+ " for "
						+ transitCardConfiguration.getERiderType().getName() + " \n"
						+ "Qty: " + quantity,
				Ansi.BRIGHT_GREEN), WIDTH);

		Navigator.goToNextScreen(new FerryPassAddOnMenu(shoppingCart, transitCardConfiguration));

	}
}
