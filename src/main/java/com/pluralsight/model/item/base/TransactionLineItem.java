package com.pluralsight.model.item.base;

import com.pluralsight.model.enums.RiderType;
import com.pluralsight.util.TransitPricingModel;

public abstract class TransactionLineItem {

	private final String lineItemCategory;
	private final String lineItemName;
	private final int quantity;
	private final double unitPrice;

	public TransactionLineItem(String lineItemCategory, String lineItemName, int quantity, double unitPrice) {
		this.lineItemCategory = lineItemCategory;
		this.lineItemName = lineItemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getLineItemCategory() {
		return lineItemCategory;
	}

	public String getLineItemName() {
		return lineItemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTotalPrice() {
		return quantity * unitPrice;
	}

	public int getAddOnQuantity() {
		int addOnQuantity = quantity - 1;
		return Math.max(addOnQuantity, 0);
	}

	public double getDiscountUnitPrice(RiderType riderType) {
		double discountMultiplier = TransitPricingModel.getDiscountMultiplier(riderType);
		return unitPrice * discountMultiplier;
	}
}