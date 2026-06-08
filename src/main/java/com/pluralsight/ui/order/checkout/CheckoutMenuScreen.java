package com.pluralsight.ui.order.checkout;

import com.pluralsight.filemanager.ReceiptFileManager;
import com.pluralsight.model.item.base.CartItem;
import com.pluralsight.ui.interfaces.MenuScreen;
import com.pluralsight.util.Ansi;
import com.pluralsight.model.cart.ShoppingCart;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CheckoutMenuScreen implements MenuScreen {
	@Override
	public String showMenuName() {
		return "";
	}

	@Override
	public void displayMenu() {

	}
//	private final ReceiptFileManager receiptFileManager = new ReceiptFileManager();
//	private final Random random = new Random();
//	private final Scanner scanner = new Scanner(System.in);
//
//	private final int WIDTH = 65;
//
//
//	private final ShoppingCart shoppingCart;
//
//	public CheckoutMenuScreen(ShoppingCart shoppingCart) {
//		this.shoppingCart = shoppingCart;
//	}
//
//
//	public void displayMenu() {
//
//		if (shoppingCart.isEmpty()) {
//			System.out.println(Ansi.color("No items in current order. Please try again.", Ansi.RED));
//			System.out.println("Press ENTER to continue.");
//			scanner.nextLine();
//			return;
//		}
//
//		String receiptText = createReceiptText(shoppingCart.getCurrentOrderItems());
//
//		System.out.println(receiptText);
//
//		System.out.print("Save receipt? Y/N: ");
//		String userChoice = scanner.nextLine().trim();
//
//		if (userChoice.equalsIgnoreCase("Y")) {
//			receiptFileManager.saveReceipt(receiptText);
//		}
//		else {
//			System.out.println("Receipt was not saved.");
//		}
//	}
//
//
//	private String createReceiptText(ArrayList<CartItem> currentOrderItems) {
//		StringBuilder receipt = new StringBuilder();
//
//		int receiptId = random.nextInt(9000) + 1000;
//		double total = 0;
//		String lastCategory = "";
//
//		receipt.append("=".repeat(WIDTH)).append("\n");
//		receipt.append(centerText("ORCACHE TRANSIT POS", WIDTH)).append("\n");
//		receipt.append("=".repeat(WIDTH)).append("\n");
//
//		receipt.append("Receipt ID: ").append(receiptId).append("\n");
//		receipt.append("Date:       ").append(currentDate()).append("\n");
//		receipt.append("Time:       ").append(currentTime()).append("\n");
//
//		for (CartItem item : currentOrderItems) {
//
//			if (!item.getLineItemCategory().equals(lastCategory)) {
//				receipt.append("\n");
//				receipt.append("-".repeat(WIDTH)).append("\n");
//				receipt.append(item.getLineItemCategory().toUpperCase()).append("\n");
//				receipt.append("-".repeat(WIDTH)).append("\n");
//
//				lastCategory = item.getLineItemCategory();
//			}
//
//			receipt.append(String.format("%-32s Qty: %-3d @ $%7.2f  Total: $%7.2f%n", item.getLineItemName(),
//					item.getQuantity(), item.getUnitPrice(), item.getTotalCartItemPrice()));
//
//			total += item.getTotalCartItemPrice();
//		}
//
//		receipt.append("\n");
//		receipt.append("-".repeat(WIDTH)).append("\n");
//		receipt.append(String.format("%-48s $%8.2f%n", "TOTAL:", total));
//		receipt.append("=".repeat(WIDTH)).append("\n");
//		receipt.append(centerText("Thank you for using OrCache!", WIDTH)).append("\n");
//		receipt.append("=".repeat(WIDTH)).append("\n");
//
//		return receipt.toString();
//	}
//
//	private String currentDate() {
//		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//		return now.format(formatter);
//	}
//
//	private String currentTime() {
//		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//		return now.format(formatter);
//	}
//
//	private String centerText(String text, int width) {
//		int spacesBefore = (width - text.length()) / 2;
//
//		return " ".repeat(spacesBefore) + text;
//	}
//
//	@Override
//	public String showMenuName() {
//		return "Checkout";
//	}

}