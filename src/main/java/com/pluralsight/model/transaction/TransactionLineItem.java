package com.pluralsight.model.transaction;

// for each product/item blah blah in the receipt
public class TransactionLineItem {
	private final String lineItemCategory;
	private final String lineItemName;
	private final String riderCategory;
	private final String baseTransitService;
	private final String fareProduct;
	private final int quantity;
	private final double unitPrice;
	private final double totalPrice;

	public TransactionLineItem(String lineItemCategory, String lineItemName,
	                           String riderCategory, String baseTransitService, String fareProduct,
	                           int quantity, double unitPrice, double totalPrice) {
		this.lineItemCategory = lineItemCategory;
		this.lineItemName = lineItemName;
		this.riderCategory = riderCategory;
		this.baseTransitService = baseTransitService;
		this.fareProduct = fareProduct;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public String getLineItemCategory() {
		return lineItemCategory;
	}

	public String getLineItemName() {
		return lineItemName;
	}

	public String getRiderCategory() {
		return riderCategory;
	}

	public String getBaseTransitService() {
		return baseTransitService;
	}

	public String getFareProduct() {
		return fareProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public String formatForCsv(int receiptId, String date, String time) {
		return String.format("%d|%s|%s|%s|%s|%s|%s|%s|%d|%.2f|%.2f",
				receiptId, date, time,
				lineItemCategory, lineItemName, riderCategory, baseTransitService, fareProduct,
				quantity, unitPrice, totalPrice);
	}

}
