import java.util.*;
import javax.swing.*;

public class FrontClient {
    static BackClient middleman;

    public static void main(String[] args){
        String ip = "1.0.0.1";
        int port = 6969;
        middleman = new BackClient(ip, port);

        Scanner in = new Scanner(System.in);

//        JFrame frame = new JFrame("Main");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JButton button = new JButton("Text");
//        JButton button2 = new JButton("More Text");
//        frame.getContentPane().add(button, BorderLayout.SOUTH);
//        frame.getContentPane().add(button2, BorderLayout.SOUTH);
//        frame.pack();
//        frame.setVisible(true);

        System.out.print("What method would you like to call: ");
        String method = in.nextLine();
        System.out.println();
        System.out.print("Please input parameters separated by spaces: ");
        String p = in.nextLine();

        List<String> params = Arrays.asList(p.split(" "));

        switch(method){
            case "getItems":
                getItems(params);
                break;
            case "purchase":
                purchase(params);
                break;
            case "restock":
                restock(params);
                break;
        }
    }

    public static void getItems(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        list.add(form("filter", "string", params.get(0)));

        call("getItems", list);
    }

    public static void purchase(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        list.add(form("name", "string", params.get(0)));
        list.add(form("count", "int", params.get(1)));

        call("purchase", list);
    }

    public static void restock(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        list.add(form("name", "string", params.get(0)));
        list.add(form("count", "int", params.get(1)));

        call("restock", list);
    }



    public static void call(String methodName, List<List<String>> params){
        middleman.doThing(methodName, params);
    }

    private static List<String> form(String a, String b, String c){
        ArrayList<String> result = new ArrayList<>();

        result.add(a);
        result.add(b);
        result.add(c);

        return result;
    }
}
