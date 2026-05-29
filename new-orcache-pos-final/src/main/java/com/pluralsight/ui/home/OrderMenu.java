package com.pluralsight.ui.home;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.ui.bonusbundle.BundlePassMenu;
import com.pluralsight.ui.checkout.CheckoutMenu;
import com.pluralsight.ui.epurse.EPurseMenu;
import com.pluralsight.ui.format.ConsoleFormatter;
import com.pluralsight.ui.retail.RetailAccessoryMenu;
import com.pluralsight.ui.transit.TransitServiceMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderMenu {
	private ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();   // creating new list that's shared by the class.
	private BundlePassMenu bundlePassMenu = new BundlePassMenu();
	private CheckoutMenu checkoutMenu = new CheckoutMenu();
	private ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private EPurseMenu ePurseMenu = new EPurseMenu();
	private RetailAccessoryMenu retailAccessoryMenu = new RetailAccessoryMenu();
	private TransitServiceMenu transitServiceMenu = new TransitServiceMenu();

	private static final Scanner scanner = new Scanner(System.in);
	private static final int WIDTH = 65;

	public OrderMenu(){}

	public void displayOrderMenu() {
		while (true){
			consoleFormatter.displayHeader("ORDER MENU", WIDTH);

			System.out.println("1. Add Transit Pass");
			System.out.println("2. Add Bundle Pass");
			System.out.println("3. Add Retail Item");
			System.out.println("4. Add E-Purse Balance");
			System.out.println("5. Checkout");
			System.out.println();
			System.out.println("0. Cancel Order");

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> transitServiceMenu.displayBaseTransitServiceType(currentOrderItems);
				case "2"  -> bundlePassMenu.displayBundleMenu(currentOrderItems);
				case "3"  -> retailAccessoryMenu.displayRetailAccessoryMenu(currentOrderItems);
				case "4" -> ePurseMenu.displayEPurseMenu(currentOrderItems);
//				case "5"  -> checkoutMenu.createReceiptText(currentOrderItems);
				case "5" -> {
					CheckoutMenu checkoutMenu = new CheckoutMenu();
					checkoutMenu.displayCheckoutMenu(currentOrderItems);
				}
				case "0" -> {
					System.out.println("Returning to Home Menu.");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}

}
