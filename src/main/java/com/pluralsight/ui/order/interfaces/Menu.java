package com.pluralsight.ui.order.interfaces;

import com.pluralsight.model.item.base.TransactionLineItem;
import java.util.ArrayList;

public interface Menu {
	void display(ArrayList<TransactionLineItem> currentOrderItems);

	String showMenuName();

}
