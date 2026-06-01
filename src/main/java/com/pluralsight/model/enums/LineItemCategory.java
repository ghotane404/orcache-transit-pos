package com.pluralsight.model.enums;

/**
 * Categories used to group items on the receipt.
 */
public enum LineItemCategory {
    TRANSIT_PASS("Transit Pass"),
    TRANSIT_PASS_ADD_ON("Transit Pass Add-On"),
    FERRY_PASS_ADD_ON("Ferry Pass Add-On"),
    CARD_STYLE("Card Style"),
    ACCOUNT_FEATURE("Account Feature"),
    LIME_DISCOUNT_VOUCHER("Lime Discount Voucher"),
    E_PURSE_BALANCE("E-Purse Balance"),
    RETAIL_ACCESSORY("Retail Accessory");

    private final String getDisplayName;

    LineItemCategory(String getDisplayName) {
        this.getDisplayName = getDisplayName;
    }

    public String getDisplayName() {
        return getDisplayName;
    }
}
