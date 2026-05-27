package com.pluralsight.menus;

import com.pluralsight.menus.transitaddons.TransitPassAddOnMenu;
import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.ui.ConsoleFormatter;

import java.util.*;

public class TransitPassMenu {
	ArrayList<TransactionLineItem> currentOrderItems;
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	TransitPassAddOnMenu transitPassAddOnMenu;
	static Scanner scanner = new Scanner(System.in);
	private final int width = 50;

	public TransitPassMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		this.currentOrderItems = currentOrderItems;
		this.transitPassAddOnMenu = new TransitPassAddOnMenu(currentOrderItems);
	}

	public void displayBaseTransitServiceType() {
		while (true) {
			consoleFormatter.displayHeader("SELECT BASE TRANSIT SERVICE", width);
			System.out.println("1. Metro Bus");
			System.out.println("2. Link Light Rail");
			System.out.println("3. Rapid Ride");
			System.out.println("4. Sound Transit Express Bus");
			System.out.println("0. Return to Order Screen");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();
			switch (userInput) {
				case "1" -> {
					displayRiderCategory(BaseTransitServiceType.METRO_BUS);
					return;
				}
				case "2" -> {
					displayRiderCategory(BaseTransitServiceType.LINK_LIGHT_RAIL);
					return;
				}
				case "3" -> {
					displayRiderCategory(BaseTransitServiceType.RAPID_RIDE);
					return;
				}
				case "4" -> {
					displayRiderCategory(BaseTransitServiceType.SOUND_TRANSIT_EXPRESS_BUS);
					return;
				}
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

	public void displayRiderCategory(BaseTransitServiceType selectedBaseTransitServiceType) {
		while (true) {
			consoleFormatter.displayHeader("SELECT RIDER CATEGORY", width);
			System.out.printf("%s %-30s %15s%n", "1.", "Adult", "$3.00 base fare");
			System.out.printf("%s %-30s %15s%n", "2.", "Senior", "$1.00 base fare");
			System.out.printf("%s %-30s %15s%n", "3.", "Youth", "$2.00 base fare");
			System.out.println("0. Return to Base Transit Service");
			consoleFormatter.displayDivider(width);
			System.out.print("Please select rider category: ");
			String userInput = scanner.nextLine();
			switch (userInput) {
				case "1" -> {
					transitPassAddOnMenu.displayTransitPassAddOnMenu(RiderCategory.ADULT, selectedBaseTransitServiceType);
					return;
				}
				case "2" -> {
					transitPassAddOnMenu.displayTransitPassAddOnMenu(RiderCategory.SENIOR, selectedBaseTransitServiceType);
					return;
				}
				case "3" -> {
					transitPassAddOnMenu.displayTransitPassAddOnMenu(RiderCategory.YOUTH, selectedBaseTransitServiceType);
					return;
				}
				case "0" -> {
					System.out.println("Returning to Base Transit Service.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}
}