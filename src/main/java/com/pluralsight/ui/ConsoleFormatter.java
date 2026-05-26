package com.pluralsight.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleFormatter {
	public static void displayHeader(String header, int width) {
		String border = "=".repeat(width);
		String centeredHeader = " ".repeat(((width - header.length()) / 2)) + header;

		System.out.println();
		System.out.println(border);
		System.out.println(centeredHeader);
		System.out.println(border);
	}

	public static void displayDivider(int width) {
		System.out.println("-".repeat(width));
	}


	public static void displayReceipt(String lineItemCategory, String lineItemName, String lineItemSubName, int quantity, double totalPrice) {
		int width = 50;

		int receiptId = 9999;
		String date = "2000-01-11";
		String time = "10:30:00";


		displayHeader("ORCACHE TRANSIT POS", width);
		System.out.println("Receipt ID: " + receiptId);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println();

		displayReceiptItemCategoryDivider(lineItemCategory, width);
		System.out.printf("%sx %-40s $%.2f%n", quantity, lineItemName, totalPrice);
		System.out.printf("   %-40s $%.2f%n", lineItemSubName, totalPrice);
		System.out.println();
		// %-40s → “Grand Total” padded to 40 characters, left-aligned.
		// $ stays fixed.
		// %7.2f → price number aligned in a 7-character field.
		displayDivider(width);
		System.out.printf("%-40s $%7.2f%n", "Grand Total", totalPrice);
		System.out.println("=".repeat(width));
	}


	public static void displayReceiptItemCategoryDivider(String lineItemCategory, int width) {
		System.out.println("-".repeat(width));
		System.out.println(lineItemCategory);
		System.out.println("-".repeat(width));
	}

	public static void displayChceckOutSummary(String lineItemCategory, String lineItemName, String lineItemSubName, int quantity, double totalPrice) {
		int width = 50;

		displayHeader("ORCACHE TRANSIT POS", width);
		System.out.println("Receipt ID: " + receiptId);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println();

		displayReceiptItemCategoryDivider(lineItemCategory, width);
		System.out.printf("%sx %-40s $%.2f%n", quantity, lineItemName, totalPrice);
		System.out.printf("   %-40s $%.2f%n", lineItemSubName, totalPrice);
		System.out.println();
		// %-40s → “Grand Total” padded to 40 characters, left-aligned.
		// $ stays fixed.
		// %7.2f → price number aligned in a 7-character field.
		displayDivider(width);
		System.out.printf("%-40s $%7.2f%n", "Grand Total", totalPrice);
		System.out.println("=".repeat(width));
	}

	//	(yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)
	//	[yyyy] [MM] [dd] - [hh] [mm] [ss]
	//	2023 03 29 - 12 15 23
	public static String currentDate(){
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");      // formatting the date and time
		return today.format(formatDate);        // returns the formatted date and time
	}

	public static String currentTime(){
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm:ss");      // formatting the date and time
		return today.format(formatTime);        // returns the formatted date and time
	}


}
