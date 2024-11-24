package com.abstractfactory.pattern;

abstract class AbstractFactory {
	abstract Bank getName(String bankName);
	abstract Loan getRateOfInterest(String loan);
}
