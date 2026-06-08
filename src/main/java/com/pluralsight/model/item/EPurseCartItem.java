package com.pluralsight.model.item;

import com.pluralsight.model.item.base.CartItem;

public class EPurseCartItem extends CartItem {
	private final String ePurseCardItemName;
	private final String ePurseCardItemCategory;
	private final int ePurseCardItemQuantity;
	private double ePurseCardItemPrice;

	public EPurseCartItem(String ePurseCardItemName, String ePurseCardItemCategory, int ePurseCardItemQuantity, double ePurseCardItemPrice) {
		super(ePurseCardItemName, "E-Purse", 1, 0.0);
		this.ePurseCardItemName = ePurseCardItemName;
		this.ePurseCardItemCategory = ePurseCardItemCategory;
		this.ePurseCardItemQuantity = ePurseCardItemQuantity;
		this.ePurseCardItemPrice = ePurseCardItemPrice;
	}

	public String getePurseCardItemName() {
		return ePurseCardItemName;
	}

	public String getePurseCardItemCategory() {
		return ePurseCardItemCategory;
	}

	public int getePurseCardItemQuantity() {
		return ePurseCardItemQuantity;
	}

	public double getePurseCardItemPrice() {
		return ePurseCardItemPrice;
	}


}

