package com.pluralsight.model.retail;


import com.pluralsight.model.service.TransactionLineItem;
import com.pluralsight.model.option.RetailAccessory;

public class RetailAccessoryItem extends TransactionLineItem {


	public RetailAccessoryItem(RetailAccessory selectedAccessory, int quantity, double unitPrice) {
		super("Retail Accessory", selectedAccessory.getDisplayName(), quantity, unitPrice);
	}
}
