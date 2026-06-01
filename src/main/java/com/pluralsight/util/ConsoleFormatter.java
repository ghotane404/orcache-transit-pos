package com.pluralsight.util;

import com.pluralsight.model.item.base.TransactionLineItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsoleFormatter {
	int WIDTH = 65;

	public ConsoleFormatter() {
	}

//	public void displayHeader(String text, int WIDTH) {
//		String headerLine = "=".repeat(WIDTH);
//		String centeredText = " ".repeat(((WIDTH - text.length()) / 2)) + text;
//
//		System.out.println();
//		System.out.println(headerLine);
//		System.out.println(centeredText);
//		System.out.println(headerLine);
//	}
	public String centeredText(String text, int WIDTH){
		StringBuilder receipt = new StringBuilder();
		String centeredText = " ".repeat(((WIDTH - text.length()) / 2)) + text;
		receipt.append(centeredText);
		return receipt.toString();
	}

	public void displayHeader(String text, int WIDTH) {
		StringBuilder receipt = new StringBuilder();
		String headerLine = "=".repeat(WIDTH);

		receipt.append("\n");
		receipt.append(headerLine).append("\n");
		receipt.append(centeredText(text, WIDTH)).append("\n");
		receipt.append(headerLine).append("\n");
		System.out.println(receipt);
	}

	public void categoryHeader(String text, int WIDTH) {
		StringBuilder receipt = new StringBuilder();
		String headerLine = "-".repeat(WIDTH);

//		receipt.append("\n");
		receipt.append(headerLine).append("\n");
		receipt.append(centeredText(text, WIDTH)).append("\n");
		receipt.append(headerLine);
		System.out.println(receipt);
	}


	public void createReceipt(ArrayList<TransactionLineItem> currentOrderItems) {
		StringBuilder receipt = new StringBuilder();
		String headerLine = "=".repeat(WIDTH);
		String divider = "-".repeat(WIDTH);

		// header
		receipt.append(headerLine).append("\n");
		receipt.append(centeredText("CHECKOUT SUMMARY", WIDTH)).append("\n");
		receipt.append(headerLine).append("\n");

		receipt.append("Date: ").append(currentDate()).append("\n");
		receipt.append("Time: ").append(currentTime()).append("\n");

		double orderTotal = 0;
		String lastCategory = ""; // tracks which category section we're currently printing

		// checks every item in currentOrderItems that was added
		for (TransactionLineItem item : currentOrderItems) {
			// Prints the category section heading (Catefory: Transit Pass, Card Style, Lime Discount Voucher etc)
			if (!item.getLineItemCategory().equals(lastCategory)) {
				receipt.append("\n");
				receipt.append(item.getLineItemCategory()).append("\n");
				receipt.append(divider).append("\n");
				lastCategory = item.getLineItemCategory();
			}

			// Free items are included
			if (item.getUnitPrice() == 0) {
				receipt.append(String.format("  %-44s %s%n", item.getLineItemName(), "Included"));
			}
			else {
				// all paid items will show: name, quantity, unit price, and total total
				receipt.append(String.format("  %-28s Qty: %-4d @ $%-8.2f $%.2f%n",
						item.getLineItemName(), item.getQuantity(), item.getUnitPrice(), item.getTotalPrice()));
			}
			orderTotal += item.getTotalPrice();     // adding the cost of item to the total cost
		}
		System.out.println(receipt);
	}

	public void divider(int WIDTH) {
		StringBuilder receipt = new StringBuilder();
		String divider = "-".repeat(WIDTH);

		receipt.append("\n");
		receipt.append(divider).append("\n");
		System.out.println("-".repeat(WIDTH));
		receipt.append("\n");
	}

	public void displayTypeIdentifier(String text, int WIDTH) {
		StringBuilder receipt = new StringBuilder();
		receipt.append(text).append("\n");
		receipt.append(" ".repeat(WIDTH)).append("\n");
		System.out.println(receipt);
	}

	public void catergoryDivider(String lineItemCategory, int WIDTH) {
		StringBuilder receipt = new StringBuilder();

		String divider = "-".repeat(WIDTH);

		receipt.append(divider).append("\n");
		receipt.append(lineItemCategory).append("\n");
		receipt.append(divider).append("\n");
		System.out.println(receipt);
	}

	public String currentDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return now.format(formatter);
	}

	public String currentTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
		return now.format(formatter);
	}


}
