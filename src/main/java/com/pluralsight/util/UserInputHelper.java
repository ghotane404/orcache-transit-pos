package com.pluralsight.util;

import com.pluralsight.ui.interfaces.MenuScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputHelper {
	private static final Scanner scanner = new Scanner(System.in);

//	public static int getIntegerInput(int userInput) {
//		while (true) {
//			try{
//				// converting userInoput to int and subtracting 1 (since arrays start at index 0)
//				int i = Integer.parseInt(userInput) - 1;
//				if (i >= 0 && i < menuOptions.size()){        // validates that the number is within the array's range
//					MenuScreen menuOptionSelected = menuOptions.get(i);       // assigns the selected menu[i] object in the menuSelected variable
//					// passes currentOrderItems into the selected menu so that menu can use whats stored in the order list.
//					menuOptionSelected.displayMenu();
//				}
//				else {
//					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
//					System.out.println("\nPress ENTER to continue.");
//					scanner.nextLine();
//				}
//			}
//			catch (NumberFormatException e){
//				System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
//				System.out.println("Press ENTER to continue.");
//				scanner.nextLine();
//			}
//		}
//	}

}
