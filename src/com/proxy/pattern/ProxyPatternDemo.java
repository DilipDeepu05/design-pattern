package com.proxy.pattern;

interface Image {
	void display();
}

class RealImage implements Image {
	String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Display "+ this.fileName);
	}
}

class ProxyImage implements Image {
	RealImage realImage;
	String fileName;
	
	ProxyImage(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void display() {
		if(realImage == null) {
			realImage = new RealImage(fileName);
		} else {
			System.out.println();
			System.out.println("proxied");
		}
		realImage.display();
	}
	
}
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image i = new ProxyImage("Developer");
		i.display();
		i.display();
	}
}
