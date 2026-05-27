//package com.pluralsight.model.product;
//
//import com.pluralsight.model.option.BaseTransitServiceType;
//import com.pluralsight.model.option.RiderCategory;
//import com.pluralsight.model.option.TransitPassAddOn;
//import com.pluralsight.ui.ConsoleFormatter;
//import com.pluralsight.menus.TransitPassMenu;
//
//import java.util.Scanner;
//
//public class BaseTransitService {
//ConsoleFormatter consoleFormatter = new ConsoleFormatter();
//	private BaseTransitServiceType baseTransitServiceType;
//	private RiderCategory selectedRiderCategory;
//	private TransitPassAddOn selectedTransitPassAddOn;
//	private double totalCost;
//
//	public BaseTransitService(BaseTransitServiceType baseTransitServiceType, RiderCategory selectedRiderCategory,
//	                          TransitPassAddOn selectedTransitPassAddOn, double totalCost) {
//		this.baseTransitServiceType = baseTransitServiceType;
//		this.selectedRiderCategory = selectedRiderCategory;
//		this.selectedTransitPassAddOn = selectedTransitPassAddOn;
//		this.totalCost = totalCost;
//	}
//
//	public BaseTransitService() {
//
//	}
//
//
//	public BaseTransitServiceType getBaseTransitServiceType() {
//		return baseTransitServiceType;
//	}
//
//	public void setBaseTransitServiceType(BaseTransitServiceType baseTransitServiceType) {
//		this.baseTransitServiceType = baseTransitServiceType;
//	}
//
//	public RiderCategory getSelectedRiderCategory() {
//		return selectedRiderCategory;
//	}
//
//	public void setSelectedRiderCategory(RiderCategory selectedRiderCategory) {
//		this.selectedRiderCategory = selectedRiderCategory;
//	}
//
//	public TransitPassAddOn getSelectedTransitPassAddOn() {
//		return selectedTransitPassAddOn;
//	}
//
//	public void setSelectedTransitPassAddOn(TransitPassAddOn selectedTransitPassAddOn) {
//		this.selectedTransitPassAddOn = selectedTransitPassAddOn;
//	}
//
//	public double getTotalCost() {
//		return totalCost;
//	}
//
//	public void setTotalCost(double totalCost) {
//		this.totalCost = totalCost;
//	}
//
//	public void displayBaseTransitServiceType(int width) {
//		Scanner scanner = new Scanner(System.in);
//
//		while (true) {
//			consoleFormatter.displayHeader("SELECT BASE TRANSIT SERVICE", width);
//			System.out.println("1. Metro Bus");
//			System.out.println("2. Link Light Rail");
//			System.out.println("3. Rapid Ride");
//			System.out.println("4. Sound Transit Express Bus");
//			System.out.println("0. Return to Order Screen");
//			consoleFormatter.displayDivider(width);
//			System.out.print("Select an option: ");
//			String userInput = scanner.nextLine();
//
//			switch (userInput) {
//				case "1" -> {
//					setBaseTransitServiceType(BaseTransitServiceType.METRO_BUS);
//					displayRiderCategory(BaseTransitServiceType.METRO_BUS, width);
//					return;
//				}
//				case "2" -> {
//					setBaseTransitServiceType(BaseTransitServiceType.LINK_LIGHT_RAIL);
//					displayRiderCategory(BaseTransitServiceType.LINK_LIGHT_RAIL, width);
//					return;
//				}
//				case "3" -> {
//					setBaseTransitServiceType(BaseTransitServiceType.RAPID_RIDE);
//					displayRiderCategory(BaseTransitServiceType.RAPID_RIDE, width);
//					return;
//				}
//				case "4" -> {
//					setBaseTransitServiceType(BaseTransitServiceType.SOUND_TRANSIT_EXPRESS_BUS);
//					displayRiderCategory(BaseTransitServiceType.SOUND_TRANSIT_EXPRESS_BUS, width);
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Order Screen.");
//					return;
//				}
//				default -> System.out.println("Invalid option.");
//			}
//		}
//	}
//
//	public void displayRiderCategory(BaseTransitServiceType selectedBaseTransitServiceType, int width) {
//		Scanner scanner = new Scanner(System.in);
//		TransitPassMenu transitPassMenu = new TransitPassMenu();
//
//		while (true) {
//			consoleFormatter.displayHeader("SELECT RIDER CATEGORY", width);
//			System.out.println("1. Adult      $3.00 base fare");
//			System.out.println("2. Senior    $1.00 base fare");
//			System.out.println("3. Youth     $2.00 base fare");
//			System.out.println("0. Return to Base Transit Service");
//			consoleFormatter.displayDivider(width);
//			System.out.print("Please select rider type: ");
//			String userInput = scanner.nextLine();
//			switch (userInput) {
//				case "1" -> {
//					setSelectedRiderCategory(RiderCategory.ADULT);
//					transitPassMenu.displayTransitPassAddOnMenu(RiderCategory.ADULT, selectedBaseTransitServiceType);
//					return;
//				}
//				case "2" -> {
//					setSelectedRiderCategory(RiderCategory.SENIOR);
//					transitPassMenu.displayTransitPassAddOnMenu(RiderCategory.SENIOR, selectedBaseTransitServiceType);
//					return;
//				}
//				case "3" -> {
//					setSelectedRiderCategory(RiderCategory.YOUTH);
//					transitPassMenu.displayTransitPassAddOnMenu(RiderCategory.YOUTH, selectedBaseTransitServiceType);
//					return;
//				}
//				case "0" -> {
//					System.out.println("Returning to Base Transit Service.");
//					return;
//				}
//				default -> System.out.println("Invalid option.");
//			}
//		}
//	}
//
//
//}
