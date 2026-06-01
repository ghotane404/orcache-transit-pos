package com.pluralsight.model.item;


import com.pluralsight.model.enums.RetailAccessory;
import com.pluralsight.model.item.base.TransactionLineItem;

public class RetailAccessoryItem extends TransactionLineItem {


	public RetailAccessoryItem(RetailAccessory selectedAccessory, int quantity, double unitPrice) {
		super("Retail Accessory", selectedAccessory.getDisplayName(), quantity, unitPrice);
	}
}
