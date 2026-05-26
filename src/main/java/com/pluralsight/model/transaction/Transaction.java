package com.pluralsight.model.transaction;

import java.util.*;

// making completed receipt/order
public class Transaction {
	private int receiptId;
	private String date;
	private String time;
	private ArrayList<TransactionLineItem> lineItems;

	public Transaction(int receiptId, String date, String time, ArrayList<TransactionLineItem> lineItems) {
		this.receiptId = receiptId;
		this.date = date;
		this.time = time;
		this.lineItems = lineItems;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public ArrayList<TransactionLineItem> getLineItems() {
		return lineItems;
	}

	// calculates the grandtotal for the receipt
	public double calculateGrandTotal() {
		double grandTotal = 0;

		for (TransactionLineItem lineItem : lineItems) {
			grandTotal += lineItem.getTotalPrice();
		}

		return grandTotal;
	}

}
