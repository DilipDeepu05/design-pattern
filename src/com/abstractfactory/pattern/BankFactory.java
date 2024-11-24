package com.abstractfactory.pattern;

class BankFactory extends AbstractFactory {

	@Override
	Bank getName(String bankName) {
		if(bankName.equals("SBI")) return new SbiBank();
		else if(bankName.equals("icici")) return new IciciBank();
		else return null;
	}

	@Override
	Loan getRateOfInterest(String loan) {
		return null;
	}

}
