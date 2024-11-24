package com.prototype;

interface Prototype {
	Prototype getClone();
}

class Employee implements Prototype {
	
	int id;
	String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public Prototype getClone() {
		return new Employee(this.id, this.name);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}

class Demo {

	public static void main(String[] args) {
		Employee e = new Employee(1, "Testing");
		System.out.println(e);
		Employee e1 = (Employee) e.getClone();
		System.out.println(e1);
	}
}
