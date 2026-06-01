package com.pluralsight.ui.order.retail;

import com.pluralsight.ui.order.interfaces.Menu;
import com.pluralsight.model.enums.RetailAccessory;
import com.pluralsight.model.enums.RetailTier;
import com.pluralsight.model.item.RetailAccessoryItem;
import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.util.TransitPricingModel;
import com.pluralsight.util.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class RetailAccessoryMenu implements Menu {
	private ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;


	@Override
	public String showMenuName() {
		return "Add Retail Item";
	}


	@Override
	public void display(ArrayList<TransactionLineItem> currentOrderItems) {
		while (true) {
			consoleFormatter.displayHeader("SELECT RETAIL ACCESSORY", WIDTH);
			System.out.println("Select an accessory to continue, then choose a tier.");
			System.out.println();
			System.out.println("1. Card Wallet Holder");
			System.out.println("2. Protective Card Sleeve");
			System.out.println("3. Lanyard with Breakaway");
			System.out.println("4. RFID-Blocking Card Holder");
			System.out.println();
			System.out.println("0. Cancel and Return to Order Screen");
			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			RetailAccessory selectedAccessory = null;

			switch (userOption) {
				case "1" -> selectedAccessory = RetailAccessory.CARD_WALLET_HOLDER;
				case "2" -> selectedAccessory = RetailAccessory.PROTECTIVE_CARD_SLEEVE;
				case "3" -> selectedAccessory = RetailAccessory.LANYARD_WITH_BREAKAWAY;
				case "4" -> selectedAccessory = RetailAccessory.RFID_BLOCKING_CARD_HOLDER;
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}

			retailTierPrice(selectedAccessory, currentOrderItems);

		}
	}

	public void retailTierPrice(RetailAccessory selectedAccessory, ArrayList<TransactionLineItem> currentOrderItems)  {

		while (true) {
			consoleFormatter.displayHeader("SELECT RETAIL TIER", WIDTH);
			System.out.println("Choose a tier level.");
			System.out.println();
			System.out.println("1. Basic");
			System.out.println("2. Standard");
			System.out.println("3. Premium");
			System.out.println();
			System.out.println("0. Cancel and Return to Order Screen");

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			RetailTier selectedTier = null;

			switch (userOption) {
				case "1" -> selectedTier = RetailTier.BASIC;
				case "2" -> selectedTier = RetailTier.STANDARD;
				case "3" -> selectedTier = RetailTier.PREMIUM;
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}

			double unitPrice = TransitPricingModel.getRetailAccessoryPrice(selectedAccessory, selectedTier);
			RetailAccessoryItem retailAccessoryItem = new RetailAccessoryItem(selectedAccessory, 1, unitPrice);

			currentOrderItems.add(retailAccessoryItem);

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-30s $ %6.2f%n", selectedAccessory.getDisplayName(), unitPrice);
			System.out.println();

			System.out.println("Press ENTER to continue.");
			scanner.nextLine();

			return;
		}
	}

}
