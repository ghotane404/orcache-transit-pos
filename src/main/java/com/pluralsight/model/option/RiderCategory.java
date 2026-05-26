package com.pluralsight.model.option;

public enum RiderCategory {
	ADULT("Adult"),
	SENIOR("Senior"),
	YOUTH("Youth");

	private final String displayName;

	RiderCategory(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
