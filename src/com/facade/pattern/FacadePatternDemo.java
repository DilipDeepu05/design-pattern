package com.facade.pattern;

interface Hotel {
	Menu getMenus();
}

interface Menu {
	String getMenus();
}

class VegMenu implements Menu {
	
	@Override
	public String getMenus() {
		return "All are veg items";
	}
}

class VegHotel implements Hotel {
	
	@Override
	public Menu getMenus() {
		return new VegMenu();
	}
}

class NonVegMenu implements Menu {
	@Override
	public String getMenus() {
		return "All are nonveg items";
	}
}

class NonVegHotel implements Hotel {
	@Override
	public Menu getMenus() {
		return new NonVegMenu();
	}
}

interface HotelMenu {
	VegMenu getVegMenu();
	NonVegMenu getNonVegMenu();
}

class HotelManager implements HotelMenu {

	@Override
	public VegMenu getVegMenu() {
		return (VegMenu) new VegHotel().getMenus();
	}

	@Override
	public NonVegMenu getNonVegMenu() {
		return (NonVegMenu) new NonVegHotel().getMenus();
	}
}

public class FacadePatternDemo {

	public static void main(String[] args) {
		HotelManager hm = new HotelManager();
		
		VegMenu v = hm.getVegMenu();
		System.out.println(v.getMenus());
		
		NonVegMenu n = hm.getNonVegMenu();
		System.out.println(n.getMenus());
	}
}
