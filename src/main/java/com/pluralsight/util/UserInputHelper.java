package com.pluralsight.util;

import com.pluralsight.ui.interfaces.MenuScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputHelper {
	private static final Scanner scanner = new Scanner(System.in);

	public static int getIntegerInput(int min, int max) {
		while (true) {
			try{
				String userInput = scanner.nextLine().trim().toLowerCase();

				if (Navigator.getCurrentScreen() > 2 && userInput.equals("x")) return -1;

				int userInputInt = Integer.parseInt(userInput);

				if (userInputInt >= min && userInputInt <= max) return userInputInt;

				System.out.println();
				System.out.println(Ansi.color("Error: Please selection the option from " + min + " to " + max + ".", Ansi.BRIGHT_RED));
				System.out.print(Ansi.color("Please select an option: ",Ansi.BRIGHT_YELLOW));
			}

			catch (NumberFormatException e){
				System.out.println(Ansi.color("Error: Please enter a valid number.", Ansi.RED));
				System.out.print(Ansi.color("Please select an option: ",Ansi.BRIGHT_YELLOW));
			}
		}
	}

}
