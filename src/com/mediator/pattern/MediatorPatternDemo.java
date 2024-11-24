package com.mediator.pattern;

interface Airplane {
	void requestTakeoff();
	void requestLanding();
	void notifyAirTrafficControl(String message);
}

class CommmericalAirplane implements Airplane {
	
	 AirplaneTrafficTower tower;
	
	CommmericalAirplane(AirplaneTrafficTower tower) {
		this.tower = tower;
	}

	@Override
	public void requestTakeoff() {
		this.tower.requestTakeOff(this);
	}

	@Override
	public void requestLanding() {
		this.tower.requestLanding(this);
	}

	@Override
	public void notifyAirTrafficControl(String message) {
		System.out.println("commerical : " + message);
	}	
}

//mediator
interface AirplaneTrafficTower {
	void requestLanding(Airplane a);
	void requestTakeOff(Airplane a);
}

//concrete mediator class
class AirplaneControlTower implements  AirplaneTrafficTower {

	@Override
	public void requestLanding(Airplane a) {
		a.notifyAirTrafficControl("Requesting landing");
	}

	@Override
	public void requestTakeOff(Airplane a) {
		a.notifyAirTrafficControl("Requesting take off");
	}
	
}

class MediatorPatternDemo {

	public static void main(String[] args) {
		 AirplaneTrafficTower a = new AirplaneControlTower();
		 Airplane ca = new  CommmericalAirplane(a);
		 ca.requestLanding();
	}
}
