package com.pluralsight.model.enums;

/**
 * Extra transit pass products that can be loaded onto a transit card.
 */
public enum TransitPassAddOn {
    ALL_DAY_PASS("All Day Pass"),
    MONTHLY_PASS("Monthly Pass"),
    SEVEN_DAY_PASS("7-Day Pass"),
    NO_ADD_ON("No Add-On");

    private final String displayName;

    TransitPassAddOn(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
