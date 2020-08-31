import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Sorting {
    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = Parsing.parseCSV(input);

        ArrayList<HashMap<String, Object>> comp = (ArrayList<HashMap<String, Object>>)csv.clone();
        ArrayList<HashMap<String, Object>> lamb = (ArrayList<HashMap<String, Object>>)csv.clone();

        Collections.sort(comp, new sortByRoll());

        lamb.sort((o1, o2) -> {
            if(((String)o1.get("Address.State")).compareTo(((String)o2.get("Address.State"))) == 0)
                return ((String)o1.get("Address.City")).compareTo((String)o2.get("Address.City"));
            else
                return ((String)o1.get("Address.State")).compareTo(((String)o2.get("Address.State")));
        });

        for(int i = 0; i < csv.size(); i++){
            System.out.print(csv.get(i).get("Address.City") + " " + csv.get(i).get("Address.State") + "     ");
            System.out.print(comp.get(i).get("Address.City") + " " + comp.get(i).get("Address.State") + "     ");
            System.out.print(lamb.get(i).get("Address.City") + " " + lamb.get(i).get("Address.State") + "     ");
            System.out.println();
        }
    }

    static class sortByRoll implements Comparator<HashMap<String, Object>>{
        @Override
        public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
            if(((String)o1.get("Address.State")).compareTo(((String)o2.get("Address.State"))) == 0)
                return ((String)o1.get("Address.City")).compareTo((String)o2.get("Address.City"));
            else
                return ((String)o1.get("Address.State")).compareTo(((String)o2.get("Address.State")));
        }
    }

    public static ArrayList<HashMap<String, Object>> sortWithLambda(ArrayList<HashMap<String, Object>> data){
        return null;
    }
}
