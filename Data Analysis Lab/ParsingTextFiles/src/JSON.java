import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JSON {
    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = Parsing.parseCSV(input);
        for(HashMap<String, Object> x : csv){
            x.put("Address", new Address((String) x.get("Address")));
        }


    }

    public static JSONObject addressToJson(Address address){
        JSONObject obj = new JSONObject();
        obj.put("Street", address.street);
        obj.put("City", address.city);
        obj.put("State", address.state);
        obj.put("Zip", address.zip);

        return obj;
    }

    public static String jsonToAddress(JSONObject a){
        StringBuilder str = new StringBuilder();
        str.append(a.get("Street")).append(", ");
        str.append(a.get("City")).append(", ");
        str.append(a.get("State")).append(" ");
        str.append(a.get("Zip"));

        return str.toString();
    }

    public static JSONObject entryToJson(HashMap<String, Object> a){
        JSONObject obj = new JSONObject();
        obj.put("Student ID", a.get("StudentID"));
        obj.put("Major", a.get("Major"));
        obj.put("GPA", a.get("GPA"));
        obj.put("Address", addressToJson(new Address((String) a.get("Address"))));

        return obj;
    }

    public static HashMap<String, Object> jsonToEntry(JSONObject a){
        HashMap<String, Object> map = new HashMap<>();
        map.put("StudnetID"a.get("Student ID"));
        map.put("Major", a.get("Major"));
        map.put("GPA", a.get("GPA"));
        map.put("Address", jsonToAddress((JSONObject)a.get("Address")));

        return map;
    }

    public static JSONArray collectionToJson(ArrayList<HashMap<String, Object>> a){
        JSONArray list = new JSONArray();
        for(HashMap<String, Object> x : a){
            list.add(entryToJson(x));
        }

        return list;
    }

    public static ArrayList<HashMap<String, Object>> jsonToCollection(JSONArray a){
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for(Object x : a){
            JSONObject obj = (JSONObject) x;
            list.add(jsonToEntry(obj));
        }

        return list;
    }

    public static class Address{
        String street, city, state, zip;

        public Address(String address){
            String[] split = address.split(",");
            street = split[0];
            city = split[1];
            String[] split2 = split[2].split(" ");
            state = split2[0];
            zip = split2[1];
        }
    }

    public static void writeFirst(ArrayList<HashMap<String, Object>> a){
        try(FileWriter file = new FileWriter("record1json.txt")){
            HashMap<String, Object> x = a.get(0);
            JSONObject obj = entryToJson(x);
            file.write(obj.toJSONString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeCollection(ArrayList<HashMap<String, Object>> a) {
        try(FileWriter file = new FileWriter("student_json.txt")){
            JSONArray obj = collectionToJson(a);
            file.write(obj.toJSONString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
