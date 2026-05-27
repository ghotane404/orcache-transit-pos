package com.pluralsight.menus;

import com.pluralsight.ui.ConsoleFormatter;

import java.util.Scanner;

public class FerryRouteMenu {
	static Scanner scanner = new Scanner(System.in);
	private int width = 50;
	static ConsoleFormatter consoleFormatter = new ConsoleFormatter();



	public void ferryRouteAddOn() {
		while (true){
			consoleFormatter.displayHeader("SELECT FERRY ROUTE ADD-ON" , width);
			System.out.println("1. WSF Mukilteo-Clinton          $58.80");
			System.out.println("2. WSF Vashon Island             $62.80");
			System.out.println("3. WSF Fauntleroy-Southworth     $74.00");
			System.out.println("4. WSF Port Townsend-Coupeville  $84.00");
			System.out.println("5. WSF Central Sound            $120.50");
			System.out.println("0. No Ferry Route Add-On");
			consoleFormatter.displayDivider(width);
			System.out.print("Select an option: ");
			String userInput = scanner.nextLine();






		}
	}
}
