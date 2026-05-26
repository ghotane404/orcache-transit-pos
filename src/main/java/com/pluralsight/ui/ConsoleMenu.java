package com.pluralsight.ui;

import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.option.TransitPassAddOn;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.service.FareCalculationService;

import java.util.*;

public class ConsoleMenu {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();

	public static void displayHomeMenu() {
		String userInput;
		int width = 50;

		while (true){
			ConsoleFormatter.displayHeader("HOME SCREEN" , width);

			System.out.println("1. New Order");
			System.out.println("0. Exit");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			userInput = scanner.nextLine();

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
		String userInput;
		int width = 50;

		while (true){
			ConsoleFormatter.displayHeader("ORDER SCREEN" , width);

			System.out.println("1. Add Transit Card");
			System.out.println("2. View Current Order");
			System.out.println("3. Checkout");
			System.out.println("0. Cancel Order");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> addTransitPass();
				case "2"  -> displayCurrentOrder();
				case "3"  -> displayCheckOut();
				case "0" -> {
					System.out.println("Returning to home menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

	public static void addTransitPass() {
		String userInput;
		int width = 50;

		while (true){
			ConsoleFormatter.displayHeader("SELECT RIDER CATEGORY" , width);

			System.out.println("1. Adult");
			System.out.println("2. Senior");
			System.out.println("3. Youth");
			System.out.println("0. Return to Order Screen");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					baseTransitServiceType(RiderCategory.ADULT);
					return;
				}
				case "2"  -> {
					baseTransitServiceType(RiderCategory.SENIOR);
					return;
				}
				case "3"  -> {
					baseTransitServiceType(RiderCategory.YOUTH);
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

	public static void baseTransitServiceType(RiderCategory selectedRiderCategory) {
		String userInput;
		int width = 50;

		while (true){
			ConsoleFormatter.displayHeader("SELECT BASE TRANSIT SERVICE" , width);

			System.out.println("1. Metro Bus");
			System.out.println("2. Link Light Rail");
			System.out.println("3. Rapid Ride");
			System.out.println("4. Sound Transit Express Bus");
			System.out.println("0. Return to Rider Screen");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					transitPassAddOn(selectedRiderCategory, BaseTransitServiceType.METRO_BUS);
					return;
				}
				case "2"  -> {
					transitPassAddOn(selectedRiderCategory, BaseTransitServiceType.LINK_LIGHT_RAIL);
					return;
				}
				case "3"  -> {
					transitPassAddOn(selectedRiderCategory, BaseTransitServiceType.RAPID_RIDE);
					return;
				}
				case "4"  -> {
					transitPassAddOn(selectedRiderCategory, BaseTransitServiceType.SOUND_TRANSIT_EXPRESS_BUS);
					return;
				}
				case "0" -> {
					System.out.println("Returning to Rider Screen.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}


	public static void transitPassAddOn(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType) {
		int width = 50;
		String userInput;

		while(true){
			ConsoleFormatter.displayHeader("SELECT FARE PRODUCT" , width);

			System.out.println("1. All Day Pass");
			System.out.println("2. Monthly Pass");
			System.out.println("3. Starter $100 E-Purse Value");
			System.out.println("0. Return to Base Transit Service");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					printTransitCardSummary(selectedRiderCategory,selectedBaseTransitServiceType, TransitPassAddOn.ALL_DAY_PASS);
					return;
				}
				case "2"-> {
					printTransitCardSummary(selectedRiderCategory,selectedBaseTransitServiceType, TransitPassAddOn.MONTHLY_PASS);
					return;
				}
				case "3" -> {
					printTransitCardSummary(selectedRiderCategory,selectedBaseTransitServiceType, TransitPassAddOn.E_PURSE);
					return;
				}
				case "0" ->{
					System.out.println("Returning back to previous menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

	public static void printTransitCardSummary(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType, TransitPassAddOn selectedTransitPassAddOn){
		int width = 50;
		double totalPrice = FareCalculationService.calculateTransitCardTotal(selectedTransitPassAddOn,  selectedRiderCategory);

//		String lineItemCategory = "TRANSIT PASS ADD-ON";
		String lineItemName = (selectedBaseTransitServiceType.getDisplayName() + " - " + selectedRiderCategory.getDisplayName());
		String lineItemSubName = selectedTransitPassAddOn.getDisplayName();

		String riderCategory = selectedRiderCategory.getDisplayName();
		String baseTransitService = selectedBaseTransitServiceType.getDisplayName();
		String fareProduct = selectedTransitPassAddOn.getDisplayName();

		int quantity = 1;
		double unitPrice = FareCalculationService.calculateTransitCardTotal(selectedTransitPassAddOn,  selectedRiderCategory);

		TransactionLineItem currentOrderItem = new TransactionLineItem(LineItemCategory.TRANSIT_PASS_ADD_ON.getDisplayName(), lineItemName, riderCategory, baseTransitService, fareProduct, quantity, unitPrice, totalPrice);
		currentOrderItems.add(currentOrderItem);

//		ConsoleFormatter.displayReceipt(lineItemCategory, lineItemName, lineItemSubName, quantity, totalPrice);
	}


	public static void displayCurrentOrder(){
		int width = 50;
		double orderTotal = 0;
		int orderQuantity = 1;

		TransitPassAddOn transitPassAddOn;

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		ConsoleFormatter.displayHeader("CURRENT ORDER", width);

		String lastPrintedCategory = "";

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory  = currentOrderItem.getLineItemCategory();
			String lineItemSubName;
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			if (!lineItemCategory.equals(lastPrintedCategory)) {
				ConsoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;
			}
			System.out.printf("%dx %-35s $%.2f%n", quantity, lineItemName, totalPrice);
			orderTotal += totalPrice;
			orderQuantity += quantity;
		}

		System.out.println();
		ConsoleFormatter.displayDivider(width);
		System.out.printf("%-38s $%.2f%n", "Order Total ", orderTotal);
		System.out.print("Press Enter to return to the order menu.");
		scanner.nextLine();
	}


	public static void displayCheckOut(){
		int width = 50;
		int receiptId = 9999;
		String date = "2000-01-11";
		String time = "10:30:00";

		double grandTotal = 0;
		String lastPrintedCategory = "";

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		ConsoleFormatter.displayHeader("ORCACHE TRANSIT POS", width);
		System.out.println("Receipt ID: " + receiptId);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println();

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory = currentOrderItem.getLineItemCategory();
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			if (!lineItemCategory.equals(lastPrintedCategory)) {
				ConsoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;
			}

			System.out.printf("%dx %-35s $%.2f%n", quantity, lineItemName, totalPrice);
			grandTotal += totalPrice;
		}

		System.out.println();
		ConsoleFormatter.displayDivider(width);
		System.out.printf("%-40s $%7.2f%n", "Grand Total", grandTotal);
		System.out.println("=".repeat(width));
		currentOrderItems.clear();

	}


}