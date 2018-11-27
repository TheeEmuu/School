import java.util.ArrayList;
import java.util.Iterator;

public class StringsUnder5 {
    public static void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();

        strings.add("Over 5");
        strings.add("the");
        strings.add("app");
        strings.add("Hello World!");
        strings.add("Pepsi");
        strings.add("work");
        strings.add("!");
        strings.add("REEEEEEE");

        Iterator<String> i = strings.iterator();

        while(i.hasNext()){
            String element = i.next();

            if(element.length() < 5)
                System.out.println(element);
        }
    }
}
