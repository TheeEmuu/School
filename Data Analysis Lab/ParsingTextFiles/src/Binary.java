import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
}
