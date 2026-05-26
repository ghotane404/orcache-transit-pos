package com.pluralsight.service;

import com.pluralsight.model.option.BaseTransitServiceType;
import com.pluralsight.model.option.RiderCategory;
import com.pluralsight.model.option.TransitPassAddOn;

//FareCalculationService
//calculates fare prices
public class FareCalculationService {
	public static double getBaseFarePrice(BaseTransitServiceType serviceType, RiderCategory riderCategory) {
		return switch (riderCategory) {
			case ADULT -> serviceType.getAdultPrice();
			case YOUTH ->  serviceType.getYouthPrice();
			case SENIOR -> serviceType.getSeniorPrice();
		};
	}

	public static double getTransitPassAddOnPrice(TransitPassAddOn passAddOn, RiderCategory riderCategory){
		return switch (riderCategory) {
			case ADULT ->  passAddOn.getAdultPrice();
			case SENIOR ->  passAddOn.getSeniorPrice();
			case YOUTH ->  passAddOn.getYouthPrice();
		};
	}

	public static double calculateTransitCardTotal(TransitPassAddOn passAddOn, RiderCategory riderCategory) {
		return getTransitPassAddOnPrice(passAddOn, riderCategory);
	}

}
