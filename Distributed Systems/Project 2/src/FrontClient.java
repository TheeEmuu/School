import java.util.*;

public class FrontClient {
    BackClient middleman;

    public FrontClient(String ip, int port){
        middleman = new BackClient(ip, port);
    }

    public ArrayList<ArrayList<String>> run(String method, List<String> params){
        ArrayList<ArrayList<String>> ret = new ArrayList<>();
        switch(method.toLowerCase()){
            case "getitems":
                ret = getItems(params);
                break;
            case "purchase":
                ret = purchase(params);
                break;
            case "restock":
                ret = restock(params);
                break;
        }

        return ret;
    }


    public ArrayList<ArrayList<String>> getItems(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        if(params != null) {
            list.add(form("filter", "string", params.get(0)));
        }
        else{
            list.add(form("filter", "string", ""));
        }

        return call("getItems", list);
    }

    public ArrayList<ArrayList<String>> purchase(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        list.add(form("name", "string", params.get(0)));
        list.add(form("count", "integer", params.get(1)));

        return call("purchase", list);
    }

    public ArrayList<ArrayList<String>> restock(List<String> params){
        ArrayList<List<String>> list = new ArrayList<>();

        list.add(form("name", "string", params.get(0)));
        list.add(form("count", "integer", params.get(1)));

        return call("restock", list);
    }

    public ArrayList<ArrayList<String>> call(String methodName, List<List<String>> params){
        return middleman.callMethod(methodName, params);
    }

    private static List<String> form(String name, String type, String value){
        ArrayList<String> result = new ArrayList<>();

        result.add(name);
        result.add(type);
        result.add(value);

        return result;
    }
}
