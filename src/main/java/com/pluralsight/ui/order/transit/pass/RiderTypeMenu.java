package com.pluralsight.ui.order.transit.pass;

import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.model.item.TransitPassItem;
import com.pluralsight.model.enums.RiderType;
import com.pluralsight.model.enums.TransitServiceType;
import com.pluralsight.util.TransitPricingModel;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.order.transit.addon.TransitPassAddOnMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class RiderTypeMenu {
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	public RiderTypeMenu() {
	}

	public void displayRiderTypeMenu(TransitServiceType selectedTransitServiceType, ArrayList<TransactionLineItem> currentOrderItems) {
		while (true) {
			consoleFormatter.displayHeader("SELECT RIDER TYPE", WIDTH);
			System.out.printf("%-40s $%7.2f%n", "1. Adult", TransitPricingModel.getTransitPassPrice(RiderType.ADULT));
			System.out.printf("%-40s $%7.2f%n", "2. Senior", TransitPricingModel.getTransitPassPrice(RiderType.SENIOR));
			System.out.printf("%-40s $%7.2f%n", "1. Youth", TransitPricingModel.getTransitPassPrice(RiderType.YOUTH));
			System.out.println();
			System.out.println("0. Cancel and Return to Order Screen");

			consoleFormatter.divider(WIDTH);
			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			RiderType selectedRiderType = null;

			switch (userOption) {
				case "1" -> {selectedRiderType = RiderType.ADULT;}
				case "2" -> {selectedRiderType = RiderType.SENIOR;}
				case "3" -> {selectedRiderType = RiderType.YOUTH;}
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
				System.out.print("Please enter the quantity to purchase: ");
				quantity = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid quantity. Please enter a number.");
				continue;
			}

			double unitPrice = TransitPricingModel.getTransitPassPrice(selectedRiderType);

			TransitPassItem transitPassItem = new TransitPassItem(selectedTransitServiceType, selectedRiderType,
					quantity, unitPrice);
			currentOrderItems.add(transitPassItem);

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-30s $ %6.2f%n", selectedRiderType.getDisplayName(),unitPrice);
			System.out.printf("    Additional: $ %.2f x %d%n", unitPrice, quantity);
			System.out.println();

			System.out.println("Press ENTER to continue.");
			scanner.nextLine();

			TransitPassAddOnMenu transitPassAddOnMenu = new TransitPassAddOnMenu();
			transitPassAddOnMenu.displayTransitPassAddOnMenu(selectedRiderType, currentOrderItems);

			return;
		}

	}


}
