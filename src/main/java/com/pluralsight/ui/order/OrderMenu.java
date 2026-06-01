package com.pluralsight.ui.order;

import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.ui.order.interfaces.Menu;
import com.pluralsight.ui.order.bonusbundle.BundlePassMenu;
import com.pluralsight.ui.order.checkout.CheckoutMenu;
import com.pluralsight.ui.order.epurse.EPurseMenu;
import com.pluralsight.ui.order.retail.RetailAccessoryMenu;
import com.pluralsight.ui.order.transit.pass.TransitServiceMenu;
import com.pluralsight.util.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderMenu {
	private ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();   // creating new list that's shared by the class.
	private ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	private static final int WIDTH = 65;

	private final Menu[] menus = {      // creates a list of menu objects that all use the Menu interface
			new TransitServiceMenu(),       // creates a TransitServiceMenu object and stores it inside the menus array
			new BundlePassMenu(),       // same for BundlePassMenu, RetailAccessoryMenu, EPurseMenu, CheckoutMenu
			new RetailAccessoryMenu(),
			new EPurseMenu(),
			new CheckoutMenu()};

	public void displayOrderMenu() {
		while (true){       // to displays the order menu that keeping running until the user cancels
			consoleFormatter.displayHeader("ORDER MENU", WIDTH);

			for (int i = 0; i < menus.length; i++){     // loops through every menu option in the menus array.
				System.out.println((i+1) + ". " + menus[i].showMenuName());     // printing the optiion number when displaying the menu
			}
			
			System.out.println();
			System.out.println("0. Cancel Order");

			consoleFormatter.divider(WIDTH);

			System.out.print("Please select an option: ");
			String userInput = scanner.nextLine();
			
			if (userInput.equals("0")){
				System.out.println("Returning to Home Menu.");
				return;     // exiting displayOrderMenu method
			}
			
			try{
				// converting userInoput to int and subtracting 1 (since arrays start at index 0)
				int i = Integer.parseInt(userInput) - 1;
				if (i >= 0 && i < menus.length){        // validates that the number is within the array's range
					Menu menuSelected = menus[i];       // assigns the selected menu[i] object in the menuSelected variable
					// passes currentOrderItems into the selected menu so that menu can use whats stored in the order list.
					menuSelected.display(currentOrderItems);
				}
				else {
					System.out.println("Please select a valid option.");
				}
			}
			catch (NumberFormatException e){
				System.out.println("Please enter a valid option.");
			}
		}
	}
}