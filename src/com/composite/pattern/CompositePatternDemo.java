package com.composite.pattern;

import java.util.ArrayList;
import java.util.List;

//component
interface Task {
	String getTitle();
	void setTitle(String title);
	void display();
}

//leaf
class SimpleTask implements Task {

	String title;

	public SimpleTask(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void display() {
		System.out.println("It's a Simple task" + this.title);
	}
}

//composite
class TaskList implements Task {
	String title;
	List<Task> ls;

	public TaskList(String title) {
		ls = new ArrayList<>();
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public void add(Task t) {
		ls.add(t);
	}

	@Override
	public void display() {
		System.out.println("Tasks of "+ this.title);
		for(Task t: ls) {
			System.out.println(t.getTitle());
		}
	}
}

//client
class CompositePatternDemo {

	public static void main(String[] args) {
		Task t1 = new SimpleTask("Reading");
		Task t2 = new SimpleTask("Writing");

		TaskList tm = new TaskList("Java");
		tm.add(t1);
		tm.add(t2);

		tm.display();
	}
}
