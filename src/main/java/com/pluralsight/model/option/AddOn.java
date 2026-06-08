package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class AddOn implements ShoppingItem {
	private final String addOnType;
	private final double adultPrice;
	private final double seniorPrice;
	private final double youthPrice;
	private final RiderType riderType;

	public AddOn(String addOnType, double adultPrice, double seniorPrice, double youthPrice, RiderType riderType) {
		this.addOnType = addOnType;
		this.adultPrice = adultPrice;
		this.seniorPrice = seniorPrice;
		this.youthPrice = youthPrice;
		this.riderType = riderType;
	}

	@Override
	public String getName() {
		return addOnType;
	}

	@Override
	public double getPrice() {
		return getPriceFor(this.riderType);
	}

	public double getPriceFor(RiderType riderType) {
		if (riderType.getName().trim().equalsIgnoreCase("Adult")) {
			return adultPrice;
		}

		else if (riderType.getName().trim().equalsIgnoreCase("Senior")) {
			return seniorPrice;
		}

		else if (riderType.getName().trim().equalsIgnoreCase("Youth")) {
			return youthPrice;
		}
		return 0.00;        // check later
	}

}
