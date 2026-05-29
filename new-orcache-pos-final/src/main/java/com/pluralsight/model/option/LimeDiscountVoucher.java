package com.pluralsight.model.option;

/**
 * Free Lime discount vouchers that can be selected with a card.
 */
public enum LimeDiscountVoucher {
    FIRST_30_MINUTE_RIDE_FREE("Lime First 30-Minute Ride Free"),
    WEEKEND_25_PERCENT_OFF("Weekend 25% Ride Off Promo"),
    MORNING_50_PERCENT_COMMUTER_DISCOUNT("Morning 50% Commuter Discount");

    private final String displayName;

    LimeDiscountVoucher(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
