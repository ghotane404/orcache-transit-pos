package com.pluralsight.model.item;

import com.pluralsight.model.enums.AccountFeatureOption;
import com.pluralsight.model.enums.LineItemCategory;
import com.pluralsight.model.item.base.TransactionLineItem;

public class AccountFeatureItem extends TransactionLineItem {
	private AccountFeatureOption accountFeatureOption;
	private int quantity;

	public AccountFeatureItem(AccountFeatureOption accountFeatureOption, int quantity) {
		super(LineItemCategory.ACCOUNT_FEATURE.getDisplayName(), accountFeatureOption.getDisplayName(),
		quantity, 0.00);

		this.accountFeatureOption = accountFeatureOption;
		this.quantity = quantity;

	}

	public AccountFeatureOption getAccountFeatureOption() {
		return accountFeatureOption;
	}

	public int getQuantity() {
		return quantity;
	}


}
