import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        menu(null);

        Scanner in = new Scanner(System.in);

        System.out.print("What method would you like to call: ");
        String method = in.nextLine();
        System.out.println();
        System.out.print("Please input parameters separated by spaces: ");
        String p = in.nextLine();

        List<String> params = Arrays.asList(p.split(" "));

        FrontClient.run("getItems", params);
    }

    private static void menu(List<String> items){
        List<List<String>> a = FrontClient.getItems(items);

        if(a != null){
            System.out.println("-------Company-------\n");
            for(List<String> item : a){
                System.out.printf("%s   %s---------------------%s\n", item.get(0), item.get(1), item.get(2));
            }
        }
    }
}
