import java.util.ArrayList;
import java.util.List;

public class oldBackClient {
    public oldBackClient(String i, int p){

    }

    public List<List<String>> doThing(String methodName, List<List<String>> list){
        switch(methodName){
            case "getItems":
                return getItems(list);
            case "purchase":
                purchase(list);
            case "restock":
                restock(list);
            default:
                error("Couldn't find requested function");
        }
        return null;
    }

    private List<List<String>> getItems(List<List<String>> params){
        ArrayList<List<String>> a = new ArrayList<>();
        a.add(form("6", "Boots", "17"));
        a.add(form("3", "Hats", "12"));
        a.add(form("12", "Shirts", "13"));

        return a;
    }

    private void purchase(List<List<String>> params){
        System.out.println("Purchase:");
        debug(params);
    }

    private void restock(List<List<String>> params){
        System.out.println("Restock:");
        debug(params);
    }

    private String error(String message){
        return message;
    }

    private void debug(List<List<String>> params){
        for(List<String> a : params) {
            System.out.println();
            for (String x : a) {
                System.out.print(x + " ");
            }
        }
    }

    private static List<String> form(String stock, String name, String price){
        ArrayList<String> result = new ArrayList<>();

        result.add(stock);
        result.add(name);
        result.add(price);

        return result;
    }
}
