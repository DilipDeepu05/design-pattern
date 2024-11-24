package com.flyweight.pattern;

import java.util.HashMap;
import java.util.Map;

//component
interface Icon {
	void draw(int x, int y); 
}

//Concrete Flyweight class
class FileIcon implements Icon {
	private String type;
	private String imageName;

	public FileIcon(String type, String imageName) {
		this.type = type;
		this.imageName = imageName;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing " + type + " icon with image " + imageName + " at position (" + x + ", " + y + ")");
	}
}

// Concrete Flyweight class
class FolderIcon implements Icon {
	private String color;
	private String imageName;

	public FolderIcon(String color, String imageName) {
		this.color = color;
		this.imageName = imageName;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing folder icon with color " + color + " and image " + imageName + " at position (" + x + ", " + y + ")");
	}
}

class IconFactory {
	Map<String, Icon> m;
	
	IconFactory() {
		m = new HashMap<>();
	}
	
	public Icon getIconFactory(String key) {
		if(this.m.containsKey(key)) {
			return this.m.get(key);
		} 
		
		Icon i;
		if(key.equalsIgnoreCase("File")) {
			i = new FileIcon("document", "doc.png");
		} else {
			i = new FolderIcon("file", "blue.png");
		}
		this.m.put(key, i);
		return i;
	}
}

class FlyweightPatternDemo {

	public static void main(String[] args) {
		IconFactory i = new IconFactory();
		
		Icon f = i.getIconFactory("File");
		f.draw(100, 100);
		
		Icon f1 = i.getIconFactory("File");
		f1.draw(200, 200);		
	}
}
