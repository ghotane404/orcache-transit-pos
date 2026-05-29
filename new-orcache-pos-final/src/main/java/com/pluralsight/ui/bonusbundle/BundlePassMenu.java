package com.pluralsight.ui.bonusbundle;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.ui.format.ConsoleFormatter;
import com.pluralsight.ui.transit.RiderTypeMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class BundlePassMenu {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	static RiderTypeMenu riderCategoryMenu = new RiderTypeMenu();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	public void displayBundleMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		System.out.println("WIP");
		while(true) {
			consoleFormatter.displayHeader("SELECT BUNDLE PASS", WIDTH);
			System.out.printf("1. %-40s $ %7.2f%n", "Commuter Card", 111.00);
			System.out.printf("2. %-40s $ %7.2f%n", "Regional Traveler Card", 120.00);
			System.out.printf("3. %-40s $ %7.2f%n", "Student Starter Card", 9.00);
			System.out.println();

			System.out.println("0. Cancel and Return to Order Screen");
			System.out.println();

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			switch (userOption) {
				case "1" -> {
					System.out.println("$5");
				}
				case "2" -> {
					System.out.println("$10");
					return;
				}
				case "3" -> {
					System.out.println("$15");
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
