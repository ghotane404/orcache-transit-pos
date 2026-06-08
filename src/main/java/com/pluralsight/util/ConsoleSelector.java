package com.pluralsight.util;

import com.pluralsight.ui.interfaces.MenuScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleSelector {
	Scanner scanner = new Scanner(System.in);
	private final ArrayList<String> menuOptions;
	private final int width;

	private ConsoleSelector(ArrayList<String> menuOptions, int width) {
		this.menuOptions = menuOptions;
		this.width = width;
	}

	public int showSelectionAndGetUserInput() {
		for (int i = 0; i < menuOptions.size(); i++){     // loops through every menu option in the menus array.
			System.out.println((i + 1) + ". " + menuOptions.get(i));     // printing the optiion number when displaying the menu
		}

		System.out.println();
		System.out.println("0. Cancel Order");

		ConsoleFormatter.divider(width);
		System.out.print("Please select an option: ");

		String userInput = scanner.nextLine();
		System.out.println();

		try{
			// converting userInoput to int and subtracting 1 (since arrays start at index 0)
			int i = Integer.parseInt(userInput) - 1;

			if (i >= 0 && i <= menuOptions.size()){        // validates that the number is within the array's range
				return i;
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

		return 0;
	}

	public static class Builder {
		private final ArrayList<String> menuOptions = new ArrayList<>();
		private int width = 50;


		public Builder addSelection(String menuName) {
			menuOptions.add(menuName);
			return this;
		}

		public Builder setWidth(int width) {
			this.width = width;
			return this;
		}
		// creating ConsoleSelector object
		public ConsoleSelector build() {
			return new ConsoleSelector(menuOptions, width);
		}
	}
}
