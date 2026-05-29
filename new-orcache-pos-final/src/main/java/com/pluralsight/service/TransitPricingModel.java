package com.pluralsight.service;

import com.pluralsight.model.option.*;

public class TransitPricingModel {
	public static double getTransitPassPrice(RiderType riderType){
		return switch(riderType){
			case ADULT -> 3.00;
			case SENIOR -> 1.00;
			case YOUTH -> 2.00;
		};
	}

	public static double getAddOnTransitPrice(TransitPassAddOn transitAddOnPrice, RiderType riderType){
		return switch (transitAddOnPrice) {
			case ALL_DAY_PASS -> switch (riderType) {
				case ADULT -> 6.00;
				case SENIOR -> 2.00;
				case YOUTH -> 3.75;
			};
			case MONTHLY_PASS -> switch (riderType) {
				case ADULT -> 108.00;
				case SENIOR -> 36.00;
				case YOUTH -> 50.00;
			};
			case SEVEN_DAY_PASS-> switch (riderType) {
				case ADULT -> 90.00;
				case SENIOR -> 70.00;
				case YOUTH -> 80.00;
			};
			case NO_ADD_ON -> 0.00;
		};

	}


	public static double getAddOnFerryPrice(FerryPassAddOn ferryPassAddOn, RiderType riderType){
		return switch (ferryPassAddOn){
			case WSF_MUKILTEO_CLINTON -> switch (riderType) {
				case ADULT -> 6.00;
				case SENIOR -> 3.00;
				case YOUTH -> 4.00;
			};
			case WSF_VASHON_ISLAND -> switch (riderType) {
				case ADULT -> 6.50;
				case SENIOR -> 3.25;
				case YOUTH -> 4.50;
			};
			case WSF_FAUNTLEROY_SOUTHWORTH -> switch (riderType) {
				case ADULT -> 7.50;
				case SENIOR -> 3.25;
				case YOUTH -> 5.00;
			};
			case WSF_PORT_TOWNSEND_COUPEVILLE -> switch (riderType) {
				case ADULT -> 8.50;
				case SENIOR -> 4.25;
				case YOUTH -> 6.00;
			};
			case WSF_CENTRAL_SOUND -> switch (riderType) {
				case ADULT -> 12.00;
				case SENIOR -> 6.00;
				case YOUTH -> 8.50;
			};
		};
	}

	public static double getDiscountMultiplier(RiderType riderType){
		return switch (riderType){
				case ADULT -> 1 - .15;
				case SENIOR -> 1 - .3;
				case YOUTH -> 1 - .25;
		};
	}

	public static double getEpurseBalance(EPurseReloadOption ePurseReloadOption){
		return switch (ePurseReloadOption) {
			case ADD_FIVE -> 5.00;
			case ADD_TEN -> 10.00;
			case ADD_FIFTEEN -> 15.00;
			case ADD_TWENTY ->  20.00;
		};

	}

	public static double getRetailAccessoryPrice(RetailAccessory retailAccessory, RetailTier retailTier) {
		return switch (retailAccessory) {
			case CARD_WALLET_HOLDER, PROTECTIVE_CARD_SLEEVE -> switch (retailTier) {
				case BASIC -> 4.00;
				case STANDARD -> 5.00;
				case PREMIUM -> 6.00;
			};
			case LANYARD_WITH_BREAKAWAY, RFID_BLOCKING_CARD_HOLDER -> switch (retailTier) {
				case BASIC -> 8.00;
				case STANDARD -> 10.00;
				case PREMIUM -> 12.00;
			};
		};
	}


	public static double getRetailAccessoryPrice(RetailAccessory selectedAccessory) {
		return 0;
	}
}




