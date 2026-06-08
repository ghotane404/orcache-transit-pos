package com.pluralsight.ui.order.transit.addon.feature;


import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.model.cart.ShoppingCart;

import java.util.Scanner;

public class LimeVoucherMenu implements MenuScreen {
	private final ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	private ShoppingCart shoppingCart;

	@Override
	public String showMenuName() {
		return "";
	}

	@Override
	public void displayMenu() {

	}

//	public LimeVoucherMenu(ShoppingCart shoppingCart) {
//		this.shoppingCart = shoppingCart;
//	}
//
//
//	public void displayLimeVoucherMenu() {
//		int maxAmount = 0;
//
//		while (true) {
//			if (maxAmount >= 3) {
//				System.out.println("Maximum of 3 voucher reached. Press ENTER to continue.");
//				scanner.nextLine();
//
//				return;
//			}
//
//			consoleFormatter.displayHeader("SELECT LIME DISCOUNT VOUCHERS", WIDTH);
//
//			System.out.println("Choose up to 3 Lime discount vouchers for this card.");
//			System.out.println();
//			System.out.println("Each transit card may include up to 3 Lime discount vouchers.");
//			System.out.println();
//
//			System.out.println("1. Lime First 30-Minute Ride Free         Included");
//			System.out.println("2. Weekend 25 % Ride off Promo            Included");
//			System.out.println("3. Morning 50 % Commuter Discount         Included");
//			System.out.println("4. Continue to Next Step");
//			System.out.println();
//
//			System.out.println("0. Cancel and Return to Order Screen");
//
//			consoleFormatter.divider(WIDTH);
//
//			System.out.print("Please select an option: ");
//			String userOption = scanner.nextLine();
//
//			LimeDiscountVoucher selectLimeDiscountVoucher = null;     // calling the enum
//
//			switch (userOption) {
//				case "1" -> {selectLimeDiscountVoucher = LimeDiscountVoucher.FIRST_30_MINUTE_RIDE_FREE;}
//				case "2" -> {selectLimeDiscountVoucher = LimeDiscountVoucher.WEEKEND_25_PERCENT_OFF;}
//				case "3" -> {selectLimeDiscountVoucher = LimeDiscountVoucher.MORNING_50_PERCENT_COMMUTER_DISCOUNT;}
//				case "4" -> {
////					CardStyleMenu cardStyleMenu = new CardStyleMenu();
////					cardStyleMenu.displayCardStyleMenu(currentOrderItems);
//					return;
//				}
//
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
//			System.out.print("Please enter number of card to activate, between 1 and 3: ");
//			int quantity = Integer.parseInt(scanner.nextLine());
//
//			if  (quantity < 1 || maxAmount + quantity > 3) {
//				System.out.println("Invalid quantity. You may select between 1 and 3 Lime discount vouchers.");
//				continue;
//			}
//
//
//			LimeVoucherItem limeVoucherItem = new LimeVoucherItem(selectLimeDiscountVoucher, quantity);
//			shoppingCart.addItem(limeVoucherItem);
//			maxAmount += quantity;
//
//			System.out.println();
//			System.out.println("Added:");
//			System.out.printf("- %-50s %s%n", selectLimeDiscountVoucher.getDisplayName(), "Included");
//			System.out.printf("      x %d%n", 1 + limeVoucherItem.getAddOnQuantity());
//			System.out.println();
//
//			System.out.println("Press ENTER to continue.");
//			scanner.nextLine();
//
////			CardStyleMenu cardStyleMenu = new CardStyleMenu();
////			cardStyleMenu.displayCardStyleMenu(currentOrderItems);
//
////			return;
//		}
//	}

}

