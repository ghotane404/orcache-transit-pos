package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class LimeVoucher implements ShoppingItem {
	private String limeVoucherName;
	private double limeVoucherPrice;

	public LimeVoucher(String limeVoucherName, double limeVoucherPrice) {
		this.limeVoucherName = limeVoucherName;
		this.limeVoucherPrice = limeVoucherPrice;
	}

	@Override
	public String getName() {
		return limeVoucherName;
	}

	@Override
	public double getPrice() {
		return limeVoucherPrice;
	}
}
