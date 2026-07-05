package com.pluralsight.ui.order.transit.addon.feature;


import com.pluralsight.model.cart.TransitCardConfiguration;
import com.pluralsight.model.option.LimeVoucher;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.ArrayList;
import java.util.Scanner;

public class LimeVoucherMenu implements MenuScreen {
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	ArrayList<LimeVoucher> limeVouchers;
	private ShoppingCart shoppingCart;
	private TransitCardConfiguration transitCardConfiguration;

	public LimeVoucherMenu(ShoppingCart shoppingCart,  TransitCardConfiguration transitCardConfiguration) {
		this.shoppingCart = shoppingCart;
		this.transitCardConfiguration = transitCardConfiguration;

		limeVouchers = new ArrayList<>();
		limeVouchers.add(new LimeVoucher("Lime First 30-Minute Ride Free", 0));
		limeVouchers.add(new LimeVoucher("Weekend 25 % Ride Off Promo", 0));
		limeVouchers.add(new LimeVoucher("Morning 50 % Commuter Discount", 0));
	}

	@Override
	public String showMenuName() {
		return "Select Lime Voucher";
	}

	@Override
	public void displayMenu() {
		while (true) {
			ConsoleFormatter.displayHeader("SELECT LIME DISCOUNT VOUCHERS", WIDTH);
			System.out.println("Add Lime discount vouchers to this transit card.");
			System.out.println("You may select up to 3 vouchers.");
			System.out.println();

			int selectedCount = transitCardConfiguration.getELimeVouchers().size();

			System.out.println(Ansi.color("Vouchers Selected: " + selectedCount + " of 3", Ansi.GREEN));
			System.out.println();
			ConsoleSelector.Builder selectorBuilder = new ConsoleSelector.Builder().setWidth(WIDTH);

			for (LimeVoucher limeVoucher : limeVouchers) {
				selectorBuilder.addSelection(String.format("%-36s %s",
						limeVoucher.getName(), "Included"));
			}

			selectorBuilder.addSelection("→ Add to Cart");

			int userInput = selectorBuilder.build().showSelectionAndGetUserInput();

			if (userInput == 0) return;

			int index = userInput - 1;

			LimeVoucher limeVoucher = limeVouchers.get(index);
			transitCardConfiguration.addLimeVoucher(limeVoucher);

			System.out.println();
			System.out.println(Ansi.color("Added to Cart: \n"
					+ limeVoucher.getName(), Ansi.BRIGHT_GREEN));

			selectedCount++;

			if (selectedCount >= 3) {
				System.out.println();
				System.out.println(Ansi.color("Maximum lime voucher has been selected.", Ansi.RED));
				System.out.println("Press ENTER to continue.");
				scanner.nextLine();

				Navigator.goToNextScreen(new CardDesignMenu(shoppingCart, transitCardConfiguration));
				return;
			}




		}

	}

}

