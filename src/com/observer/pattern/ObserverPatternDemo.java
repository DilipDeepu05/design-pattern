package com.observer.pattern;

import java.util.ArrayList;
import java.util.List;

//observer interface
interface Observer {
    void update(String weather);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject {
	String weather;
	List<Observer> ls;
	
	WeatherStation() {
		ls = new ArrayList<>();
	}
	
	@Override
	public void addObserver(Observer observer) {
		ls.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		ls.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observe: ls) {
			observe.update(weather);
		}
	}

	public void setWeather(String weather) {
		this.weather = weather;
		notifyObservers();
	}	
}

class Tv implements Observer {
	String weather;
	
	@Override
	public void update(String weather) {
		this.weather = weather;
		display();
	}

	private void display() {
		System.out.println("Tv:Now weather is "+ weather);
	}
}

class Mobile implements Observer {
	String weather;
	
	@Override
	public void update(String weather) {
		this.weather = weather;
		display();
	}

	private void display() {
		System.out.println("Mobile:Now weather is "+ weather);
	}
}

class ObserverPatternDemo {

	public static void main(String[] args) {
		WeatherStation w = new WeatherStation();
		w.addObserver(new Tv());
		w.addObserver(new Mobile());
		
		w.setWeather("Sunny");
	}
}
