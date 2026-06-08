package com.pluralsight.ui.order.transit.addon.feature;

import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.ConsoleFormatter;

import java.util.Scanner;

public class CardStyleMenu implements MenuScreen {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	@Override
	public String showMenuName() {
		return "";
	}

	@Override
	public void displayMenu() {

	}

//
//	private final ShoppingCart shoppingCart;
//
//	public CardStyleMenu(ShoppingCart shoppingCart) {
//		this.shoppingCart = shoppingCart;
//	}
//
//	public void displayCardStyleMenu() {
//		int maxAmount = 0;
//
//		while (true) {
//			if (maxAmount >= 3) {
//				System.out.println("Maximum of 3 card styles reached. Press ENTER to continue.");
//				scanner.nextLine();
//				LimeVoucherMenu limeVoucherMenu = new LimeVoucherMenu(shoppingCart);
//				limeVoucherMenu.displayLimeVoucherMenu();
//				return;
//			}
//
//			consoleFormatter.displayHeader("SELECT CARD STYLE", WIDTH);
//			System.out.println("Customize your transit cards with exclusive card designs.");
//			System.out.println();
//			System.out.println("Or, build your collector's transit card set!");
//			System.out.println();
//			System.out.println("Cards Remaining: 3");
//			System.out.println();
//			System.out.println("1. Orca Wave                              Included");
//			System.out.println("2. Seattle Skyline                        Included");
//			System.out.println("3. Ferry Crossing                         Included");
//			System.out.println("4. Coffee Line                            Included");
//			System.out.println("5. Continue to Next Step");
//			System.out.println();
//			System.out.println("0. Cancel and Return to Order Screen");
//
//			consoleFormatter.divider(WIDTH);
//			System.out.print("Please select an option: ");
//			String userOption = scanner.nextLine();
//
//			CardDesignOption selectedCardDesignOption = null;
//
//			switch (userOption) {
//				case "1" -> { selectedCardDesignOption = CardDesignOption.ORCA_WAVE; }
//				case "2" -> { selectedCardDesignOption = CardDesignOption.SEATTLE_SKYLINE; }
//				case "3" -> { selectedCardDesignOption = CardDesignOption.FERRY_CROSSING; }
//				case "4" -> { selectedCardDesignOption = CardDesignOption.COFFEE_LINE; }
//				case "5" -> { LimeVoucherMenu limeVoucherMenu = new LimeVoucherMenu(shoppingCart);
//					limeVoucherMenu.displayLimeVoucherMenu();
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Order Screen.");
//					return;
//				}
//				default -> { System.out.println("Invalid option."); }
//			}
//
//			System.out.print("Please enter number of card design, between 1 and 3: ");
//
//			int quantity = Integer.parseInt(scanner.nextLine());
//			if  (quantity < 1 || maxAmount + quantity > 3) {
//				System.out.println("Invalid quantity. You may select between 1 and 3.");
//				continue;
//			}
//
//			CardDesignItem cardDesignItem = new CardDesignItem(selectedCardDesignOption, quantity);
//			shoppingCart.addItem(cardDesignItem);
//			maxAmount += quantity;
//
//			System.out.println();
//			System.out.println("Added:");
//			System.out.printf("- %-50s %s%n", selectedCardDesignOption.getDisplayName(), "Included");
//			System.out.printf("      x %d%n", 1 + cardDesignItem.getAddOnQuantity());
//			System.out.println();
//
//			System.out.println("Press ENTER to continue.");
//			scanner.nextLine();

//			LimeVoucherMenu limeVoucherMenu = new LimeVoucherMenu();
//			limeVoucherMenu.displayLimeVoucherMenu(currentOrderItems);
//
//			return;


//		}
//	}
}