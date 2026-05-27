package com.pluralsight.menus;

import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.ItemProduct;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.option.TransitPassAddOn;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.service.TransitPricingModel;
import com.pluralsight.ui.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class EPurseMenu {
	ArrayList<TransactionLineItem> currentOrderItems;
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private final Scanner scanner = new Scanner(System.in);
	private int width = 50;

	public EPurseMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		this.currentOrderItems = currentOrderItems;
	}

	public void displayRiderCategoryforEpurse() {
		while (true) {
			consoleFormatter.displayHeader("SELECT RIDER CATEGORY", width);
			System.out.println("1. Adult");
			System.out.println("2. Senior");
			System.out.println("3. Youth");
			System.out.println("0. Return to Order");
			consoleFormatter.displayDivider(width);
			System.out.print("Please select rider category: ");
			String userInput = scanner.nextLine();
			switch (userInput) {
				case "1" -> {
					displayEPurseTopUp(RiderCategory.ADULT);
					return;
				}
				case "2" -> {
					displayEPurseTopUp(RiderCategory.SENIOR);
					return;
				}
				case "3" -> {
					displayEPurseTopUp(RiderCategory.YOUTH);
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

	public void displayEPurseTopUp(RiderCategory selectedRiderCategory) {
		while (true){
			consoleFormatter.displayHeader("SELECT E-PURSE TOP-UP" , width);
			System.out.println("1. $10 E-Purse Top-Up");
			System.out.println("2. $25 E-Purse Top-Up");
			System.out.println("3. $50 E-Purse Top-Up");
			System.out.println("4. $100 E-Purse Top-Up");
			System.out.println("0. Cancel");

			System.out.printf("%-43s $%7.2f%n", "1. $10 E-Purse Top-Up",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.E_PURSE));
			System.out.printf("%-43s $%7.2f%n", "2. $25 E-Purse Top-Up",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.E_PURSE));
			System.out.printf("%-43s $%7.2f%n", "3. $50 E-Purse Top-Up",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.E_PURSE));
			System.out.printf("%-43s $%7.2f%n", "4. $100 E-Purse Top-Up",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.E_PURSE, selectedRiderCategory));
			System.out.println("0. Return to Base Transit Service");



			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					System.out.println("$10 E-Purse Top-Up");
					return;
				}
				case "2"  -> {
					System.out.println("$25 E-Purse Top-Up");
					return;
				}
				case "3"  -> {
					System.out.println("$50 E-Purse Top-Up");
					return;
				}
				case "4"  -> {
					System.out.println("$100 E-Purse Top-Up");
					return;
				}
				case "0" -> {
					System.out.println("Returning back to previous menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}

		}
	}


	public void getAddOnTransitPrice(String itemName, String color, double unitPrice) {
		int quantity = 1;
		double totalPrice = unitPrice * quantity;
		String lineItemName = itemName + " - " + color;

		TransactionLineItem currentOrderItem = new TransactionLineItem(
				ItemProduct.RETAIL_ITEM.getDisplayName(), lineItemName,
				"", "", "",
				quantity, unitPrice, totalPrice);

		currentOrderItems.add(currentOrderItem);

		System.out.println();
		System.out.println(lineItemName + " added to current order.");
	}



}
