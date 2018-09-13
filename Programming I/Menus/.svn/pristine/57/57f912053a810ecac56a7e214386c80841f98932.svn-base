import edu.lvc.cds.menus.Menu;
import edu.lvc.cds.menus.MenuItem;

public class Application {
	// currently unused, simply here to exhibit that applications can have system-wide data,
	// stored here and initialized on construction
	private String restaurant;
	
	public Application(String name) {
		this.restaurant = name;
	}

	// methods this application uses to do its work.

	public void run() {
		// create, display and execute a menu of options.
		Menu menu = new Menu();
		
//		MItem1 item1 = new MItem1("option 1");
//		MItem2 item2 = new MItem2("option 2");
//		MItem3 item3 = new MItem3("option 3");
		
		menu.addItem(new MenuItem("Option 1") {
			@Override
			public void perform(){
				System.out.println("Option 1 selected");
			}
		});
		menu.addItem(new MenuItem("Option 2") {
			@Override
			public void perform() {
				System.out.println("Option 2 selected");
			}
		});
		menu.addItem(new MenuItem("Option 3") {
			@Override
			public void perform(){
				System.out.println("Option 3 selected");
			}
		});

		// add items to the menu, then present it.
		menu.presentRepeatedly();
	}
	
	
}
