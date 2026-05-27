package com.pluralsight.model.option;

public enum TransitPassAddOn {
	ALL_DAY_PASS("All Day Pass"),
	MONTHLY_PASS("Monthly Pass"),
	E_PURSE("Starter $100 E-Purse Value"),
	NO_ADD_ON("No Add-On");

	private final String displayName;

	TransitPassAddOn(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
