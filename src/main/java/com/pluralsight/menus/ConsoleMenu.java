package com.pluralsight.menus;

import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.ui.ConsoleFormatter;
import java.util.*;

public class ConsoleMenu {
	static ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	RetailItemMenu retailItemMenu = new RetailItemMenu(currentOrderItems);

	static Scanner scanner = new Scanner(System.in);
	static int width = 50;

	public static void displayHomeMenu() {
		while (true){
			consoleFormatter.displayHeader("HOME SCREEN" , width);

			System.out.println("1. New Order");
			System.out.println("0. Exit");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> displayOrderMenu();
				case "0" -> {
					System.out.println("Thank you for whatever");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

	public static void displayOrderMenu() {
		TransitPassMenu transitPassMenu = new TransitPassMenu(currentOrderItems);
		OrderSummaryMenu orderSummaryMenu = new OrderSummaryMenu(currentOrderItems);
		EPurseMenu ePurseMenu = new EPurseMenu(currentOrderItems);
		RetailItemMenu retailItemMenu = new RetailItemMenu(currentOrderItems);

		while (true){
			consoleFormatter.displayHeader("ORDER SCREEN" , width);

			System.out.println("1. Add Transit Pass");
			System.out.println("2. Add E-Purse Top-Up");
			System.out.println("3. Add Retail Item");
			System.out.println("4. View Current Order");
			System.out.println("5. Checkout");
			System.out.println("0. Cancel Order");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> transitPassMenu.displayBaseTransitServiceType();
				case "2"  -> ePurseMenu.displayEPurseTopUp();
				case "3"  -> retailItemMenu.displayRetailItem();
				case "4" -> orderSummaryMenu.displayCurrentOrderMenu();
				case "5"  -> orderSummaryMenu.displayCheckOutMenu();
				case "0" -> {
					System.out.println("Returning to home menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

}