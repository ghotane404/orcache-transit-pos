package com.pluralsight.ui;

import com.pluralsight.model.option.*;
import com.pluralsight.model.product.BaseTransitSetvice;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.service.TransitPricingModel;

import java.util.*;

public class ConsoleMenu {
	static int width = 50;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();

	public static void displayHomeMenu() {
		while (true){
			ConsoleFormatter.displayHeader("HOME SCREEN" , width);

			System.out.println("1. New Order");
			System.out.println("0. Exit");
			ConsoleFormatter.displayDivider(width);
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
		BaseTransitSetvice bts = new BaseTransitSetvice();

		while (true){
			ConsoleFormatter.displayHeader("ORDER SCREEN" , width);

			System.out.println("1. Add Transit Pass");
			System.out.println("2. Add E-Purse Top-Up");
			System.out.println("3. Add Retail Item");
			System.out.println("4. View Current Order");
			System.out.println("5. Checkout");
			System.out.println("0. Cancel Order");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> bts.displayBaseTransitServiceType(width);
				case "2"  -> displayEPurseTopUp();
				case "3"  -> displayRetailItem();
				case "4"  -> displayCurrentOrder();
				case "5"  -> displayCheckOut();
				case "0" -> {
					System.out.println("Returning to home menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

//	public static void displayBaseTransitServiceType() {
//		while (true) {
//			ConsoleFormatter.displayHeader("SELECT BASE TRANSIT SERVICE", width);
//			System.out.println("1. Metro Bus");
//			System.out.println("2. Link Light Rail");
//			System.out.println("3. Rapid Ride");
//			System.out.println("4. Sound Transit Express Bus");
//			System.out.println("0. Return to Order Screen");
//			ConsoleFormatter.displayDivider(width);
//			System.out.print("Select an option: ");
//			String userInput = scanner.nextLine();
//			switch (userInput) {
//				case "1" -> {
//					displayRiderCategory(BaseTransitServiceType.METRO_BUS);
//					return;
//				}
//				case "2" -> {
//					displayRiderCategory(BaseTransitServiceType.LINK_LIGHT_RAIL);
//					return;
//				}
//				case "3" -> {
//					displayRiderCategory(BaseTransitServiceType.RAPID_RIDE);
//					return;
//				}
//				case "4" -> {
//					displayRiderCategory(BaseTransitServiceType.SOUND_TRANSIT_EXPRESS_BUS);
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Order Screen.");
//					return;
//				}
//				default -> System.out.println("Invalid option.");
//			}
//		}
//	}

//	public static void displayRiderCategory(BaseTransitServiceType selectedBaseTransitServiceType) {
//		while (true) {
//			ConsoleFormatter.displayHeader("SELECT RIDER CATEGORY", width);
//			System.out.println("1. Adult      $3.00 base fare");
//			System.out.println("2. Senior    $1.00 base fare");
//			System.out.println("3. Youth     $2.00 base fare");
//			System.out.println("0. Return to Base Transit Service");
//			ConsoleFormatter.displayDivider(width);
//			System.out.print("Please select rider type: ");
//			String userInput = scanner.nextLine();
//			switch (userInput) {
//				case "1" -> {
//					displayTransitPassAddOnMenu(RiderCategory.ADULT, selectedBaseTransitServiceType);
//					return;
//				}
//				case "2" -> {
//					displayTransitPassAddOnMenu(RiderCategory.SENIOR, selectedBaseTransitServiceType);
//					return;
//				}
//				case "3" -> {
//					displayTransitPassAddOnMenu(RiderCategory.YOUTH, selectedBaseTransitServiceType);
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Base Transit Service.");
//					return;
//				}
//				default -> System.out.println("Invalid option.");
//			}
//		}
//	}

	public static void displayTransitPassAddOnMenu(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType) {
		while(true){
			ConsoleFormatter.displayHeader("SELECT TRANSIT PASS ADD-ON" , width);

			System.out.println("1. All Day Pass");
			System.out.println("2. Monthly Pass");
			System.out.println("3. Starter $100 E-Purse Value");
			System.out.println("0. Return to Base Transit Service");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					printTransitCartSummary(selectedRiderCategory, selectedBaseTransitServiceType, TransitPassAddOn.ALL_DAY_PASS);
					return;
				}
				case "2"-> {
					printTransitCartSummary(selectedRiderCategory, selectedBaseTransitServiceType,  TransitPassAddOn.MONTHLY_PASS);
					return;
				}
				case "3" -> {
					printTransitCartSummary(selectedRiderCategory, selectedBaseTransitServiceType, TransitPassAddOn.E_PURSE);
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

	public static void ferryRouteAddOn() {
		while (true){
			ConsoleFormatter.displayHeader("SELECT FERRY ROUTE ADD-ON" , width);
			System.out.println("1. WSF Mukilteo-Clinton          $58.80");
			System.out.println("2. WSF Vashon Island             $62.80");
			System.out.println("3. WSF Fauntleroy-Southworth     $74.00");
			System.out.println("4. WSF Port Townsend-Coupeville  $84.00");
			System.out.println("5. WSF Central Sound            $120.50");
			System.out.println("0. No Ferry Route Add-On");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();
		}
	}

	private static void displayEPurseTopUp() {
		while (true){
			ConsoleFormatter.displayHeader("SELECT E-PURSE TOP-UP" , width);

			System.out.println("1. $10 E-Purse Top-Up");
			System.out.println("2. $25 E-Purse Top-Up");
			System.out.println("3. $50 E-Purse Top-Up");
			System.out.println("4. $100 E-Purse Top-Up");
			System.out.println("0. Cancel");
			ConsoleFormatter.displayDivider(width);
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

	private static void displayRetailItem() {
		while (true){
			ConsoleFormatter.displayHeader("SELECT RETAIL ITEM" , width);

			System.out.println("1. Transit Card Wallet");
			System.out.println("2. RFID-Blocking Sleeve");
			System.out.println("3. Protective Card Sleeve");
			System.out.println("4. Lanyard with Safety Breakaway");
			System.out.println("0. Return to Order Screen");
			ConsoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> {
					System.out.println("Transit Card Wallet");
					return;
				}
				case "2"  -> {
					System.out.println("RFID-Blocking Sleeve");
					return;
				}
				case "3"  -> {
					System.out.println("Protective Card Sleeve");
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

	public static void printTransitCartSummary(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType, TransitPassAddOn selectedTransitPassAddOn){
		double baseTransitPrice = TransitPricingModel.getBaseTransitPrice(
				selectedBaseTransitServiceType, selectedRiderCategory);
		double addOnTransitPrice = TransitPricingModel.getAddOnTransitPrice(
				selectedTransitPassAddOn, selectedRiderCategory);
		double unitPrice = TransitPricingModel.calculateTransitCartTotal(
				selectedBaseTransitServiceType,
				selectedTransitPassAddOn,
				selectedRiderCategory);

		double totalPrice = baseTransitPrice + addOnTransitPrice;
		int quantity = 1;

		String lineItemName = (selectedBaseTransitServiceType.getDisplayName() + " - "
				+ selectedRiderCategory.getDisplayName());

		TransactionLineItem currentOrderItem = new TransactionLineItem(
				LineItemCategory.TRANSIT_PASS_ADD_ON.getDisplayName(), lineItemName,
				selectedRiderCategory.getDisplayName(),
				selectedBaseTransitServiceType.getDisplayName(),
				selectedTransitPassAddOn.getDisplayName(),
				quantity, unitPrice, totalPrice
		);

		currentOrderItems.add(currentOrderItem);
	}

	public static void displayCurrentOrder(){
		double orderTotal = 0;

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		ConsoleFormatter.displayHeader("CURRENT ORDER", width);

		String lastPrintedCategory = "";

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory  = currentOrderItem.getLineItemCategory();
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			if (!lineItemCategory.equals(lastPrintedCategory)) {
				ConsoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;
			}
			System.out.printf("%dx %-35s $%.2f%n", quantity, lineItemName, totalPrice);
			orderTotal += totalPrice;
		}

		System.out.println();
		ConsoleFormatter.displayDivider(width);
		System.out.printf("%-38s $%.2f%n", "Order Total ", orderTotal);
		System.out.print("Press Enter to return to the order menu.");
		scanner.nextLine();
	}

	public static void displayCheckOut(){
		String date = ConsoleFormatter.currentDate();
		String time = ConsoleFormatter.currentTime();
		int receiptId = 9999;
		double grandTotal = 0;
		String lastPrintedCategory = "";

		if (currentOrderItems.isEmpty()) {
			System.out.println("No item in current order.");
			return;
		}

		ConsoleFormatter.displayHeader("CHECKOUT MENU", width);
		System.out.println("Receipt ID: " + receiptId);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		ConsoleFormatter.displayDivider(width);

		for (TransactionLineItem currentOrderItem : currentOrderItems) {
			String lineItemCategory = currentOrderItem.getLineItemCategory();
			String lineItemName = currentOrderItem.getLineItemName();
			int quantity = currentOrderItem.getQuantity();
			double totalPrice = currentOrderItem.getTotalPrice();

			// Printing ITEM CATEGORIES in the receipt
			if (!lineItemCategory.equals(lastPrintedCategory)) {
				ConsoleFormatter.displayReceiptItemCategoryDivider(lineItemCategory, width);
				lastPrintedCategory = lineItemCategory;     //
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