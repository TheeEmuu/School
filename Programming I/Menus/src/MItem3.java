import edu.lvc.cds.menus.MenuItem;

public class MItem3 extends MenuItem {

	public MItem3(String name) {
		super(name);
	}

	@Override
	public void perform() {
		System.out.println("Option 3 selected");
	}

}
