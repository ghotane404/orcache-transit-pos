package com.pluralsight.util;

import com.pluralsight.model.item.base.TransactionLineItem;
import java.util.*;

public class ShoppingCart {
	private final ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();

	public void addItem(TransactionLineItem transactionLineItem) {
		currentOrderItems.add(transactionLineItem);
	}

	public ArrayList<TransactionLineItem> getCurrentOrderItems() {
		return currentOrderItems;
	}

	public void clearCart() {
		currentOrderItems.clear();
	}

	public boolean isEmpty() {
		return currentOrderItems.isEmpty();
	}

}
