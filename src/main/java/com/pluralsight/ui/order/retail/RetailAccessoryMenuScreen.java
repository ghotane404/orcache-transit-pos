package com.pluralsight.ui.order.retail;

import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.model.item.RetailAccessoryCartItem;
import com.pluralsight.model.cart.ShoppingCart;
import com.pluralsight.util.ConsoleFormatter;

import java.util.Scanner;

public class RetailAccessoryMenuScreen implements MenuScreen {

	private ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;

	public RetailAccessoryMenuScreen(ShoppingCart shoppingCart) {
	}

	@Override
	public String showMenuName() {
		return "Add Retail Accessory";
	}

	@Override
	public void displayMenu() {

	}


//	public RetailAccessoryMenuScreen(ShoppingCart shoppingCart) {
//		this.shoppingCart = shoppingCart;
//
//		retailAccessoryCartItemOptions = new ArrayList<>();
//		retailAccessoryCartItemOptions.add(new RetailAccessoryCartItem(
//				"Card Wallet Holder",
//				4.00, 5.00, 6.00));
//		retailAccessoryCartItemOptions.add(new RetailAccessoryCartItem(
//				"Protective Card Sleeve",
//				4.00, 5.00, 6.00));
//		retailAccessoryCartItemOptions.add(new RetailAccessoryCartItem(
//				"Lanyard with Breakaway",
//				8.00, 10.00, 12.00));
//		retailAccessoryCartItemOptions.add(new RetailAccessoryCartItem(
//				"RFID Blocking Card Holder",
//				8.00, 10.00, 12.00));
//
//	}



//
//	@Override
//	public void displayMenu() {
//		while (true) {
//			consoleFormatter.displayHeader("SELECT RETAIL ACCESSORY", WIDTH);
//			System.out.println("Select an accessory to continue, then choose a tier.");
//			System.out.println();
//			System.out.println("1. Card Wallet Holder");
//			System.out.println("2. Protective Card Sleeve");
//			System.out.println("3. Lanyard with Breakaway");
//			System.out.println("4. RFID-Blocking Card Holder");
//			System.out.println();
//			System.out.println("0. Cancel and Return to Order Screen");
//			consoleFormatter.divider(WIDTH);
//
//			System.out.print("Please select an option: ");
//			String userOption = scanner.nextLine();
//
//			RetailAccessory selectedAccessory = null;
//
//			switch (userOption) {
//				case "1" -> selectedAccessory = RetailAccessory.CARD_WALLET_HOLDER;
//				case "2" -> selectedAccessory = RetailAccessory.PROTECTIVE_CARD_SLEEVE;
//				case "3" -> selectedAccessory = RetailAccessory.LANYARD_WITH_BREAKAWAY;
//				case "4" -> selectedAccessory = RetailAccessory.RFID_BLOCKING_CARD_HOLDER;
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
//			retailTierPrice(selectedAccessory);
//
//		}
//	}
//
//	public void retailTierPrice(RetailAccessory selectedAccessory)  {
//
//		while (true) {
//			consoleFormatter.displayHeader("SELECT RETAIL TIER", WIDTH);
//			System.out.println("Choose a tier level.");
//			System.out.println();
//			System.out.println("1. Basic");
//			System.out.println("2. Standard");
//			System.out.println("3. Premium");
//			System.out.println();
//			System.out.println("0. Cancel and Return to Order Screen");
//
//			consoleFormatter.divider(WIDTH);
//
//			System.out.print("Please select an option: ");
//			String userOption = scanner.nextLine();
//
//			RetailTier selectedTier = null;
//
//			switch (userOption) {
//				case "1" -> selectedTier = RetailTier.BASIC;
//				case "2" -> selectedTier = RetailTier.STANDARD;
//				case "3" -> selectedTier = RetailTier.PREMIUM;
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
//			double unitPrice = PricingCalculator.getRetailAccessoryPrice(selectedAccessory, selectedTier);
//			RetailAccessoryCartItem retailAccessoryCartItem = new RetailAccessoryCartItem(selectedAccessory, 1, unitPrice);
//
////			shoppingCart.addItem(retailAccessoryCartItem);
//
//			System.out.println();
//			System.out.println("Added:");
//			System.out.printf("- %-30s $ %6.2f%n", selectedAccessory.getDisplayName(), unitPrice);
//			System.out.println();
//
//			System.out.println("Press ENTER to continue.");
//			scanner.nextLine();
//
//			return;
//		}
//	}

}
