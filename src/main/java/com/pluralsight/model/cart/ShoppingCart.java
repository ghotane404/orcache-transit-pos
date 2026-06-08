package com.pluralsight.model.cart;

import com.pluralsight.model.item.base.CartItem;
import java.util.*;

public class ShoppingCart {
	private final ArrayList<CartItem> currentOrderItems = new ArrayList<>();

	public void addItem(CartItem cartItem) {
		currentOrderItems.add(cartItem);
	}

	public ArrayList<CartItem> getCurrentOrderItems() {
		return currentOrderItems;
	}

	public void clearCart() {
		currentOrderItems.clear();
	}

	public boolean isEmpty() {
		return currentOrderItems.isEmpty();
	}

}
