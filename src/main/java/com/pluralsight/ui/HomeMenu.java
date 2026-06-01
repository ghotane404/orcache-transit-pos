package com.pluralsight.ui;
import com.pluralsight.util.ConsoleFormatter;
import com.pluralsight.ui.order.OrderMenu;

import java.util.*;

public class HomeMenu {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	static OrderMenu orderMenu = new OrderMenu();

	static Scanner scanner = new Scanner(System.in);
	static int WIDTH = 50;

	public static void displayHomeMenu() {
		while (true){
			consoleFormatter.displayHeader("HOME MENU" , WIDTH);

			System.out.println("1. New Order");
			System.out.println("0. Exit");
			consoleFormatter.divider(WIDTH);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1" -> orderMenu.displayOrderMenu();
				case "0" -> {
					System.out.println("Thank you for using OrCache Transit Service!");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}
}