package com.abstractfactory.pattern;

class Factory {
	public static AbstractFactory getData(String name) {
		if(name.equals("Bank")) return new BankFactory();
		else if(name.equals("Loan")) return new LoanFactory();
		return null;
	}
}
