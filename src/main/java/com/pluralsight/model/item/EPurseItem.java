package com.pluralsight.model.item;

import com.pluralsight.model.enums.EPurseReloadOption;
import com.pluralsight.model.item.base.TransactionLineItem;

public class EPurseItem extends TransactionLineItem {

	public EPurseItem(EPurseReloadOption selectedOption, double unitPrice) {
		super("E-Purse Balance", selectedOption.getDisplayName(), 1, unitPrice);
	}
}

