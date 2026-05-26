package com.pluralsight.model.option;

public enum LineItemCategory {
	BASE_TRANSIT_SERVICE ("BASE TRANSIT SERVICE"),
	TRANSIT_PASS_ADD_ON ("TRANSIT PASS ADD-ON"),
	FERRY_ROUTE_ADD_ON("FERRY ROUTE ADD-ON"),
	CARD_FEATURES("CARD FEATURES"),
	CARD_DESIGN("CARD DESIGN"),
	RETAIL_ITEMS("RETAIL ITEMS"),
	E_PURSE_TOP_UP("E-PURSE TOP-UP"),
	DEVICE_REGISTRATION("DEVICE REGISTRATION"),
	ORDER_SUMMARY("ORDER SUMMARY");

	private final String displayName;

	LineItemCategory(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
