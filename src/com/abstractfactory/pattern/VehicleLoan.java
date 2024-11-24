package com.abstractfactory.pattern;

class VehicleLoan implements Loan {

	@Override
	public int getRateOfInterest(String loan) {
		return 8;
	}
}
