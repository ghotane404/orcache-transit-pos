package com.pluralsight.model.item;

import com.pluralsight.model.item.base.CartItem;

public class RetailAccessoryCartItem extends CartItem {
	private final String accessoryName;
//	private String accessoryTierName;
	private final double basicAccessoryPrice;
	private final double standardAccessoryPrice;
	private final double premiumAccessoryPrice;

	public RetailAccessoryCartItem(String accessoryName, double basicAccessoryPrice, double standardAccessoryPrice, double premiumAccessoryPrice) {
		super(accessoryName, "Accessory", 1, 0.0);
		this.accessoryName = accessoryName;
//		this.accessoryTierName = accessoryTierName;
		this.basicAccessoryPrice = basicAccessoryPrice;
		this.standardAccessoryPrice = standardAccessoryPrice;
		this.premiumAccessoryPrice = premiumAccessoryPrice;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

//	public String getAccessoryTierName() {
//		return accessoryTierName;
//	}

	public double getBasicAccessoryPrice() {
		return basicAccessoryPrice;
	}

	public double getStandardAccessoryPrice() {
		return standardAccessoryPrice;
	}

	public double getPremiumAccessoryPrice() {
		return premiumAccessoryPrice;
	}

	public double getPriceFor(RetailAccessoryCartItem seletectedRetailAccessoryCartItem, int userInput) {
		return switch (userInput) {
			case 1 -> seletectedRetailAccessoryCartItem.getBasicAccessoryPrice();
			case 2 -> seletectedRetailAccessoryCartItem.getStandardAccessoryPrice();
			case 3 -> seletectedRetailAccessoryCartItem.getPremiumAccessoryPrice();
			default -> 0;
		};
	}

	public String getNameFor(int selectedAccessoryTier) {
		return switch (selectedAccessoryTier) {
			case 1 -> "Basic";
			case 2 -> "Standard";
			case 3 -> "Premium";
			default -> "";
		};
	}
}
