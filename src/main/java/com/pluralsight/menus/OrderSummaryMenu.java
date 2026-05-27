package com.pluralsight.menus;

import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.ui.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderSummaryMenu {
	private final int width = 50;
	private final Scanner scanner = new Scanner(System.in);
	private ArrayList<TransactionLineItem> currentOrderItems;
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	public OrderSummaryMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		this.currentOrderItems = currentOrderItems;
	}

	public void displayCurrentOrderMenu(){
		double orderTotal = 0;

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		consoleFormatter.displayHeader("CURRENT ORDER", width);

		String lastPrintedCategory = "";

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory  = currentOrderItem.getLineItemCategory();
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			if (!lineItemCategory.equals(lastPrintedCategory)) {
				consoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;
			}
			System.out.printf("%dx %-35s $%.2f%n", quantity, lineItemName, totalPrice);
			orderTotal += totalPrice;
		}

		System.out.println();
		consoleFormatter.displayDivider(width);
		System.out.printf("%-38s $%.2f%n", "Order Total ", orderTotal);
		System.out.print("Press Enter to return to the order menu.");
		scanner.nextLine();

	}

	public void displayCheckOutMenu(){
		String date = consoleFormatter.currentDate();
		String time = consoleFormatter.currentTime();
		int receiptId = 9999;
		double grandTotal = 0;
		String lastPrintedCategory = "";

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		consoleFormatter.displayHeader("CHECKOUT MENU", width);
		System.out.println("Receipt ID: " + receiptId);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		consoleFormatter.displayDivider(width);

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory = currentOrderItem.getLineItemCategory();
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			// Printing ITEM CATEGORIES in the receipt
			if (!lineItemCategory.equals(lastPrintedCategory)) {
				consoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;     //
			}

			System.out.printf("%dx %-35s $%.2f%n", quantity, lineItemName, totalPrice);
			grandTotal += totalPrice;
		}

		System.out.println();
		consoleFormatter.displayDivider(width);
		System.out.printf("%-40s $%7.2f%n", "Grand Total", grandTotal);
		System.out.println("=".repeat(width));
		currentOrderItems.clear();
	}


}
