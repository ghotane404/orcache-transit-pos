package com.pluralsight.ui.order.transit.addon;

import com.pluralsight.model.item.FerryPassAddOnItem;
import com.pluralsight.model.enums.FerryPassAddOn;
import com.pluralsight.model.enums.RiderType;
import com.pluralsight.util.ShoppingCart;
import com.pluralsight.util.TransitPricingModel;
import com.pluralsight.ui.order.transit.feature.AccountFeatureMenu;
import com.pluralsight.util.ConsoleFormatter;

import java.util.*;

public class FerryPassAddOnMenu {
	ConsoleFormatter consoleFormatter = new ConsoleFormatter();
	private static final Scanner scanner = new Scanner(System.in);
	int WIDTH = 65;


	private final ShoppingCart shoppingCart;

	public FerryPassAddOnMenu(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	public void displayFerryPassAddOnMenu(RiderType selectedRiderType) {
		while(true) {
			consoleFormatter.displayHeader("SELECT FERRY ROUTE PASS" , WIDTH);
			consoleFormatter.displayTypeIdentifier("Rider Type: " + selectedRiderType.getDisplayName(), WIDTH);

			System.out.println("Would you like to add a one-way ferry pass onto this card?");
			System.out.println("Additional ferry route upgrades receive 15% off.");
			System.out.println();
			// DRY if enough time
			double mukilteoClintonPrice = TransitPricingModel.getAddOnFerryPrice(FerryPassAddOn.WSF_MUKILTEO_CLINTON, selectedRiderType);
			double mukilteoClintonDiscountPrice = mukilteoClintonPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "1. WSF Mukilteo-Clinton", mukilteoClintonPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional:", mukilteoClintonDiscountPrice);
			System.out.println();

			double vashonIslandPrice = TransitPricingModel.getAddOnFerryPrice(FerryPassAddOn.WSF_VASHON_ISLAND, selectedRiderType);
			double vashonIslandDiscountPrice = vashonIslandPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "2. WSF Vashon Island", vashonIslandPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional:", vashonIslandDiscountPrice);
			System.out.println();

			double fauntleroySouthworthPrice = TransitPricingModel.getAddOnFerryPrice(FerryPassAddOn.WSF_FAUNTLEROY_SOUTHWORTH, selectedRiderType);
			double fauntleroySouthworthDiscountPrice = fauntleroySouthworthPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "3. WSF Fauntleroy-Southworth", fauntleroySouthworthPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional:", fauntleroySouthworthDiscountPrice);
			System.out.println();

			double portTownsendCoupevillePrice = TransitPricingModel.getAddOnFerryPrice(FerryPassAddOn.WSF_PORT_TOWNSEND_COUPEVILLE, selectedRiderType);
			double portTownsendCoupevilleDiscountPrice = portTownsendCoupevillePrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "4. WSF Port Townsend-Coupeville", portTownsendCoupevillePrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional:", portTownsendCoupevilleDiscountPrice);
			System.out.println();


			double centralSoundPrice = TransitPricingModel.getAddOnFerryPrice(FerryPassAddOn.WSF_CENTRAL_SOUND, selectedRiderType);
			double centralSoundDiscountPrice = centralSoundPrice * TransitPricingModel.getDiscountMultiplier(selectedRiderType);
			System.out.printf("%-50s $%7.2f%n", "5. WSF Central Sound", centralSoundPrice);
			System.out.printf("%-50s $%7.2f%n", "       Additional:", centralSoundDiscountPrice);
			System.out.println();
			System.out.println("6. Continue to Next Step");
			System.out.println("0. Return to Order Menu");

			consoleFormatter.divider(WIDTH);
			System.out.print("Please select an option: ");
			String userOption = scanner.nextLine();

			FerryPassAddOn selectedFerryPassAddOn = null;     // calling the enum

			switch (userOption) {
				case "1" -> {selectedFerryPassAddOn = FerryPassAddOn.WSF_MUKILTEO_CLINTON;}
				case "2" -> {selectedFerryPassAddOn = FerryPassAddOn.WSF_VASHON_ISLAND;}
				case "3" -> {selectedFerryPassAddOn = FerryPassAddOn.WSF_FAUNTLEROY_SOUTHWORTH;}
				case "4" -> {selectedFerryPassAddOn = FerryPassAddOn.WSF_PORT_TOWNSEND_COUPEVILLE;}
				case "5" -> {selectedFerryPassAddOn = FerryPassAddOn.WSF_CENTRAL_SOUND;}
				case "6" -> {
					AccountFeatureMenu accountFeatureMenu = new AccountFeatureMenu(shoppingCart);
					accountFeatureMenu.displayAccountFeatureMenu();
					return;
				}
				case "0" -> {
					System.out.println("Returning to Order Screen.");
					return;
				}
				default -> {
					System.out.println("Invalid option.");
					continue;
				}
			}

			System.out.print("Please enter the quantity to purchase: ");
			int quantity = Integer.parseInt(scanner.nextLine());
			double unitPrice = TransitPricingModel.getAddOnFerryPrice(selectedFerryPassAddOn, selectedRiderType);

			FerryPassAddOnItem ferryPassAddOnItem = new FerryPassAddOnItem(selectedFerryPassAddOn, selectedRiderType,
					quantity, unitPrice);
			shoppingCart.addItem(ferryPassAddOnItem);

			System.out.println();
			System.out.println("Added:");
			System.out.printf("- %-30s $ %6.2f%n", selectedFerryPassAddOn.getDisplayName(), unitPrice);
			System.out.printf("    Additional: $ %.2f x %d%n", ferryPassAddOnItem.getDiscountUnitPrice(), ferryPassAddOnItem.getAddOnQuantity());
			System.out.println();

			System.out.println("Press ENTER to continue.");
			scanner.nextLine();

			AccountFeatureMenu accountFeatureMenu = new AccountFeatureMenu(shoppingCart);
			accountFeatureMenu.displayAccountFeatureMenu();

			return;
		}


	}

}
