package com.abstractfactory.pattern;

class LoanFactory extends AbstractFactory {

	@Override
	Bank getName(String name) {
		return null;
	}

	@Override
	Loan getRateOfInterest(String loan) {
		if(loan.equals("Vehicle")) return new VehicleLoan();
		else if(loan.equals("Student")) return new StudentLoan();
		return null;
	}
}
