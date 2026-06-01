package com.pluralsight.model.enums;

/**
 * Main transit services available for the base one-way pass.
 */
public enum TransitServiceType {
    METRO_BUS("Metro Bus"),
    LINK_LIGHT_RAIL("Link Light Rail"),
    RAPID_RIDE("Rapid Ride"),
    SOUND_TRANSIT_EXPRESS_BUS("Sound Transit Express Bus");

    private final String displayName;

    TransitServiceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
