package com.factory.pattern;

abstract class Bank {
	
	protected double rate;  

	abstract void getRateOfInterest();
	
	 public void calculateLoanAmount(int units){  
         System.out.println(units + units - (units * rate));  
     }  
}

class icicibank extends Bank {

	@Override
	void getRateOfInterest() {
		rate = 0.98;
	}
}

class sbiBank extends Bank {

	@Override
	void getRateOfInterest() {
		rate = 0.88;
	}
}

class BankFactory {
	
	public Bank getBankLoanAmount(String bankName) {
		if(bankName.equals("SBI")) return new sbiBank();
		else if(bankName.equals("icici")) return new icicibank();
		else return null;
	}
}

class Demo {

	public static void main(String[] args) {
		BankFactory bankFactory = new BankFactory();
		
		Bank bank = bankFactory.getBankLoanAmount("SBI");
		
		bank.getRateOfInterest();
		System.out.println("Interest rate at SBI "+ bank.rate);
		System.out.println("Request amount 10k");
		bank.calculateLoanAmount(10000);
	}
}
