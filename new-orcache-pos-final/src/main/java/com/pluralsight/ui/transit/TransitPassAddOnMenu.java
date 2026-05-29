package com.pluralsight.ui.transit;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.model.transit.TransitPassAddOnItem;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.model.option.TransitPassAddOn;
import com.pluralsight.service.TransitPricingModel;
import com.pluralsight.ui.format.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class TransitPassAddOnMenu {
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;

	public void displayTransitPassAddOnMenu(RiderType selectedRiderType,  ArrayList<TransactionLineItem> currentOrderItems) {
		while(true) {
			consoleFormatter.displayHeader("SELECT TRANSIT PASS ADD-ON", WIDTH);
			consoleFormatter.displayTypeIdentifier("Rider Type: " + selectedRiderType.getDisplayName(), WIDTH);

			System.out.println("Would you like to load additional transit pass onto this card?");
			System.out.println("Additional passes receive 15% off.");
			System.out.println();

			double allDayPassPrice = TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.ALL_DAY_PASS, selectedRiderType);
			double allDayPassDiscountPrice = allDayPassPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);

			System.out.printf("%-50s $%7.2f%n", "1. All Day Pass", allDayPassPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional", allDayPassDiscountPrice);

			double monthlyPassPrice = TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.MONTHLY_PASS, selectedRiderType);
			double monthlyPassDiscountPrice = monthlyPassPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);

			System.out.printf("%-50s $%7.2f%n", "2. Monthly Pass", monthlyPassPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional", monthlyPassDiscountPrice);

			double sevenDayPassPrice = TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.SEVEN_DAY_PASS, selectedRiderType);
			double sevenDayPassDiscountPrice = sevenDayPassPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "3. SevenDay Pass", sevenDayPassPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional", sevenDayPassDiscountPrice);

			System.out.println();
			System.out.println("4. Continue to Next Step");
			System.out.println("0. Cancel and Return to Order Screen");

			consoleFormatter.divider(WIDTH);
			System.out.print("Select an option: ");
			String userOption = scanner.nextLine();

			TransitPassAddOn selectedTransitPassAddOn = null;

			switch (userOption) {
				case "1" -> {
					selectedTransitPassAddOn = TransitPassAddOn.ALL_DAY_PASS;
				}
				case "2" -> {
					selectedTransitPassAddOn = TransitPassAddOn.MONTHLY_PASS;
				}
				case "3" -> {
					selectedTransitPassAddOn = TransitPassAddOn.SEVEN_DAY_PASS;
				}
				case "4" -> {
					FerryPassAddOnMenu ferryPassAddOnMenu = new FerryPassAddOnMenu();
					ferryPassAddOnMenu.displayFerryPassAddOnMenu(selectedRiderType, currentOrderItems);
					return;
				}
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}

			int quantity;
			try {
				System.out.print("Please enter the quantity to purchase: ");
				quantity = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid quantity. Please enter a number.");
				continue;
			}

			double unitPrice = TransitPricingModel.getAddOnTransitPrice(selectedTransitPassAddOn, selectedRiderType);

			TransitPassAddOnItem transitPassAddOnItem = new TransitPassAddOnItem(selectedTransitPassAddOn, selectedRiderType,
					quantity, unitPrice);
			currentOrderItems.add(transitPassAddOnItem);

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-30s $ %6.2f%n", selectedTransitPassAddOn.getDisplayName(), unitPrice);
			System.out.printf("    Additional: $ %.2f x %d%n", transitPassAddOnItem.getDiscountUnitPrice(), transitPassAddOnItem.getAddOnQuantity());
			System.out.println();

			System.out.println("Press ENTER to continue.");

			scanner.nextLine();

			FerryPassAddOnMenu ferryPassAddOnMenu = new FerryPassAddOnMenu();
			ferryPassAddOnMenu.displayFerryPassAddOnMenu(selectedRiderType, currentOrderItems);

			return;
		}











	}

}
