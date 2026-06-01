package com.pluralsight.ui.order.epurse;

import com.pluralsight.model.item.EPurseItem;
import com.pluralsight.model.enums.EPurseReloadOption;
import com.pluralsight.ui.order.interfaces.Menu;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ShoppingCart;
import com.pluralsight.util.TransitPricingModel;
import com.pluralsight.util.ConsoleFormatter;

import java.util.*;

public class EPurseMenu implements Menu {
	private final ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;

	@Override
	public String showMenuName() {
		return "Add E-Purse Balance";
	}

	private ShoppingCart shoppingCart;

	public EPurseMenu(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public void display() {
		while (true) {
			consoleFormatter.displayHeader("ADD E-PURSE BALANCE", WIDTH);
			System.out.println("1. Add $5.00");
			System.out.println("2. Add $10.00");
			System.out.println("3. Add $15.00");
			System.out.println("4. Add $20.00");
			System.out.println();
			System.out.println("0. Cancel and Return to Order Screen");

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();
			System.out.println();

			EPurseReloadOption selectedEPpurseOption = null;

			switch (userOption) {
				case "1" -> selectedEPpurseOption = EPurseReloadOption.ADD_FIVE;
				case "2" -> selectedEPpurseOption = EPurseReloadOption.ADD_TEN;
				case "3" -> selectedEPpurseOption = EPurseReloadOption.ADD_FIFTEEN;
				case "4" -> selectedEPpurseOption = EPurseReloadOption.ADD_TWENTY;
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
					System.out.println("Press ENTER to continue.");
					scanner.nextLine();
					continue;
				}
			}

			double unitPrice = TransitPricingModel.getEpurseBalance(selectedEPpurseOption);
			EPurseItem ePurseItem = new EPurseItem(selectedEPpurseOption, unitPrice);

			shoppingCart.addItem(ePurseItem);

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-30s $ %6.2f%n", selectedEPpurseOption.getDisplayName(), unitPrice);
			System.out.println();

			System.out.println("Press ENTER to continue.");
			scanner.nextLine();
			return;

		}
	}
}
