import java.util.*;

public class FrontClient {
    static BackClient middleman;

    public static void main(String[] args){
        String ip = "1.0.0.1";
        int port = 6969;
        middleman = new BackClient(ip, port);
    }

    public static void run(String method, List<String> params){
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


    public static List<List<String>> getItems(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        if(params != null) {
            list.add(form("filter", "string", params.get(0)));
        }
        else{
            list.add(new ArrayList<>());
            list.get(0).add("EMPTY");
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
