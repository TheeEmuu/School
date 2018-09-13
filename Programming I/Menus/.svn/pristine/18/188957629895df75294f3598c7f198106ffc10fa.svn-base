package edu.lvc.cds.menus;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	// some sort of list of items?
	private ArrayList<MenuItem> items;
	
	/**
	 * Initialize a menu, a numbered list of options and associated methods to run
	 */
	public Menu() {
		items = new ArrayList<MenuItem>();
	}
	
	/**
	 * add an item to this menu.
	 */
	public void addItem(MenuItem item) {
		items.add(item);
	}
	
	/**
	 * Display the menu to the user, prompt for a selection, execute the corresponding
	 * method, and return.  Does not display 
	 */
	public void presentOnce() {
		printMenu(false);

		int choice = getChoice(1, items.size());
		
		MenuItem item = items.get(choice-1);
		item.perform();
		
	}
	/**
	 * Display the menu with a "Quit" option at the end.  If the user selects Quit, 
	 * return.  Otherwise, do the user's selection and then present the menu again.
	 */
	public void presentRepeatedly() {
		while (true) {
			printMenu(true);
			int choice = getChoice(1, items.size()+1);
			if (choice == items.size() + 1)
				break;
			
			MenuItem item = items.get(choice-1);
			item.perform();
		}
	}
	
	private void printMenu(boolean hasQuit) {
		System.out.println();
		
		for (int i=0; i < items.size(); ++i) {
			MenuItem item = items.get(i);
			System.out.println((i+1) + ": " + item.getName());
		}
		if (hasQuit) {
			System.out.println((items.size()+1) + ": Quit menu.");
		}
	}
	
	private int getChoice(int low, int high) {
		Scanner in = new Scanner(System.in);
		int choice = 0; 
		
		System.out.println();
		while (true) {
			System.out.print("Please enter your selection (" + low + " -- " + high + "): ");
			choice = in.nextInt();
			if (choice >= low  && choice <= high)
				break;
			
			System.out.println("Sorry, that choice is invalid.  Please try again.\n\n");
		}

		return choice;
	}

	
}
