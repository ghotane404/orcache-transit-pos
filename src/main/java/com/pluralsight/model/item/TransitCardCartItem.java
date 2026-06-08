package com.pluralsight.model.item;

import com.pluralsight.model.item.base.CartItem;
import com.pluralsight.model.option.RiderType;
import com.pluralsight.model.option.AccountBenefit;
import com.pluralsight.model.option.AddOn;
import com.pluralsight.model.option.CardDesign;
import com.pluralsight.model.option.LimeVoucher;

import java.util.ArrayList;
// contains the chocies from the transitcardconfi

public class TransitCardCartItem extends CartItem {
	private final int selectedRiderTypeQuantity;
	private final int selectedTransitAddOnQuantity;
	private final int selectedFerryAddOnQuantity;

	private final RiderType selectedRiderType;
	private final AddOn selectedAddOn;
	private final FerryPassCartItem selectedFerryPassCartItem;

	private final ArrayList<AccountBenefit> selectedAccountBenefits;
	private final ArrayList<CardDesign> selectedCardDesigns;
	private final ArrayList<LimeVoucher> selectedLimeVouchers;

	public TransitCardCartItem(RiderType selectedRiderType, int selectedRiderTypeQuantity,
	                           AddOn selectedAddOn, int selectedTransitAddOnQuantity,
	                           FerryPassCartItem selectedFerryPassCartItem, int selectedFerryAddOnQuantity,
	                           ArrayList<AccountBenefit> selectedAccountBenefits,
	                           ArrayList<CardDesign> selectedCardDesigns,
	                           ArrayList<LimeVoucher> selectedLimeVouchers) {
		super("OrCache Transit Card", "Transit", selectedRiderTypeQuantity, selectedRiderType.getPrice());
		this.selectedRiderType = selectedRiderType;
		this.selectedRiderTypeQuantity = selectedRiderTypeQuantity;
		this.selectedAddOn = selectedAddOn;
		this.selectedTransitAddOnQuantity = selectedTransitAddOnQuantity;
		this.selectedFerryPassCartItem = selectedFerryPassCartItem;
		this.selectedFerryAddOnQuantity = selectedFerryAddOnQuantity;
		this.selectedAccountBenefits = selectedAccountBenefits;
		this.selectedCardDesigns = selectedCardDesigns;
		this.selectedLimeVouchers = selectedLimeVouchers;
	}

	public int getRiderTypeQuantity() {
		return selectedRiderTypeQuantity;
	}

	public int getTransitAddOnQuantity() {
		return selectedTransitAddOnQuantity;
	}

	public int getSelectedFerryAddOnQuantity() {
		return selectedFerryAddOnQuantity;
	}

	public RiderType getSelectedRiderType() {
		return selectedRiderType;
	}

	public AddOn getSelectedAddOn() {
		return selectedAddOn;
	}

	public FerryPassCartItem getSelectedFerryPassCartItem() {
		return selectedFerryPassCartItem;
	}

	public ArrayList<AccountBenefit> getSelectedAccountBenefits() {
		return selectedAccountBenefits;
	}

	public ArrayList<CardDesign> getSelectedCardDesigns() {
		return selectedCardDesigns;
	}

	public ArrayList<LimeVoucher> getSelectedLimeVouchers() {
		return selectedLimeVouchers;
	}

}
