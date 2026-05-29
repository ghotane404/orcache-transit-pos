package com.pluralsight.model.option;

/**
 * Retail accessories that can be purchased.
 */
public enum RetailAccessory {
    CARD_WALLET_HOLDER("Card Wallet Holder"),
    PROTECTIVE_CARD_SLEEVE("Protective Card Sleeve"),
    LANYARD_WITH_BREAKAWAY("Lanyard with Breakaway"),
    RFID_BLOCKING_CARD_HOLDER("RFID-Blocking Card Holder");

    private final String displayName;

    RetailAccessory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
