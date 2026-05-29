package com.pluralsight.model.option;

/**
 * Ferry route upgrades that can be added to an order.
 */
public enum FerryPassAddOn {
    WSF_MUKILTEO_CLINTON("WSF Mukilteo-Clinton"),
    WSF_VASHON_ISLAND("WSF Vashon Island"),
    WSF_FAUNTLEROY_SOUTHWORTH("WSF Fauntleroy-Southworth"),
    WSF_PORT_TOWNSEND_COUPEVILLE("WSF Port Townsend-Coupeville"),
    WSF_CENTRAL_SOUND("WSF Central Sound");

    private final String displayName;

    FerryPassAddOn(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
