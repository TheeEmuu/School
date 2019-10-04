import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static FrontClient front;

    public static void main(String[] args){
        try {
            Scanner fileIn = new Scanner(new File("server information"));
            String ip = fileIn.nextLine();
            int port = Integer.parseInt(fileIn.nextLine());
            front = new FrontClient(ip, port);
        }catch(Exception e){
            front = new FrontClient("127.0.0.1", 6969);
        }


        ArrayList<ArrayList<String>> a = front.getItems(null);

        menu(a);

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("What method would you like to call?");
            System.out.print("getitems, purchase, or restock");
            String method = in.nextLine();
            System.out.println();
            System.out.println("Please input parameters separated by spaces: ");
            if(method.toLowerCase().equals("getitems"))
                System.out.print("filter: ");
            else
                System.out.print("item, quantity: ");
            String p = in.nextLine();

            List<String> params = Arrays.asList(p.split(" "));

            a = front.run(method, params);

//            System.out.println(a);
            menu(a);
        }
    }

    private static void menu(ArrayList<ArrayList<String>> items) {
        try{
            int i = Integer.parseInt(items.get(0).get(0));

            System.out.println("The purchase cost: $" + i);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Item restocked");
        }
        catch(NumberFormatException e){
            System.out.println("-------Company-------\n");
            for (ArrayList<String> item : items) {
                System.out.printf("%s   %s---------------------%s\n", item.get(0), item.get(1), item.get(2));
            }
        }
    }
}
