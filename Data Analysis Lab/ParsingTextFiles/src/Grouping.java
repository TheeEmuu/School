import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grouping {
    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = Parsing.parseCSV(input);

        HashMap<String, Integer> numInMajor = new HashMap<>();
        for(HashMap<String, Object> x : csv){
            if(numInMajor.get(getMajor(x)) == null)
                numInMajor.put(getMajor(x), 1);
            else
                numInMajor.put(getMajor(x), numInMajor.get(getMajor(x)) + 1);
        }
        System.out.println("Students by Major");
        for(Map.Entry<String, Integer> x : numInMajor.entrySet()){
            System.out.println(x.getKey() + ": " + x.getValue());
        }

        HashMap<String, Double> avgGPA = new HashMap<>();
        for(HashMap<String, Object> x : csv){
            if(avgGPA.get(getMajor(x)) == null)
                avgGPA.put(getMajor(x), getGPA(x));
            else
                avgGPA.put(getMajor(x), avgGPA.get(getMajor(x)) + getGPA(x));
        }
        for(Map.Entry<String, Double> x : avgGPA.entrySet()) {
            avgGPA.put(x.getKey(), x.getValue() / numInMajor.get(x.getKey()));
        }
        System.out.println("GPA by Major");
        for(Map.Entry<String, Double> x : avgGPA.entrySet()){
            System.out.println(x.getKey() + ": " + x.getValue());
        }

        HashMap<String, Integer> numInGPA = new HashMap<>();
        for(HashMap<String, Object> x : csv){
            if(numInGPA.get(getGpaClass(x)) == null)
                numInGPA.put(getGpaClass(x), 1);
            else
                numInGPA.put(getGpaClass(x), numInGPA.get(getGpaClass(x)) + 1);
        }
        System.out.println("Students by GPA");
        for(Map.Entry<String, Integer> x : numInGPA.entrySet()){
            System.out.println(x.getKey() + ": " + x.getValue());
        }

    }

    public static String getMajor(HashMap<String, Object> entry){
        return (String)entry.get("Major");
    }

    public static Double getGPA(HashMap<String, Object> entry){
        return (Double)entry.get("GPA");
    }

    public static String getGpaClass(HashMap<String, Object> entry){
        if((Double)entry.get("GPA") < 1)
            return "<1";
        if((Double)entry.get("GPA") < 2)
            return "<2";
        if((Double)entry.get("GPA") < 3)
            return "<3";
        if((Double)entry.get("GPA") <= 4)
            return "<=4";
        return "something went wrong";
    }
}
