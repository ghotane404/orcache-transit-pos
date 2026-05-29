package com.pluralsight;

import com.pluralsight.ui.home.HomeMenu;

public class Main {
	static int WIDTH = 65;

	public static void main(String[] args) {
		HomeMenu.displayHomeMenu();


//		displayHeaderStringBuilder("Test", WIDTH);

	}


//	public static void displayHeaderStringBuilder(String text, int WIDTH) {
//		StringBuilder receipt = new StringBuilder();
//		String headerLine = "=".repeat(WIDTH);
//		String subHeaderLine = "-".repeat(WIDTH);
//
//		String centeredText = " ".repeat(((WIDTH - text.length()) / 2)) + text;
//
//		receipt.append(headerLine).append("\n");
//		receipt.append(centeredText).append("\n");
//		receipt.append(headerLine).append("\n");
//
//		System.out.println(receipt.toString());
//
//	}

}
