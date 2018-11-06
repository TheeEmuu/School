import java.util.ArrayList;

public class StringsUnder5 {
    public static void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();

        AbstractIterator<String> i;

        strings.add("Over 5");
        strings.add("the");
        strings.add("app");
        strings.add("Hello World!");
        strings.add("Pepsi");
        strings.add("work");
        strings.add("!");
        strings.add("REEEEEEE");

        for(i = (AbstractIterator<String>)strings.iterator(); i.hasNext(); i.next()){
            String next = i.get();

            if(next.length() < 5)
                System.out.println(next);
        }
    }
}
