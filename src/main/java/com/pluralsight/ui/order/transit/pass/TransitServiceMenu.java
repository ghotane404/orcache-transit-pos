package com.pluralsight.ui.order.transit.pass;

import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.model.enums.TransitServiceType;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.order.interfaces.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class TransitServiceMenu implements Menu {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	static RiderTypeMenu riderCategoryMenu = new RiderTypeMenu();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	@Override
	public String showMenuName() {
		return "Add Transit Pass";
	}

	@Override
	public void display(ArrayList<TransactionLineItem> currentOrderItems) {
		while (true) {
			consoleFormatter.displayHeader("SELECT TRANSIT SERVICE", WIDTH);
			System.out.println("1. Metro Bus");
			System.out.println("2. Link Light Rail");
			System.out.println("3. Rapid Ride");
			System.out.println("4. Sound Transit Express Bus");
			System.out.println();
			System.out.println("0. Return to Order Screen");

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			switch (userOption) {
				case "1" -> {
					riderCategoryMenu.displayRiderTypeMenu(TransitServiceType.METRO_BUS, currentOrderItems);
					return;
				}
				case "2" -> {
					riderCategoryMenu.displayRiderTypeMenu(TransitServiceType.LINK_LIGHT_RAIL, currentOrderItems);
					return;
				}
				case "3" -> {
					riderCategoryMenu.displayRiderTypeMenu(TransitServiceType.RAPID_RIDE,currentOrderItems);
					return;
				}
				case "4" -> {
					riderCategoryMenu.displayRiderTypeMenu(TransitServiceType.SOUND_TRANSIT_EXPRESS_BUS, currentOrderItems);
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



}
