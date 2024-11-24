package com.chainofresponsibility.pattern;

interface SupportHandler {
	void handleRequst(Request request);
	void nextHandler(SupportHandler supportHandler);
}

enum Prority {
	Simple, Medium, Critical
}

class Request {
	Prority prority;

	public Prority getPrority() {
		return prority;
	}

	public void setPrority(Prority prority) {
		this.prority = prority;
	}
}

class Level1Handler implements SupportHandler {
	SupportHandler supportHandler;

	@Override
	public void handleRequst(Request request) {
		if(request.getPrority().equals(Prority.Simple)) {
			System.out.println("Handling simple request");
		} else {
			supportHandler.handleRequst(request);
		}
	}

	@Override
	public void nextHandler(SupportHandler supportHandler) {
		this.supportHandler = supportHandler;
	}
}

class Level2Handler implements SupportHandler {
	SupportHandler supportHandler;

	@Override
	public void handleRequst(Request request) {
		if(request.getPrority().equals(Prority.Medium)) {
			System.out.println("Handling medium request");
		} else {
			supportHandler.handleRequst(request);
		}
	}

	@Override
	public void nextHandler(SupportHandler supportHandler) {
		this.supportHandler = supportHandler;
	}
}

class Level3Handler implements SupportHandler {
	SupportHandler supportHandler;

	@Override
	public void handleRequst(Request request) {
		if(request.getPrority().equals(Prority.Critical)) {
			System.out.println("Handling critical request");
		} else {
			supportHandler.handleRequst(request);
		}
	}

	@Override
	public void nextHandler(SupportHandler supportHandler) {
	//	this.supportHandler.nextHandler(supportHandler);
	}
}

class ChainOfResponsibilityPatternDemo {
	public static void main(String[] agrs) {
		SupportHandler l1 = new Level1Handler();
		SupportHandler l2 = new Level2Handler();
		SupportHandler l3 = new Level3Handler();
		
		l1.nextHandler(l2);
		l2.nextHandler(l3);
		
		Request r = new Request();
		r.setPrority(Prority.Critical);
		l1.handleRequst(r);
	}
}
