package com.bridge.pattern;

interface Workshop {
	void work();
}

class Production implements Workshop {

	@Override
	public void work() {
		System.out.print("Produced ");
	}
}

class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.print("Assembled ");
	}

}

abstract class Vehicle {
	Workshop w1;
	Workshop w2;
	
	protected Vehicle(Workshop w1, Workshop w2) {
		this.w1 = w1;
		this.w2 = w2;
	}
	
	abstract void getManufactor();
}

class WithGearTwoWheeler extends Vehicle {
	Workshop w1;
	Workshop w2;

	protected WithGearTwoWheeler(Workshop w1, Workshop w2) {
		super(w1, w2);
		this.w1 = w1;
		this.w2 = w2;
	}

	@Override
	void getManufactor() {
		w1.work();
		w2.work();
		System.out.print("With gear two wheeler vehicle");
		System.out.println();
	}
}

class WithOutGearTwoWheeler extends Vehicle {
	Workshop w1;
	Workshop w2;

	protected WithOutGearTwoWheeler(Workshop w1, Workshop w2) {
		super(w1, w2);
		this.w1 = w1;
		this.w2 = w2;
	}

	@Override
	void getManufactor() {
		w1.work();
		w2.work();
		System.out.print("Without gear two wheeler vehicle");
		System.out.println();
	}
}

class Demo {

	public static void main(String[] args) {
		Vehicle v1 = new WithOutGearTwoWheeler(new Production(), new Assemble());
		v1.getManufactor();
		
		Vehicle v2 = new WithGearTwoWheeler(new Production(), new Assemble());
		v2.getManufactor();
	}
}