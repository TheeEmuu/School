import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Binary {
    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = Parsing.parseCSV(input);

        encode(csv);
        ArrayList<HashMap<String, Object>> csvv = decode("binaryfile");

        for (HashMap<String, Object> x : csvv) {
            System.out.println(x.get("Credits"));
        }
    }

    static void encode(ArrayList<HashMap<String, Object>> a) {
        try {
            FileOutputStream fileOut = new FileOutputStream("binaryfile");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(a);
            out.close();
            System.out.println("Done");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    static ArrayList<HashMap<String, Object>> decode(String filename){
        ArrayList<HashMap<String, Object>> obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (ArrayList<HashMap<String, Object>>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return obj;
    }

    static void encodeNoSerialization(ArrayList<HashMap<String, Object>> a) throws IOException {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("binaryfile"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Set<String> keys = a.get(0).keySet();
        for(String x : keys){
            try {
                out.writeUTF(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(HashMap<String, Object> x : a){
            for(Map.Entry<String, Object> entry : x.entrySet()){
                if(entry.getValue() instanceof String){
                    out.writeUTF((String)entry.getValue());
                }
                else{
                    out.write((byte[]) entry.getValue());
                }
            }
        }
    }

    static void decodeNoSerialization(String filename){
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();


    }
}
