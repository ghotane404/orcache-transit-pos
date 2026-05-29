package com.pluralsight.model.feature;

import com.pluralsight.model.option.AccountFeatureOption;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.service.TransactionLineItem;

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
