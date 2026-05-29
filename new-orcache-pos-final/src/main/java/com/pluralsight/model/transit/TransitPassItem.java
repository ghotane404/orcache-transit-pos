package com.pluralsight.model.transit;

import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.model.option.TransitServiceType;

public class TransitPassItem extends TransactionLineItem {
	private final TransitServiceType transitServiceType;
	private final RiderType riderType;

	public TransitPassItem(TransitServiceType transitServiceType, RiderType riderType, int quantity, double unitPrice) {
		super(LineItemCategory.TRANSIT_PASS.getDisplayName(), riderType.getDisplayName(),  quantity, unitPrice);
		this.transitServiceType = transitServiceType;
		this.riderType = riderType;
	}

	public TransitServiceType getTransitServiceType() {
		return transitServiceType;
	}

	public RiderType getRiderType() {
		return riderType;
	}



	@Override
	public double getTotalPrice() {
		double regularTotal = getQuantity() * getUnitPrice();

		return regularTotal;

	}


}
