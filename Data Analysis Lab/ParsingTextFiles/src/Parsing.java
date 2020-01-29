import java.io.*;
import java.util.*;

public class Parsing {
    public static ArrayList<HashMap<String, Object>> parseTabs(InputStream a) throws IOException {
        Reader in = new InputStreamReader(a);

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        String input = "";
        int index = 0;
        table.add(new ArrayList<>());
        int character = in.read();

        while (character != -1) {
            char next = (char) character;
            if (next == '\t') {
                table.get(index).add(input);
                input = "";
            } else if (next == '\n') {
                table.get(index).add(input);
                table.add(new ArrayList<>());
                input = "";
                index++;
            } else
                input += next;

            character = in.read();
        }

        table.remove(table.size() - 1);
        return handle(table);
    }

    public static ArrayList<HashMap<String, Object>> parseCSV(InputStream a) throws IOException {
        Reader in = new InputStreamReader(a);

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        String input = "";
        int index = 0;
        table.add(new ArrayList<>());
        int character = in.read();

        boolean inQuotes = false;
        while (character != -1) {
            char next = (char) character;
            if(next == '\"'){
                inQuotes = !inQuotes;
            }
            else if (next == ',' && !inQuotes) {
                table.get(index).add(input);
                input = "";
            } else if (next == '\n') {
                table.get(index).add(input);
                table.add(new ArrayList<>());
                input = "";
                index++;
            } else
                input += next;

            character = in.read();
        }

        table.remove(table.size() - 1);
        return handle(table);
    }

    public static ArrayList<HashMap<String, Object>> handle(ArrayList<ArrayList<String>> table){
        ArrayList<String> schema = table.get(0);
        // 0 for string, 1 for int, 2 for double
        int[] types = new int[schema.size()];

        for(int i = 0; i < schema.size(); i++) {
            boolean isNumber = true;
            boolean isDouble = false;
            for (int k = 1; k < table.size(); k++) {
                if(table.get(k).get(i).matches("(.*)[^0-9e.](.*)")){
                    isDouble = false;
                    isNumber = false;
                    break;
                }
                else if(table.get(k).get(i).matches("(.*)[e.](.*)")){
                    isDouble = true;
                }
            }

            if(isNumber){
                if(isDouble)
                    types[i] = 2;
                else
                    types[i] = 1;
            }
            else
                types[i] = 0;
        }

        ArrayList<HashMap<String, Object>> entries = new ArrayList<>();
        for(int i = 1; i < table.size(); i++){
            entries.add(new HashMap<>());
            for(int k = 0; k < schema.size(); k++){
                switch(types[k]){
                    case 0:
                        entries.get(i-1).put(schema.get(k), table.get(i).get(k));
                        break;
                    case 1:
                        entries.get(i-1).put(schema.get(k), Integer.parseInt(table.get(i).get(k)));
                        break;
                    case 2:
                        entries.get(i-1).put(schema.get(k), Double.parseDouble(table.get(i).get(k)));
                        break;
                }
            }
        }

        return entries;
    }

    public static double sumColumnValues(ArrayList<HashMap<String, Object>> table, String columnName){
        double total = 0;
        for (HashMap<String, Object> entry : table) {
            total += (double) entry.get(columnName);
        }
        
        return total;
    }

    public static int sumColumnLengths(ArrayList<HashMap<String, Object>> table, String columnName){
        int total = 0;
        for (HashMap<String, Object> entry : table) {
            total += ((String) entry.get(columnName)).length();
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = parseCSV(input);

        file = new File("Student.txt");
        input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> txt = parseTabs(input);

        System.out.println("Txt has " + txt.size() + " entries");
        System.out.println("Csv has " + csv.size() + " entries");
        System.out.println();
        System.out.println("Txt has " + sumColumnValues(txt, "GPA") + " total GPA");
        System.out.println("Csv has " + sumColumnValues(csv, "GPA") + " total GPA");
        System.out.println();
        System.out.println("Txt has " + sumColumnLengths(txt, "Address.Street") + " letters in streets");
        System.out.println("Csv has " + sumColumnLengths(csv, "Address.Street") + " letters in streets");
        System.out.println();
    }
}
