package com.pluralsight.model.option;

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
