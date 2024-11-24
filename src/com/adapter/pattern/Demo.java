package com.adapter.pattern;

interface CreditCard {
	void giveBankDetails();
	String getCreditCardNumber();
}

class BankDetail {
	String bankName;
	String cardNumber;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}

class CustomerBankDetails extends BankDetail implements CreditCard {

	@Override
	public String getCreditCardNumber() {
		return getCardNumber();
	}

	@Override
	public void giveBankDetails() {
		setBankName("sbi");
		setCardNumber("005");
	}
}

class Demo {

	public static void main(String[] args) {
		CreditCard targetInterface = new CustomerBankDetails();
		targetInterface.giveBankDetails();
		System.out.println(targetInterface.getCreditCardNumber());
	}
}
