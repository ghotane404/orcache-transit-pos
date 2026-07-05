package com.pluralsight.ui.order.transit.addon;


import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.item.FerryPassCartItem;
import com.pluralsight.model.option.AccountBenefit;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.ui.order.transit.addon.feature.AccountFeatureMenu;
import com.pluralsight.util.*;

import java.awt.*;
import java.util.*;

public class FerryPassAddOnMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	private final ArrayList<FerryPassCartItem> ferryAddOnOptions;

	int WIDTH = 60;

	private final ShoppingCart shoppingCart;
	private final TransitCardConfiguration transitCardConfiguration;

	public FerryPassAddOnMenu(ShoppingCart shoppingCart, TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		ferryAddOnOptions = new ArrayList<>();
		ferryAddOnOptions.add(new FerryPassCartItem("WSF Mukilteo-Clinton", 6.00, 3.00, 4.00));
		ferryAddOnOptions.add(new FerryPassCartItem("WSF Vashon Island", 6.50, 3.25, 4.50));
		ferryAddOnOptions.add(new FerryPassCartItem("WSF Fauntleroy-Southworth", 7.50, 3.25, 5.00));
		ferryAddOnOptions.add(new FerryPassCartItem("WSF Port Townsend-Coupeville", 8.50, 4.25, 6.00));
		ferryAddOnOptions.add(new FerryPassCartItem("WSF Central Sound", 12.00, 6.00, 8.50));
	}

	@Override
	public String showMenuName() {
		return "Select Ferry Pass Add-On";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("SELECT FERRY ROUTE PASS" , WIDTH);
		ConsoleFormatter.displayRiderTypeHeader("Pricing for Rider Type: " + transitCardConfiguration.getERiderType().getName(), WIDTH);

		ConsoleFormatter.divider(WIDTH);
		System.out.printf("%-4s %-30s %9s %11s%n", "#", "ROUTE", "FARE", "ADD-ON");
		ConsoleFormatter.divider(WIDTH);

		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

		for(FerryPassCartItem ferryPass : ferryAddOnOptions) {
			double basePrice = ferryPass.getPriceFor(transitCardConfiguration.getERiderType());
			double additionalPrice = basePrice * 0.85;

			selectorBuilder.addSelection(
					String.format("%-32s %10s %10s", ferryPass.getFerryPassCartItemName(),
					String.format("$ %.2f", basePrice),
					String.format("$ %.2f", additionalPrice))
			);
		}

		ConsoleSelector selector = selectorBuilder.build();
		int userInput = selector.showSelectionAndGetUserInput();

		if(userInput == 0) return;

		int index = userInput - 1;

		FerryPassCartItem selectedFerryAddOn = ferryAddOnOptions.get(index);
		System.out.print(Ansi.color("Please enter the quantity to purchase: ", Ansi.YELLOW));

		int quantity = UserInputHelper.getIntegerInput(1, 999);

		transitCardConfiguration.setEFerryPass(selectedFerryAddOn);
		transitCardConfiguration.setTransitAddOnQuantity(quantity);

		ConsoleFormatter.spaceBetweenPrints(Ansi.color("Added to Cart: \n"
						+ selectedFerryAddOn.getFerryPassCartItemName() + " "
						+ transitCardConfiguration.getEFerryPass().getName() + " for "
						+ transitCardConfiguration.getERiderType().getName() + " \n"
						+ "Qty: " + quantity,
				Ansi.BRIGHT_GREEN), WIDTH);

		Navigator.goToNextScreen(new AccountFeatureMenu(shoppingCart, transitCardConfiguration));

	}
}
