package com.pluralsight.ui.order.transit.addon;

import java.util.ArrayList;
import java.util.Scanner;

public class TransitPassAddOnMenu  {
//	ConsoleFormatter consoleFormatter = new ConsoleFormatter();
//
//	private static final Scanner scanner = new Scanner(System.in);
//	int WIDTH = 65;
//
//	private final ArrayList<TransitCardMenu> transitServiceMenus;
//	private final ShoppingCart shoppingCart;
//	private final RiderTypeUgh selectedRiderTypeUgh;
//	private final FerryPassAddOnMenu ferryPassAddOnMenu;
//	private final ArrayList<AddOnPrice> addOns;
//	public TransitPassAddOnMenu(ShoppingCart shoppingCart, RiderTypeUgh selectedRiderTypeUgh) {
//		this.shoppingCart = shoppingCart;
//		this.transitServiceMenus = new ArrayList<>();
//		this.selectedRiderTypeUgh = selectedRiderTypeUgh;
//		this.ferryPassAddOnMenu = new FerryPassAddOnMenu(shoppingCart, selectedRiderTypeUgh);
//		this.addOns = new ArrayList<>();
//
//		addOns.add(
//			new TransitPassAddOnPrice(TransitPassAddOn.ALL_DAY_PASS, selectedRiderTypeUgh)
//		);
//		addOns.add(
//				new TransitPassAddOnPrice(TransitPassAddOn.MONTHLY_PASS, selectedRiderTypeUgh)
//		);
//		addOns.add(
//				new TransitPassAddOnPrice(TransitPassAddOn.SEVEN_DAY_PASS, selectedRiderTypeUgh)
//		);
//	}
//
//
//	public void displayAddOnMenu() {
//		while(true) {
//			consoleFormatter.displayHeader("SELECT TRANSIT PASS ADD-ON", WIDTH);
//			consoleFormatter.displayTypeIdentifier("Rider Type: " + selectedRiderTypeUgh.getDisplayName(), WIDTH);
//
//
//
//			System.out.println("Would you like to load additional transit pass onto this card?");
//			System.out.println("Additional passes receive 15% off.");
//			System.out.println();
//
//			for (int i = 0; i < addOns.size(); i++){
//				var addOn = addOns.get(i);
//				System.out.printf("%-50s $%7.2f%n", (i + 1) + ". " + addOn.getAddOnName(), addOn.getAddOnPrice());
//				System.out.printf("%-50s $%7.2f%n", "       Additional", addOn.getAddOnDiscountPrice());
//			}
//
//			System.out.println();
//			System.out.println(addOns.size() + ". Continue to Next Step");
//			System.out.println("0. Cancel and Return to Order Screen");
//
//			consoleFormatter.divider(WIDTH);
//			System.out.print("Select an option: ");
//			String userOption = scanner.nextLine();
//
//			TransitPassAddOn selectedTransitPassAddOn = null;
//
//			switch (userOption) {
//				case "1" -> {
//					selectedTransitPassAddOn = TransitPassAddOn.ALL_DAY_PASS;
//				}
//				case "2" -> {
//					selectedTransitPassAddOn = TransitPassAddOn.MONTHLY_PASS;
//				}
//				case "3" -> {
//					selectedTransitPassAddOn = TransitPassAddOn.SEVEN_DAY_PASS;
//				}
//				case "4" -> {
//					ferryPassAddOnMenu.displayFerryPassAddOnMenu();
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Order Screen.");
//					return;
//				}
//				default -> {
//					System.out.println("Invalid option.");
//					continue;
//				}
//			}
//
//			int quantity;
//			try {
//				System.out.print("Please enter the quantity to purchase: ");
//				quantity = Integer.parseInt(scanner.nextLine());
//			} catch (NumberFormatException e) {
//				System.out.println("Invalid quantity. Please enter a number.");
//				continue;
//			}
//
//			double unitPrice = PricingCalculator.getAddOnTransitPrice(selectedTransitPassAddOn, selectedRiderTypeUgh);
//
//			TransitPassAddOnItem transitPassAddOnItem = new TransitPassAddOnItem(selectedTransitPassAddOn, selectedRiderTypeUgh,
//					quantity, unitPrice);
//			shoppingCart.addItem(transitPassAddOnItem);
//
//			System.out.println();
//			System.out.println("Added:");
//			System.out.printf("- %-30s $ %6.2f%n", selectedTransitPassAddOn.getDisplayName(), unitPrice);
//			System.out.printf("    Additional: $ %.2f x %d%n", transitPassAddOnItem.getDiscountUnitPrice(), transitPassAddOnItem.getAddOnQuantity());
//			System.out.println();
//
//			System.out.println("Press ENTER to continue.");
//
//			scanner.nextLine();
//
//			displayAddOnMenu();
//			return;
//		}
//
//
//
//
//
//
//
//
//
//
//
//	}

}
