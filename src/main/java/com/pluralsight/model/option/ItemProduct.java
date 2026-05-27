package com.pluralsight.model.option;

public enum ItemProduct {
	BASE_TRANSIT_SERVICE("Base Transit Service"),
	TRANSIT_PASS_ADD_ON("Transit Pass Add-On"),
	RETAIL_ITEM("Retail Item"),
	E_PURSE_TOP_UP("E-Purse Top-Up");

	private final String displayName;
	ItemProduct(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
