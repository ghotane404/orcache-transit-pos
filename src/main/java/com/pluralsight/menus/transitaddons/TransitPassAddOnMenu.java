package com.pluralsight.menus.transitaddons;

import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.option.TransitPassAddOn;
import com.pluralsight.model.transaction.TransactionLineItem;
import com.pluralsight.service.TransitPricingModel;
import com.pluralsight.ui.ConsoleFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransitPassAddOnMenu {
	ArrayList<TransactionLineItem> currentOrderItems;
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	Scanner scanner = new Scanner(System.in);
	int width = 50;

	public TransitPassAddOnMenu(ArrayList<TransactionLineItem> currentOrderItems) {
		this.currentOrderItems = currentOrderItems;
	}

	public void displayTransitPassAddOnMenu(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType) {
		while(true){
			consoleFormatter.displayHeader("SELECT TRANSIT PASS ADD-ON" , width);
			System.out.printf("%-43s $%7.2f%n", "1. All Day Pass",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.ALL_DAY_PASS, selectedRiderCategory));
			System.out.printf("%-43s $%7.2f%n", "2. Monthly Pass",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.MONTHLY_PASS, selectedRiderCategory));
			System.out.printf("%-43s $%7.2f%n", "3. Starter $100 E-Purse Value",
					TransitPricingModel.getAddOnTransitPrice(TransitPassAddOn.E_PURSE, selectedRiderCategory));
			System.out.printf("%-43s $%7.2f%n", "4. No Add-On", 0.00);
			System.out.println("0. Return to Base Transit Service");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();
			System.out.println();

			switch (userInput) {
				case "1" -> {
					addTransitPassProductToOrder(selectedRiderCategory, selectedBaseTransitServiceType, TransitPassAddOn.ALL_DAY_PASS);
					System.out.println((TransitPassAddOn.ALL_DAY_PASS).getDisplayName() + " added to current order.");
					return;
				}
				case "2"-> {
					addTransitPassProductToOrder(selectedRiderCategory, selectedBaseTransitServiceType,  TransitPassAddOn.MONTHLY_PASS);
					System.out.println((TransitPassAddOn.MONTHLY_PASS).getDisplayName() + " added to current order.");
					return;
				}
				case "3" -> {
					addTransitPassProductToOrder(selectedRiderCategory, selectedBaseTransitServiceType, TransitPassAddOn.E_PURSE);
					System.out.println((TransitPassAddOn.E_PURSE).getDisplayName() + " added to current order.");
					return;
				}
				case "4" -> {
					addTransitPassProductToOrder(selectedRiderCategory, selectedBaseTransitServiceType, TransitPassAddOn.NO_ADD_ON);
					System.out.println("Base transit pass added to current order.");
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

	public void addTransitPassProductToOrder(RiderCategory selectedRiderCategory, BaseTransitServiceType selectedBaseTransitServiceType, TransitPassAddOn selectedTransitPassAddOn){
		double baseTransitPrice = TransitPricingModel.getBaseTransitPrice(
				selectedBaseTransitServiceType, selectedRiderCategory);
		double addOnTransitPrice = TransitPricingModel.getAddOnTransitPrice(
				selectedTransitPassAddOn, selectedRiderCategory);
		double unitPrice = TransitPricingModel.calculateTransitCartTotal(
				selectedBaseTransitServiceType,
				selectedTransitPassAddOn,
				selectedRiderCategory);
		int quantity = 1;
		double totalPrice = baseTransitPrice * quantity;


		String lineItemName = selectedBaseTransitServiceType.getDisplayName()
				+ " - " + selectedRiderCategory.getDisplayName()
				+ " - " + selectedTransitPassAddOn.getDisplayName();

		TransactionLineItem currentOrderItem = new TransactionLineItem(
				LineItemCategory.TRANSIT_PASS_ADD_ON.getDisplayName(), lineItemName,
				selectedRiderCategory.getDisplayName(),
				selectedBaseTransitServiceType.getDisplayName(),
				selectedTransitPassAddOn.getDisplayName(),
				quantity, unitPrice, totalPrice);

		currentOrderItems.add(currentOrderItem);

		System.out.println();
		System.out.println(lineItemName + " added to current order.");
	}

}
