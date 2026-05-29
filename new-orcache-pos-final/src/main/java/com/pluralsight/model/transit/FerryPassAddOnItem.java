package com.pluralsight.model.transit;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.model.option.FerryPassAddOn;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.service.TransitPricingModel;


public class FerryPassAddOnItem extends TransactionLineItem {
	private final FerryPassAddOn ferryPassAddOn;
	private final RiderType riderType;

	public FerryPassAddOnItem(FerryPassAddOn ferryPassAddOn, RiderType riderType, int quantity, double unitPrice) {
		super(LineItemCategory.FERRY_PASS_ADD_ON.getDisplayName(), ferryPassAddOn.getDisplayName(),  quantity, unitPrice);
		this.ferryPassAddOn = ferryPassAddOn;
		this.riderType = riderType;
	}

	public FerryPassAddOn getFerryRouteAddOn() {
		return ferryPassAddOn;
	}

	public RiderType getRiderType() {
		return riderType;
	}


	public double getTotalPrice() {
		return getQuantity() * getUnitPrice();

	}

	public int getAddOnQuantity() {
		int addOnQuantity = getQuantity() - 1;

		return Math.max(addOnQuantity, 0);
	}


	public double getDiscountUnitPrice(RiderType riderType) {
		return TransitPricingModel.getDiscountMultiplier(riderType) * getAddOnQuantity();
	}

	public double getDiscountUnitPrice() {
		return TransitPricingModel.getDiscountMultiplier(riderType) * getAddOnQuantity();
	}



}






