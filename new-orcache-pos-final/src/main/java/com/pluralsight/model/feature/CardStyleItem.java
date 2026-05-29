package com.pluralsight.model.feature;

import com.pluralsight.model.option.CardDesignOption;
import com.pluralsight.model.option.LineItemCategory;
import com.pluralsight.model.service.TransactionLineItem;

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
