package com.pluralsight.model.enums;

/**
 * Free card design options.
 */
public enum CardDesignOption {
    ORCA_WAVE("Orca Wave"),
    SEATTLE_SKYLINE("Seattle Skyline"),
    FERRY_CROSSING("Ferry Crossing"),
    COFFEE_LINE("Coffee Line");

    private final String displayName;

    CardDesignOption(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
