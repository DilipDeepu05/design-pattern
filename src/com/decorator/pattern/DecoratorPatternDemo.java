package com.decorator.pattern;

//component
interface Coffee {
	String getDescription();
	double getCost();
}

//concreteClass
class PlainCoffee implements Coffee {

	@Override
	public String getDescription() {
		return "Plain coffee";
	}

	@Override
	public double getCost() {
		return 15.0;
	}
}

//decorator class
abstract class CoffeeDecorator implements Coffee {
	Coffee coffee;
	
	CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription();
	}

	@Override
	public double getCost() {
		return coffee.getCost();
	}
}

class MilkDecorator extends CoffeeDecorator {

	MilkDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription() {
		return coffee.getDescription() + " Milk";
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 50.0;
	}
}

class CreamDecorator extends CoffeeDecorator {

	CreamDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription() {
		return coffee.getDescription() + " Cream";
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 100.0;
	}
}

class DecoratorPatternDemo {

	public static void main(String[] args) {
		Coffee c1 = new PlainCoffee();
		System.out.println(c1.getDescription() + " costs "+ c1.getCost());
		
		Coffee c2 = new MilkDecorator(c1);
		System.out.println(c2.getDescription() + " costs "+ c2.getCost());
		
		Coffee c3 = new CreamDecorator(c2);
		System.out.println(c3.getDescription() + " costs "+ c3.getCost());
	}
}
