package com.pluralsight.model.enums;

/**
 * Free account features that can be activated for devices.
 */
public enum AccountFeatureOption {
    AUTO_RELOAD_SETUP("Auto-Reload Setup"),
    DIGITAL_RECEIPT("Digital Receipt"),
    BALANCE_TRACKING("Balance Tracking"),
    TRIP_HISTORY("Trip History"),
    FARE_ALERTS("Email or SMS Fare Alerts"),
    COMMUTER_BENEFITS_LINKING("Commuter Benefits Linking");

    private final String displayName;

    AccountFeatureOption(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
