package com.pluralsight.model.option;

import com.pluralsight.model.interfaces.ShoppingItem;

public class AccountBenefit implements ShoppingItem {
	private final String accountBenefitName;
	private final int accountBenefitQuantity;

	public AccountBenefit(String accountBenefitName, int accountBenefitQuantity) {
		this.accountBenefitName = accountBenefitName;
		this.accountBenefitQuantity = accountBenefitQuantity;
	}

	@Override
	public String getName() {
		return accountBenefitName;
	}

	@Override
	public double getPrice() {
		return accountBenefitQuantity;
	}
}
