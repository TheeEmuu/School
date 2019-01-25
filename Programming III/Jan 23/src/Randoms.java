import java.util.Random;
import java.util.Vector;

public class Randoms {
    public String randomString(int length){
        StringBuilder string = new StringBuilder();

        Random r = new Random();
        for(int i = 0; i < length; i++){
            char c = (char)(r.nextInt(26) + 'a');
            string.append(c);
        }

        return string.toString();
    }

    public String[] randomStringArray(int length, int stringLength){
        Vector<String> array = new Vector<>();

        for(int i = 0; i < length; i++){
            array.add(randomString(stringLength));
        }

        return array.toArray(new String[array.size()]);
    }
}
