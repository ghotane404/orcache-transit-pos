package com.pluralsight.util;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleSelector {
	Scanner scanner = new Scanner(System.in);
	private final ArrayList<String> menuOptions;        // ArrayList to store all menu option names to display to the user.
	private final int width;

	// making the construction private to prevent other classes from accessing it
	private ConsoleSelector(ArrayList<String> menuOptions, int width) {
		this.menuOptions = menuOptions;
		this.width = width;
	}

	public int showSelectionAndGetUserInput() {
		for (int i = 0; i < menuOptions.size(); i++){
			System.out.println((i + 1) + ". " + menuOptions.get(i));     // displays the number option (1. Add Transit etc..)
		}

		System.out.println();
		System.out.println(Ansi.color("0. Return to Previous Menu", Ansi.BLACK));

		ConsoleFormatter.divider(width);
		System.out.print(Ansi.color("Please select an option: ", Ansi.YELLOW));

		var userInput = UserInputHelper.getIntegerInput(0, menuOptions.size());

		return userInput;
	}

	public static class Builder {
		// list stores the menuOptions while the ConsoleSelector is being built.
		private final ArrayList<String> menuOptions = new ArrayList<>();
		private int width = 50;

		public Builder addSelection(String menuName) {
			menuOptions.add(menuName);
			return this;
		}

		public Builder setWidth(int width) {
			this.width = width;   // store the custom width value.
			return this;     // return the same Builder object so methods can be repeated.
		}
		// calls ConsoleSelector constructor and passes the current Builder object into it.
		// menu options and width collected by the Builder.
		public ConsoleSelector build() {
			return new ConsoleSelector(menuOptions, width);
		}
	}
}
