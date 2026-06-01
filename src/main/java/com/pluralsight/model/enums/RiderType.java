package com.pluralsight.model.enums;

/**
 * Passenger fare classes.
 */
public enum RiderType {
    ADULT("Adult"),
    SENIOR("Senior"),
    YOUTH("Youth");

    private final String displayName;

    RiderType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
