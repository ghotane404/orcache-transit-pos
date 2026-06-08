package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class TransitCard implements ShoppingItem {
	private final String transitCardName;
//	private final double transitCardPrice;

	public TransitCard(String transitCardName) {
		this.transitCardName = transitCardName;
	}

	public String getTransitCardName() {
		return transitCardName;
	}

	@Override
	public String getName() {
		return transitCardName;
	}

	@Override
	public double getPrice() {
		return 0;
	}
}
