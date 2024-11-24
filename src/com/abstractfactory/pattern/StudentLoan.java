package com.abstractfactory.pattern;

class StudentLoan implements Loan {

	@Override
	public int getRateOfInterest(String loan) {
		return 4;
	}
}
