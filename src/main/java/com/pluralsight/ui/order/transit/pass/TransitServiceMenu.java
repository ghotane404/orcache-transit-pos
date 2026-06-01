package com.pluralsight.ui.order.transit.pass;

import com.pluralsight.model.enums.TransitServiceType;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.order.interfaces.Menu;
import com.pluralsight.util.ShoppingCart;

import java.util.*;

public class TransitServiceMenu implements Menu {
	private final ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 50;

	private final ArrayList<RiderTypeMenu> riderTypeMenus;
	private final ShoppingCart shoppingCart;

	public TransitServiceMenu(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
		this.riderTypeMenus = new ArrayList<>();

		riderTypeMenus.add(new RiderTypeMenu(shoppingCart, TransitServiceType.METRO_BUS));
		riderTypeMenus.add(new RiderTypeMenu(shoppingCart, TransitServiceType.LINK_LIGHT_RAIL));
		riderTypeMenus.add(new RiderTypeMenu(shoppingCart, TransitServiceType.RAPID_RIDE));
		riderTypeMenus.add(new RiderTypeMenu(shoppingCart, TransitServiceType.SOUND_TRANSIT_EXPRESS_BUS));
	}

	@Override
	public String showMenuName() {
		return "Add Transit Pass";
	}

	@Override
	public void display() {
		while (true) {
			consoleFormatter.displayHeader("SELECT TRANSIT SERVICE", WIDTH);

			for (int i = 0; i < riderTypeMenus.size(); i++){     // loops through every menu option in the menus array.
				System.out.println((i+1) + ". " + riderTypeMenus.get(i).displayTransitTypeText());     // printing the optiion number when displaying the menu
			}

			System.out.println();
			System.out.println("0. Return to Order Menu");
			consoleFormatter.divider(WIDTH);
			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();
			System.out.println();

			if (userOption.equals("0")) {
				System.out.println("Returning to Order Menu");
				return;
			}

			try{
				int index = Integer.parseInt(userOption);
				if (index >= 0 && index < riderTypeMenus.size()) {
					RiderTypeMenu riderTypeMenu = riderTypeMenus.get(index);
					riderTypeMenu.displayRiderTypeMenu();
				}
				else{
					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
					System.out.println("Press ENTER to continue.");
					scanner.nextLine();
				}
			}
			catch (NumberFormatException e){
				System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
				System.out.println("Press ENTER to continue.");
				scanner.nextLine();
			}
		}
	}
}
