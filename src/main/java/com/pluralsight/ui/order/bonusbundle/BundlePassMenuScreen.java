package com.pluralsight.ui.order.bonusbundle;

import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.model.cart.ShoppingCart;

import java.util.Scanner;

public class BundlePassMenuScreen implements MenuScreen {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;
	private ShoppingCart shoppingCart;

	@Override
	public String showMenuName() {
		return "Add Bundle Pass";
	}


	public BundlePassMenuScreen(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public void displayMenu() {
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
