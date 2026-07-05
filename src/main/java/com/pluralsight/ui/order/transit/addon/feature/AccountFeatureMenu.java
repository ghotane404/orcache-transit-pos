package com.pluralsight.ui.order.transit.addon.feature;

import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.AccountBenefit;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountFeatureMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	ArrayList<AccountBenefit> accountBenefits;
	private final ShoppingCart shoppingCart;
	private final TransitCardConfiguration transitCardConfiguration;

	public AccountFeatureMenu(ShoppingCart shoppingCart, TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		accountBenefits = new ArrayList<>();
		accountBenefits.add(new AccountBenefit("Auto-Reload Setup", 0));
		accountBenefits.add(new AccountBenefit("Digital Receipt", 0));
		accountBenefits.add(new AccountBenefit("Balance Tracking", 0));
		accountBenefits.add(new AccountBenefit("Trip History", 0));
		accountBenefits.add(new AccountBenefit("Email or SMS Fare Alerts", 0));
		accountBenefits.add(new AccountBenefit("Commuter Benefits Linking", 0));
	}

	@Override
	public String showMenuName() {
		return "Add Account Feature";
	}

	@Override
	public void displayMenu() {
		while (true) {
			ConsoleFormatter.displayHeader("SELECT ACCOUNT FEATURES", WIDTH);

			System.out.println("Enable optional account services for this card.");
			System.out.println("You may activate up to 3 features.");
			System.out.println();

			int selectedCount = transitCardConfiguration.getEAccountBenefits().size();

			ConsoleFormatter.displayRiderTypeHeader("Features Selected: " + selectedCount + " of 3", WIDTH);
			System.out.println();

			ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

			for (AccountBenefit accountBenefit : accountBenefits) {
				selectorBuilder.addSelection(String.format("%-36s %s",
						accountBenefit.getName(),
						"Included")
				);
			}

			selectorBuilder.addSelection("→ Continue to Card Design");

			int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

			if (userInput == 0) return;

			int index = userInput - 1;

			AccountBenefit accountBenefit = accountBenefits.get(index);
			transitCardConfiguration.addAccountBenefit(accountBenefit);

			System.out.println();
			System.out.println(Ansi.color("Added to Cart: \n"
					+ accountBenefit.getName(), Ansi.BRIGHT_GREEN));

			selectedCount++;

			if (selectedCount >= 3) {
				System.out.println();
				System.out.println(Ansi.color("Maximum account features has been selected.", Ansi.RED));
				System.out.println("Press ENTER to continue.");
				scanner.nextLine();

				Navigator.goToNextScreen(new CardDesignMenu(shoppingCart, transitCardConfiguration));
				return;
			}
		}
	}
}
