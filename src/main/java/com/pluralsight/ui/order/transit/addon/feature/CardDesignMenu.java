package com.pluralsight.ui.order.transit.addon.feature;

import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.AccountBenefit;
import com.pluralsight.model.option.CardDesign;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.ArrayList;
import java.util.Scanner;

public class CardDesignMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	private ArrayList<CardDesign> cardDesigns;
	private ShoppingCart shoppingCart;
	private TransitCardConfiguration transitCardConfiguration;

	public CardDesignMenu(ShoppingCart shoppingCart, TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		cardDesigns = new ArrayList<>();
		cardDesigns.add(new CardDesign("Orca Wave", 0));
		cardDesigns.add(new CardDesign("Seattle Skyline", 0));
		cardDesigns.add(new CardDesign("Ferry Crossing", 0));
		cardDesigns.add(new CardDesign("Coffee Line", 0));
	}


	@Override
	public String showMenuName() {
		return "Add Card Design";
	}

	@Override
	public void displayMenu() {
		while (true) {
			ConsoleFormatter.displayHeader("SELECT CARD DESIGN", WIDTH);

			System.out.println("Choose free card design for this card.");
			System.out.println("You can choose up to 3 designs.");
			System.out.println();

			int selectedCount = transitCardConfiguration.getECardDesigns().size();

			ConsoleFormatter.displayRiderTypeHeader("Card Design Selected: " + selectedCount + " of 3", WIDTH);
			System.out.println();

			ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

			for (CardDesign cardDesign : cardDesigns) {
				selectorBuilder.addSelection(String.format("%-36s %s",
						cardDesign.getName(),
						"Included")
				);
			}

			selectorBuilder.addSelection("→ Continue to Lime Voucher");

			int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

			if (userInput == 0) return;

			int index = userInput - 1;

			CardDesign cardDesign = cardDesigns.get(index);
			transitCardConfiguration.addCardDesign(cardDesign);

			System.out.println();
			System.out.println(Ansi.color("Added to Cart: \n"
					+ cardDesign.getName(), Ansi.BRIGHT_GREEN));

			selectedCount++;

			if (selectedCount >= 3) {
				System.out.println();
				System.out.println(Ansi.color("Maximum card design has been selected.", Ansi.RED));
				System.out.println("Press ENTER to continue.");
				scanner.nextLine();

				Navigator.goToNextScreen(new LimeVoucherMenu(shoppingCart, transitCardConfiguration));
				return;
			}
		}
	}

}