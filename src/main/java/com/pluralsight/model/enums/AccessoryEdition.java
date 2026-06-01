package com.pluralsight.model.enums;

public enum AccessoryEdition {
    BASIC("Basic"),
    STANDARD("Standard"),
    PREMIUM("Premium");

    private final String displayName;

    AccessoryEdition(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}