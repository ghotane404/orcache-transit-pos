package com.pluralsight.model.option;

public enum TransitPassAddOn {
	ALL_DAY_PASS(6,2,3.75, "All Day Pass"),
	MONTHLY_PASS(108,36,50, "Monthly Pass"),
	E_PURSE(90,70,80, "Starter $100 E-Purse Value");

	private final double adultPrice;
	private final double seniorPrice;
	private final double youthPrice;
	private final String displayName;

	TransitPassAddOn(double adultPrice, double seniorPrice, double youthPrice, String displayName) {
		this.adultPrice = adultPrice;
		this.seniorPrice = seniorPrice;
		this.youthPrice = youthPrice;
		this.displayName = displayName;
	}

	public double getAdultPrice() {
		return adultPrice;
	}

	public double getSeniorPrice() {
		return seniorPrice;
	}

	public double getYouthPrice() {
		return youthPrice;
	}

	public String getDisplayName() {
		return displayName;
	}

}
