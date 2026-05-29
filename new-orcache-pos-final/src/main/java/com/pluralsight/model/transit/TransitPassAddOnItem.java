package com.pluralsight.model.transit;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.model.option.TransitPassAddOn;
import com.pluralsight.service.TransitPricingModel;

public class TransitPassAddOnItem extends TransactionLineItem {
	private final TransitPassAddOn transitPassAddOn;
	private final RiderType riderType;

	public TransitPassAddOnItem(TransitPassAddOn transitPassAddOn, RiderType riderType, int quantity, double unitPrice) {
		super(LineItemCategory.TRANSIT_PASS_ADD_ON.getDisplayName(), transitPassAddOn.getDisplayName(), quantity, unitPrice);
		this.transitPassAddOn = transitPassAddOn;
		this.riderType = riderType;
	}

	public TransitPassAddOn getTransitPassAddOn() {
		return transitPassAddOn;
	}

	public RiderType getRiderType() {
		return riderType;
	}


	public int getAddOnQuantity() {
		return Math.max(getQuantity() - 1, 0);
	}

	public int getRegularQuantity() {
		return Math.min(getQuantity(), 1);
	}


	public double getDiscountRate() {
		return TransitPricingModel.getDiscountMultiplier(riderType);
	}

	public double getDiscountUnitPrice() {
		return getUnitPrice() * getDiscountRate();
	}


	@Override
	public double getTotalPrice() {
		double regularTotal = getRegularQuantity() * getUnitPrice();
		double discountTotal = getAddOnQuantity() * getDiscountUnitPrice();
		return regularTotal + discountTotal;
	}


}
