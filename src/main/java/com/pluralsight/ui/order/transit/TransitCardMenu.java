package com.pluralsight.ui.order.transit;


import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.TransitCard;
import com.pluralsight.util.Ansi;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.*;

public class TransitCardMenu implements MenuScreen {
	ArrayList<TransitCard> transitCards;
	private final ShoppingCart shoppingCart;
	int WIDTH = 50;

	public TransitCardMenu(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;

		transitCards = new ArrayList<>();
		transitCards.add(new TransitCard("Metro Bus"));
		transitCards.add(new TransitCard("Link Light Rail"));
		transitCards.add(new TransitCard("Rapid Ride"));
		transitCards.add(new TransitCard("Sound Transit Express Bus"));
	}

	@Override
	public String showMenuName() {
		return "Add Transit Pass";
	}

	@Override
	public void displayMenu() {
		ConsoleFormatter.displayHeader("Add Transit Pass", WIDTH);
		ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

			for (TransitCard transitCard : transitCards){     // loops through every menu option in the menus array.
				selectorBuilder.addSelection(transitCard.getTransitCardName());
			}

			int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

			if (userInput == 0) return;

			int index = userInput - 1;
			TransitCard selectedTransitCard = transitCards.get(index);
			TransitCardConfiguration transitCardConfiguration = new TransitCardConfiguration();
			transitCardConfiguration.setETransitService(selectedTransitCard);

//		Navigator.goToNextScreen(new RiderTypeMenu(shoppingCart, transitCardConfiguration));

	}
}
