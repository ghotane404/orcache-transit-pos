package com.pluralsight.model.item;

import com.pluralsight.model.item.base.CartItem;
import com.pluralsight.model.option.RiderType;

public class FerryPassCartItem extends CartItem {
	private final String ferryPassCartItemName;
	private final double adultPrice;
	private final double seniorPrice;
	private final double youthPrice;

	public FerryPassCartItem(String ferryPassCartItemName, double adultPrice, double seniorPrice, double youthPrice) {
		super("Ferry Pass", "Ferry Pass" , 1 , 0.0 );
		this.ferryPassCartItemName = ferryPassCartItemName;
		this.adultPrice = adultPrice;
		this.seniorPrice = seniorPrice;
		this.youthPrice = youthPrice;
	}

	public String getFerryPassCartItemName() {
		return ferryPassCartItemName;
	}

	public double getAdultPrice() {
		return adultPrice;
	}

	public double getSeniorPrice() {
		return seniorPrice;
	}

	public double getYouthPrice() {
		return youthPrice;
	}

	public double getPriceFor(RiderType riderType){
		if (riderType.getName().trim().equalsIgnoreCase("Adult")) {
			return adultPrice;
		}

		else if (riderType.getName().trim().equalsIgnoreCase("Senior")) {
			return seniorPrice;
		}

		else if (riderType.getName().trim().equalsIgnoreCase("Youth")) {
			return youthPrice;
		}
		return 0.00;
	}

}






