package com.command.pattern;

interface ActionListenerCommand {
	void execute();
}

class Document {
	void open() {
		System.out.println("Document opened");
	}
	
	void close() {
		System.out.println("Document closed");
	}
}

class ActionOpenCommand implements ActionListenerCommand {
	Document d; 
	
	public ActionOpenCommand(Document d) {
		this.d = d;
	}
	
	@Override
	public void execute() {
		this.d.open();
	}
}


class ActionCloseCommand implements ActionListenerCommand {
	Document d; 
	
	public ActionCloseCommand(Document d) {
		this.d = d;
	}
	
	@Override
	public void execute() {
		this.d.close();
	}
}

class MenuOptions {
	ActionListenerCommand command;
	
	MenuOptions(ActionListenerCommand command) {
		this.command = command;
	}
	
	public void execute() {
		this.command.execute();
	}
}

class CommandPatternDemo {

	public static void main(String[] args) {
		MenuOptions m = new MenuOptions(new ActionCloseCommand(new Document()));
		m.execute();
	}
}
