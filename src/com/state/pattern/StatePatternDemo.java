package com.state.pattern;

interface VendingMachineState {
	void handleRequest();
}

class ReadyState implements VendingMachineState {

	@Override
	public void handleRequest() {
		System.out.println("Ready state: please select the product");
	}
}

class ProductSelectedState implements VendingMachineState {

	@Override
	public void handleRequest() {
		System.out.println("Product selected state: selected the product");
	}
}


class PaymentState implements VendingMachineState {

	@Override
	public void handleRequest() {
		System.out.println("Payment state: payment for the product is completed");
	}
}

class VendingMachineContext {
	VendingMachineState state;
	
    public void setState(VendingMachineState state) {
        this.state = state;
        request();
    }

    public void request() {
        state.handleRequest();
    }
}
public class StatePatternDemo {

	public static void main(String[] args) {
		VendingMachineContext vm = new VendingMachineContext();
		vm.setState(new ReadyState());
		vm.setState(new ProductSelectedState());
		vm.setState(new PaymentState());
	}
}
