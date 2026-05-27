package com.pluralsight.menus;

import com.pluralsight.model.option.*;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.ui.ConsoleFormatter;
import java.util.*;

public class RetailItemMenu {
	private ArrayList<TransactionLineItem> currentOrderItems;
	private ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	static Scanner scanner = new Scanner(System.in);
	static int width = 50;

	private String itemName;
	private double price;

	public RetailItemMenu() {

	}

	public RetailItemMenu(String itemName, double price) {
		this.itemName = itemName;
		this.price = price;
	}

	public RetailItemMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		this.currentOrderItems = currentOrderItems;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public void displayRetailItem() {
		while (true) {
			consoleFormatter.displayHeader("SELECT RETAIL ITEM", width);
			System.out.println("1. Transit Card Wallet       $12.99");
			System.out.println("2. RFID-Blocking Sleeve      $7.99");
			System.out.println("3. Protective Card Sleeve    $4.99");
			System.out.println("4. Lanyard with Breakaway    $9.99");
			System.out.println("0. Return to Order Screen");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> addRetailItemToOrder("Transit Card Wallet", "Black", 12.99);
				case "2" -> addRetailItemToOrder("RFID-Blocking Sleeve", "Blue", 7.99);
				case "3" -> addRetailItemToOrder("Protective Card Sleeve", "Clear", 4.99);
				case "4" -> addRetailItemToOrder("Lanyard with Safety Breakaway", "Green", 9.99);
				case "0" -> {
					System.out.println("Returning back to previous menu.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}
			return;
		}
	}

	public void addRetailItemToOrder(String itemName, String color, double unitPrice) {
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
