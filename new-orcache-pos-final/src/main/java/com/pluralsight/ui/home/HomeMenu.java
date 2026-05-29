package com.pluralsight.ui.home;
import com.pluralsight.ui.format.ConsoleFormatter;

import java.util.*;

public class HomeMenu {
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();
//	RetailItemMenu retailItemMenu = new RetailItemMenu(currentOrderItems);
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
					System.out.println("Thank you for whatever");
					return;
				}
				default -> System.out.println("Invalid option.");
			}
		}
	}


}
