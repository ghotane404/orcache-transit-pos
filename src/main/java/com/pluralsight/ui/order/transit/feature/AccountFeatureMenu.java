package com.pluralsight.ui.order.transit.feature;

import com.pluralsight.model.item.AccountFeatureItem;
import com.pluralsight.model.enums.AccountFeatureOption;
import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.util.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountFeatureMenu {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;

	public void displayAccountFeatureMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		int maxAmount = 0;

		while (true) {
			if (maxAmount >= 3) {
				System.out.println("Maximum of 3 features reached. Press ENTER to continue.");
				scanner.nextLine();
				CardStyleMenu cardStyleMenu = new CardStyleMenu();
				cardStyleMenu.displayCardStyleMenu(currentOrderItems);
				return;
			}
			consoleFormatter.displayHeader("SELECT ACCOUNT FEATURES", WIDTH);

			System.out.println("Choose free account features for this card.");
			System.out.println();
			System.out.println("Each feature can be added to up to 3 devices.");
			System.out.println();

			System.out.println("1. Auto-Reload Setup                      Included");
			System.out.println("2. Digital Receipt                        Included");
			System.out.println("3. Balance Tracking                       Included");
			System.out.println("4. Trip History                           Included");
			System.out.println("5. Email or SMS Fare Alerts               Included");
			System.out.println("6. Commuter Benefits Linking              Included");
			System.out.println("7. Continue to Next Step");
			System.out.println();

			System.out.println("0. Cancel and Return to Order Screen");
			System.out.println();

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select a option: ");
			String userOption = scanner.nextLine();

			AccountFeatureOption selectedAccountFeatureOption = null;

			switch (userOption) {
				case "1" -> { selectedAccountFeatureOption = AccountFeatureOption.AUTO_RELOAD_SETUP;}
				case "2" -> { selectedAccountFeatureOption = AccountFeatureOption.DIGITAL_RECEIPT; }
				case "3" -> { selectedAccountFeatureOption = AccountFeatureOption.BALANCE_TRACKING; }
				case "4" -> { selectedAccountFeatureOption = AccountFeatureOption.TRIP_HISTORY; }
				case "5" -> { selectedAccountFeatureOption = AccountFeatureOption.FARE_ALERTS; }
				case "6" -> { selectedAccountFeatureOption = AccountFeatureOption.COMMUTER_BENEFITS_LINKING; }
				case "7" -> {
					CardStyleMenu cardStyleMenu = new CardStyleMenu();
					cardStyleMenu.displayCardStyleMenu(currentOrderItems);
					return;
				}
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}

			int quantity;
			try {
				System.out.print("Please enter number of devices to activate, between 1 and 3: ");
				quantity = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid quantity. Please enter a number.");
				continue;
			}

			if  (quantity < 1 || maxAmount + quantity > 3) {
				System.out.println("Invalid quantity. You may select between 1 and 3 Lime discount vouchers.");
				continue;
			}

			AccountFeatureItem accountFeatureItem = new AccountFeatureItem(selectedAccountFeatureOption, quantity);
			currentOrderItems.add(accountFeatureItem);
			maxAmount += quantity;

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-50s %s%n", selectedAccountFeatureOption.getDisplayName(), "Included");
			System.out.printf("      x %d%n", 1 + accountFeatureItem.getAddOnQuantity());
			System.out.println();

			System.out.println("Press ENTER to continue.");
			scanner.nextLine();

//			CardStyleMenu cardStyleMenu = new CardStyleMenu();
//			cardStyleMenu.displayCardStyleMenu(currentOrderItems);

//			return;
		}
	}
}
