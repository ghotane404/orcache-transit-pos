package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class RiderType implements ShoppingItem {
	private final String riderTypeName;
	private final double riderTypePrice;

	public RiderType(String riderTypeName, double riderTypePrice) {
		this.riderTypeName = riderTypeName;
		this.riderTypePrice = riderTypePrice;
	}

	@Override
	public String getName() {
		return riderTypeName;
	}

	@Override
	public double getPrice() {
		return riderTypePrice;
	}
}
