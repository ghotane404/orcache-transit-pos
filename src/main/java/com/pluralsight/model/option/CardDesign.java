package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class CardDesign implements ShoppingItem {
	private final String cardDesignName;
	private final double cardDesignPrice;

	public CardDesign(String cardDesignName,  double cardDesignPrice) {
		this.cardDesignName = cardDesignName;
		this.cardDesignPrice = cardDesignPrice;
	}

	@Override
	public String getName() {
		return cardDesignName;
	}

	@Override
	public double getPrice() {
		return cardDesignPrice;
	}
}
