package com.pluralsight.model.epurse;

import com.pluralsight.model.option.EPurseReloadOption;
import com.pluralsight.model.service.TransactionLineItem;

public class EPurseItem extends TransactionLineItem {

	public EPurseItem(EPurseReloadOption selectedOption, double unitPrice) {
		super("E-Purse Balance", selectedOption.getDisplayName(), 1, unitPrice);
	}
}

