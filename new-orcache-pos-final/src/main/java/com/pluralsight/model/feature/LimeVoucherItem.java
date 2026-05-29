package com.pluralsight.model.feature;

import com.pluralsight.model.option.LimeDiscountVoucher;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.service.TransactionLineItem;

public class LimeVoucherItem extends TransactionLineItem {
	private final LimeDiscountVoucher limeDiscountVoucher;
	private final int maxDevice;

	public LimeVoucherItem(LimeDiscountVoucher limeDiscountVoucher, int quantity) {
		super(LineItemCategory.LIME_DISCOUNT_VOUCHER.getDisplayName(), limeDiscountVoucher.getDisplayName(),
				quantity, 0.00);
		this.limeDiscountVoucher = limeDiscountVoucher;
		this.maxDevice = 3;
	}

	public LimeDiscountVoucher getLimeDiscountVoucher() {
		return limeDiscountVoucher;
	}

	public int getMaxDevice() {
		return maxDevice;
	}

	public double getTotalPrice() {
		return 0.00;
	}





}
