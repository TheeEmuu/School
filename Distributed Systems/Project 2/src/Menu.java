import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static FrontClient front;

    public static void main(String[] args){
        //front = new FrontClient("lyn182-03", 6969);
        try {
            Scanner fileIn = new Scanner(new File("/home/LVC/ejj001/Programming/Distributed Systems/Project 2/src/server information"));
            String ip = fileIn.nextLine();
            int port = Integer.parseInt(fileIn.nextLine());
            System.out.println(ip + " " + port);
            front = new FrontClient(ip, port);
        }catch(Exception e){
            front = new FrontClient("127.0.0.1", 6969);
        }


        ArrayList<ArrayList<String>> a = front.getItems(null);

        menu(a);

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("What method would you like to call?");
            System.out.print("getitems, purchase, or restock: ");
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

            menu(a);
        }
    }

    private static void menu(ArrayList<ArrayList<String>> items) {
        try{
            if(items.get(0).get(0).isEmpty()){

                System.out.println("Item restocked");
            }
            else {
                Double i = Double.parseDouble(items.get(0).get(0));

                System.out.println("The purchase cost: $" + i);
            }
        }
        catch(NumberFormatException e){
            try {
                items.get(0).get(1);

                System.out.println("-------Company-------\n");
                for (ArrayList<String> item : items) {
                    System.out.printf("%s   %s---------------------%s\n", item.get(0), item.get(1), item.get(2));
                }
            }
            catch(IndexOutOfBoundsException a){
            }
        }
    }
}
