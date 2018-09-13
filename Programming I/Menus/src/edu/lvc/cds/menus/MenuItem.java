package edu.lvc.cds.menus;

public abstract class MenuItem {
	private String name;
	
	public MenuItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public abstract void perform();
}
