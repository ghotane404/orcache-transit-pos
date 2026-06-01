package com.pluralsight.model.enums;

public enum EPurseReloadOption {
    ADD_FIVE("Add $5.00"),
    ADD_TEN("Add $10.00"),
    ADD_FIFTEEN("Add $15.00"),
    ADD_TWENTY("Add $20.00");

    private final String displayName;

    EPurseReloadOption(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}