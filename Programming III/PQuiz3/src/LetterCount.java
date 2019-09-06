import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        File file = new File("src/file");
        BufferedReader reader = null;
        HashMap<Character, Integer> frequencies = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            int c = reader.read();
            while(c != -1){
                if(frequencies.get(((char)c)) != null)
                    frequencies.put((char) c, 1 + frequencies.get((char) c));
                else
                    frequencies.put((char) c, 1);

                c = reader.read();

                while((char)c == '\n')
                    c = reader.read();
            }

            for(Map.Entry<Character, Integer> entry : frequencies.entrySet()){
                Character key = entry.getKey();
                Integer frequency = entry.getValue();

                System.out.println(key + " : " + frequency);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
