import edu.lvc.cds.menus.MenuItem;

public class MItem2 extends MenuItem {

	public MItem2(String name) {
		super(name);
	}

	@Override
	public void perform() {
		System.out.println("Option 2 selected");
	}

}
