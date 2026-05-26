package com.pluralsight.service;

import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.option.TransitPassAddOn;

public class TransitPricingModel {
	/**
	 * Gets the base transit price based on the selected transit service and rider category.
	 *
	 * @param baseTransitPrice the selected base transit service
	 * @param riderCategory the selected rider category
	 * @return the base transit price
	 */
	public static double getBaseTransitPrice(BaseTransitServiceType baseTransitPrice, RiderCategory riderCategory) {
		// The baseTransitPrice parameter is same and also kept in case of price changes.
		return switch (riderCategory) {
			case ADULT -> 3.00;
			case SENIOR -> 1.00;
			case YOUTH -> 2.00;
		};
	}
	/**
	 * Gets the add-on transit pass price based on the selected pass and rider category.
	 *
	 * @param transitAddOnPrice the selected transit pass add-on
	 * @param riderCategory the selected rider category
	 * @return the add-on transit pass price
	 */
	public static double getAddOnTransitPrice(TransitPassAddOn transitAddOnPrice, RiderCategory riderCategory) {
		return switch (transitAddOnPrice) {
			case ALL_DAY_PASS -> switch (riderCategory) {
				case ADULT -> 6.00;
				case SENIOR -> 2.00;
				case YOUTH -> 3.75;
			};
			case MONTHLY_PASS -> switch (riderCategory) {
				case ADULT -> 108.00;
				case SENIOR -> 36.00;
				case YOUTH -> 50.00;
			};
			case E_PURSE -> switch (riderCategory) {
				case ADULT -> 90.00;
				case SENIOR -> 70.00;
				case YOUTH -> 80.00;
			};
		};
	}

	public static double calculateTransitCartTotal(BaseTransitServiceType baseTransitPrice,
			TransitPassAddOn transitAddOnPrice, RiderCategory riderCategory) {
		return getBaseTransitPrice(baseTransitPrice, riderCategory)
				+ getAddOnTransitPrice(transitAddOnPrice, riderCategory);
	}
}