package com.pluralsight.ui.order.transit;


import com.pluralsight.util.ConsoleFormatter;

import java.util.Scanner;

public class RiderTypeMenu {
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

//	private final ShoppingCart shoppingCart;
//	private final TransitServiceType transitServiceType;
//
//	public RiderTypeMenu(ShoppingCart shoppingCart, TransitServiceType transitServiceType) {
//		this.shoppingCart = shoppingCart;
//		this.transitServiceType = transitServiceType;
//
//
//	}
//
//	public void displayRiderTypeMenu() {
//		while (true) {
//			consoleFormatter.displayHeader("SELECT RIDER TYPE", WIDTH);
//
//			System.out.printf("%-40s $%7.2f%n", "1. Adult", PricingCalculator.getTransitPassPrice(RiderTypeUgh.ADULT));
//			System.out.printf("%-40s $%7.2f%n", "2. Senior", PricingCalculator.getTransitPassPrice(RiderTypeUgh.SENIOR));
//			System.out.printf("%-40s $%7.2f%n", "3. Youth", PricingCalculator.getTransitPassPrice(RiderTypeUgh.YOUTH));
//
//			System.out.println();
//			System.out.println("0. Cancel and Return to Order Screen");
//			consoleFormatter.divider(WIDTH);
//
//			System.out.print("Please select an option: ");
//			String userOption = scanner.nextLine();
//
//			RiderTypeUgh selectedRiderTypeUgh = null;
//
//			switch (userOption) {
//				case "1" -> {
//					selectedRiderTypeUgh = RiderTypeUgh.ADULT;}
//				case "2" -> {
//					selectedRiderTypeUgh = RiderTypeUgh.SENIOR;}
//				case "3" -> {
//					selectedRiderTypeUgh = RiderTypeUgh.YOUTH;}
//				case "0" -> {
//					System.out.println("Returning to Order Menu.");
//					return;
//				}
//				default -> {
//					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
//					System.out.println("Press ENTER to continue.");
//					scanner.nextLine();
//					continue;
//				}
//			}
//
//			int quantity;
//
//			try {
//				System.out.print("Please enter the quantity to purchase: ");
//				quantity = Integer.parseInt(scanner.nextLine());
//			} catch (NumberFormatException e) {
//				System.out.println(Ansi.color("Invalid quantity. Please enter a number.", Ansi.RED));
//
//				System.out.println("Press ENTER to continue.");
//				scanner.nextLine();
//				continue;
//			}
//
//			double unitPrice = PricingCalculator.getTransitPassPrice(selectedRiderTypeUgh);
//
////			TransitCardCartItem transitCardCartItem = new TransitCardCartItem(transitServiceType, selectedRiderType,
////					quantity, unitPrice);
////			shoppingCart.addItem(transitCardCartItem);
//
//			System.out.println();
//			System.out.println("Added:");
//			System.out.printf("- %-30s $ %6.2f%n", selectedRiderTypeUgh.getDisplayName(),unitPrice);
//			System.out.printf("    Additional: $ %.2f x %d%n", unitPrice, quantity);
//			System.out.println();
//
//			System.out.println("Press ENTER to continue.");
//			scanner.nextLine();
//
//			AddOnMenu transitPassAddOnMenu = new TransitPassAddOnMenu(shoppingCart, selectedRiderTypeUgh);
//			transitPassAddOnMenu.displayAddOnMenu();
//			return;
//		}
//
//	}
//
//	public String displayTransitTypeText(){
//		String[] words = transitServiceType.name().toLowerCase().split("_");
//		StringBuilder formattedName = new StringBuilder();
//		for (String word : words) {
//			formattedName.append(word.substring(0, 1).toUpperCase());
//			formattedName.append(word.substring(1));
//			formattedName.append(" ");
//		}
//		return formattedName.toString().trim();
//	}


}
