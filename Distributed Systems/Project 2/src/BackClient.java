import java.util.Dictionary;
import java.util.List;

public class BackClient {
    public BackClient(String i, int p){

    }

    public void restock(List<String> params){
        System.out.print("Calling restock with the parameters: ");
        for(String x : params){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void doThing(String methodName, List<List<String>> list){
        System.out.println("Calling " + methodName + " with the parameters: ");
        for(int i = 0; i < list.size(); i++) {
            for (String x : list.get(i))
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
