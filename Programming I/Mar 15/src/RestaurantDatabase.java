public class RestaurantDatabase {
    public static void main(String[] args){
        Restaurant a,b,c,d;

        //<editor-fold desc="Restaurant Definitions">
        a = new Restaurant();
        a.setName("A");
        a.setType("Fast Food");
        a.setLocation("India");

        b = new Restaurant();
        b.setName("B");
        b.setType("Sit Down");
        b.setLocation("America");

        c = new Restaurant();
        c.setName("C");
        c.setType("Fine Dining");
        c.setLocation("Antarctica");

        d = new Restaurant();
        d.setName("D");
        d.setType("À la carte");
        d.setLocation("Russia");
        //</editor-fold>

        //Assign c to a
        //a now references Restaurant C
        System.out.println(a.getName());
        System.out.println();
        a = c;
        System.out.println(a.getName());
        System.out.println("\n");

        //Assign d's location to b
        //The location is changed, but nothing else is
        System.out.println(b.getName());
        System.out.println(b.getLocation());
        System.out.println();
        b.setLocation(d.getLocation());
        System.out.println(b.getName());
        System.out.println(b.getLocation());


        /*
        Objects work almost as their own miniature variable storage containers.
        Once the variable is changed, it stays that way just like normal.
         */
    }
}
