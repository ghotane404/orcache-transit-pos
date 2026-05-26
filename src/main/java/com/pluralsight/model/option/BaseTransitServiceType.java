package com.pluralsight.model.option;

public enum BaseTransitServiceType {
	METRO_BUS(3,1,2, "Metro Bus"),
	LINK_LIGHT_RAIL(3,1,2, "Link Light Rail"),
	RAPID_RIDE(3,1,2, "Rapid Ride"),
	SOUND_TRANSIT_EXPRESS_BUS(3,1,2, "Sound Transit Express");

	private final double adultPrice, seniorPrice, youthPrice;
	private final String displayTransitServiceType;

	BaseTransitServiceType(int adultPrice, int seniorPrice, int youthPrice, String displayTransitServiceType) {
		this.adultPrice = adultPrice;
		this.seniorPrice = seniorPrice;
		this.youthPrice = youthPrice;
		this.displayTransitServiceType = displayTransitServiceType;
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
		return displayTransitServiceType;
	}

}
