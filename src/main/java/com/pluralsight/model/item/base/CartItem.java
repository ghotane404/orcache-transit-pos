package com.pluralsight.model.item.base;

import com.pluralsight.model.interfaces.ShoppingItem;

public abstract class CartItem implements ShoppingItem {
	private final String cartItemName;
	private final String cartItemCategory;
	private final int cartItemQuantity;
	private final double cartItemPrice;

	public CartItem(String cartItemName, String cartItemCategory, int cartItemQuantity, double cartItemPrice) {
		this.cartItemName = cartItemName;
		this.cartItemCategory = cartItemCategory;
		this.cartItemQuantity = cartItemQuantity;
		this.cartItemPrice = cartItemPrice;
	}

	public String getCartItemCategory() {
		return cartItemCategory;
	}

	public int getCartItemQuantity() {
		return cartItemQuantity;
	}

	@Override
	public String getName() {
		return cartItemName;
	}

	@Override
	public double getPrice() {
		return cartItemPrice;
	}

//	public double getTotalCartItemPrice() {
//		return cartItemQuantity * cartItemPrice;
//	}
//
//	public int getAddOnQuantity() {
//		int addOnQuantity = cartItemQuantity - 1;
//		return Math.max(addOnQuantity, 0);
//	}

}