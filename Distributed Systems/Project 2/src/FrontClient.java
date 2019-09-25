import java.util.*;

public class FrontClient {
    static BackClient middleman;

    public static void main(String[] args){
        String ip = "1.0.0.1";
        int port = 6969;
        middleman = new BackClient(ip, port);

        Scanner in = new Scanner(System.in);

        menu(null);

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

    private static void menu(List<String> items){
        List<List<String>> a = getItems(items);

        if(a != null){
            System.out.println("-------Company-------\n");
            for(List<String> item : a){
                System.out.printf("%s   %s---------------------%s\n", item.get(0), item.get(1), item.get(2));
            }
        }
    }

    public static List<List<String>> getItems(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        if(params != null) {
            list.add(form("filter", "string", params.get(0)));
        }
        else{
            list.add(form("filter", "string", null));
        }

        return call("getItems", list);
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

    public static List<List<String>> call(String methodName, List<List<String>> params){
        return middleman.doThing(methodName, params);
    }

    private static List<String> form(String name, String type, String value){
        ArrayList<String> result = new ArrayList<>();

        result.add(name);
        result.add(type);
        result.add(value);

        return result;
    }
}
