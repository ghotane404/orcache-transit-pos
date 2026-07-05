package com.pluralsight.ui;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.Ansi;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.order.OrderMenu;
import com.pluralsight.util.ConsoleSelector;
import com.pluralsight.util.Navigator;

import java.util.*;

public class HomeMenu implements MenuScreen {
	Scanner scanner = new Scanner(System.in);
	static int WIDTH = 50;

	@Override
	public String showMenuName() {
		return "Home Menu";
	}

	@Override
	public void displayMenu() {
		while (true){
			ConsoleFormatter.displayHeader("HOME MENU" , WIDTH);
			ConsoleSelector selectorBuilder = new ConsoleSelector.Builder()
					.setWidth(WIDTH).addSelection("New Order").build();

			int userInput = selectorBuilder.showSelectionAndGetUserInput();

			switch (userInput) {
				case 1 -> Navigator.goToNextScreen(new OrderMenu());
				case 0 -> {
					System.out.println("Thank you for using OrCache Transit Service!");
					return;
				}
				default -> {
					System.out.println(Ansi.color("Error: Invalid option. Please try again.", Ansi.RED));
					System.out.println("Press ENTER to continue.");
					scanner.nextLine();
				}
			}
		}
	}
}