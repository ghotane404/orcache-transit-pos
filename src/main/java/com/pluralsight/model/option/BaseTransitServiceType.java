package com.pluralsight.model.option;

public enum BaseTransitServiceType {
	METRO_BUS("Metro Bus"),
	LINK_LIGHT_RAIL("Link Light Rail"),
	RAPID_RIDE("Rapid Ride"),
	SOUND_TRANSIT_EXPRESS_BUS("Sound Transit Express Bus");

	private final String displayName;       // used to stores the display name for each transit service

	// constructor that will save the parameter displayName for each transit service
	BaseTransitServiceType(String displayName) {
		this.displayName = displayName;
	}

	// gets the display name for the transit service (e.g Metro Bus).
	public String getDisplayName() {
		return displayName;
	}
}
