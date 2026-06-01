package com.pluralsight.ui.order;

import com.pluralsight.ui.order.interfaces.Menu;
import com.pluralsight.ui.order.bonusbundle.BundlePassMenu;
import com.pluralsight.ui.order.checkout.CheckoutMenu;
import com.pluralsight.ui.order.epurse.EPurseMenu;
import com.pluralsight.ui.order.retail.RetailAccessoryMenu;
import com.pluralsight.ui.order.transit.pass.TransitServiceMenu;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.util.ShoppingCart;

import java.util.*;

public class OrderMenu {
	private final ConsoleFormatter consoleFormatter = new ConsoleFormatter();

	private static final Scanner scanner = new Scanner(System.in);
	private static final int WIDTH = 65;
	private final ArrayList<Menu> menus;

	// creating a constructor that runs whenever a new OrderMenu object is created
	public OrderMenu() {
		var shoppingCart = new ShoppingCart();      // allows the ShoppingCart to be shared by all order menu screens.
		menus = new ArrayList<>();      // an arrylist that will hold each of the menu option
		menus.add(new TransitServiceMenu(shoppingCart));    // creates a transit service menu and allows the same shopping cart to be used by other menus.
		menus.add(new BundlePassMenu(shoppingCart));
		menus.add(new RetailAccessoryMenu(shoppingCart));
		menus.add(new EPurseMenu(shoppingCart));
		menus.add(new CheckoutMenu(shoppingCart));
	}

	public void displayOrderMenu() {
		while (true){       // to displays the order menu that keeping running until the user cancels
			consoleFormatter.displayHeader("ORDER MENU", WIDTH);

			for (int i = 0; i < menus.size(); i++){     // loops through every menu option in the menus array.
				System.out.println((i+1) + ". " + menus.get(i).showMenuName());     // printing the optiion number when displaying the menu
			}
			
			System.out.println();
			System.out.println("0. Cancel Order");
			consoleFormatter.divider(WIDTH);
			System.out.print("Please select an option: ");
			String userInput = scanner.nextLine();
			System.out.println();
			
			if (userInput.equals("0")){
				System.out.println("Returning to Home Menu.");
				return;     // exiting displayOrderMenu method
			}
			
			try{
				// converting userInoput to int and subtracting 1 (since arrays start at index 0)
				int i = Integer.parseInt(userInput) - 1;
				if (i >= 0 && i < menus.size()){        // validates that the number is within the array's range
					Menu menuSelected = menus.get(i);       // assigns the selected menu[i] object in the menuSelected variable
					// passes currentOrderItems into the selected menu so that menu can use whats stored in the order list.
					menuSelected.display();
				}
				else {
					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
					System.out.println("\nPress ENTER to continue.");
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