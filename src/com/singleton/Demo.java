package com.singleton;

class Testing {
	static Testing t;
	private Testing() {};
	
	static Testing getTesting() {
		if(t == null) {
			t = new Testing();
		}
		return t;
	}
}

class Demo {

	public static void main(String[] args) {
		System.out.println(Testing.getTesting());
		System.out.println(Testing.getTesting());
		System.out.println(Testing.getTesting());
	}
}
