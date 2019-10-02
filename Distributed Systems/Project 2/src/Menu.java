import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static FrontClient front;
    String filter;

    public static void main(String[] args){
        front = new FrontClient("10.1.23.64", 6969);

        ArrayList<ArrayList<String>> a = front.getItems(null);
        menu(a);

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("What method would you like to call: ");
            String method = in.nextLine();
            System.out.println();
            System.out.print("Please input parameters separated by spaces: ");
            String p = in.nextLine();

            List<String> params = Arrays.asList(p.split(" "));

            a = front.run(method, params);

//            System.out.println(a);
            menu(a);
        }
    }

    private static void menu(ArrayList<ArrayList<String>> items) {
        for(int i = 0; i < 50; i++);

        if (items != null) {
            System.out.println("-------Company-------\n");
            /*
            for (ArrayList<String> item : items) {
                System.out.printf("%s   %s---------------------%s\n", item.get(0), item.get(1), item.get(2));
            }*/
            for(ArrayList<String> a:items){
                for(String x:a){
                    System.out.print(x+" ");
                }
                System.out.println();
            }
        }
    }
}
