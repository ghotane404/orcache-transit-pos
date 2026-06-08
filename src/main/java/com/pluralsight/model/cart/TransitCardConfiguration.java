package com.pluralsight.model.cart;

import com.pluralsight.model.item.FerryPassCartItem;
import com.pluralsight.model.option.*;

import java.util.ArrayList;

// using a Temporary builder to sorta replace enum ugh
// *use it inside TransitCardMenu to get user selections before constructing into TransitCardCartItem from the flow chart
public class TransitCardConfiguration {
	private TransitCard eTransitCard;
	private RiderType eRiderType;
	private AddOn eAddOn;
	private FerryPassCartItem eFerryPass;

	private final ArrayList<AccountBenefit> eAccountBenefits = new ArrayList<>();
	private final ArrayList<CardDesign> eCardDesigns = new ArrayList<>();
	private ArrayList<LimeVoucher> eLimeVouchers = new ArrayList<>();

	// -------------------------- Transit Service --------------------------
	public TransitCard getETransitService() {
		return eTransitCard;
	}

	public void getETransitCard(TransitCard eTransitCard) {
		this.eTransitCard = eTransitCard;
	}

	// -------------------------- Rider Type --------------------------
	public RiderType getERiderType() {
		return eRiderType;
	}

	public void setERiderType(RiderType eRiderType) {
		this.eRiderType = eRiderType;
	}

	// -------------------------- Transit Add-On --------------------------
	public AddOn getEAddOn() {
		return eAddOn;
	}

	public void setEAddOn(AddOn eAddOn) {
		this.eAddOn = eAddOn;
	}

	// -------------------------- Ferry Pass --------------------------
	public FerryPassCartItem getEFerryPass() {
		return eFerryPass;
	}

	public void setEFerryPass(FerryPassCartItem eFerryPass) {
		this.eFerryPass = eFerryPass;
	}

	// -------------------------- Account Benefits --------------------------
	public ArrayList<AccountBenefit> eAccountBenefits() {
		return eAccountBenefits;
	}

	// -------------------------- Card Designs --------------------------
	public ArrayList<CardDesign> getECardDesigns() {
		return eCardDesigns;
	}


	// -------------------------- Lime Vouchers --------------------------
	public ArrayList<LimeVoucher> getELimeVouchers() {
		return eLimeVouchers;
	}

	public void setELimeVouchers(ArrayList<LimeVoucher> eLimeVouchers) {
		this.eLimeVouchers = eLimeVouchers;
	}


}
