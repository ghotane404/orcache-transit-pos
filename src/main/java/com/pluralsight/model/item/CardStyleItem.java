package com.pluralsight.model.item;

import com.pluralsight.model.enums.CardDesignOption;
import com.pluralsight.model.enums.LineItemCategory;
import com.pluralsight.model.item.base.TransactionLineItem;

public class CardStyleItem extends TransactionLineItem {
	private CardDesignOption cardDesignOption;
	private int quantity;

	public CardStyleItem(CardDesignOption cardDesignOption, int quantity) {
		super(LineItemCategory.CARD_STYLE.getDisplayName(), cardDesignOption.getDisplayName(), quantity, 0.00);

		this.cardDesignOption = cardDesignOption;
		this.quantity = quantity;

	}

	public CardDesignOption cardDesignOption() {
		return cardDesignOption;
	}

	public int getQuantity() {
		return quantity;
	}

}
