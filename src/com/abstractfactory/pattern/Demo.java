package com.abstractfactory.pattern;

class Demo {

	public static void main(String[] args) {
		BankFactory bank = (BankFactory) Factory.getData("Bank");
		System.out.println(bank.getName("SBI").getName());
	}
}
