package com.pluralsight.model.item;

import com.pluralsight.model.item.base.TransactionLineItem;
import com.pluralsight.model.enums.LineItemCategory;
import com.pluralsight.model.enums.RiderType;
import com.pluralsight.model.enums.TransitServiceType;

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
