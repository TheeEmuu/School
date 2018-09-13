import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import javax.swing.JFrame;
import java.util.ArrayList;

/**
 * A program that shows a RandomStringsPanel as its content pane.
 */
public class RandomStrings {
    
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        String[] array;

        try {
            Scanner file = new Scanner(new FileReader("RandomStrings"));

            words.add(file.next());
            while(file.hasNext()){
                String checkWord = file.next();
                for(int i = 0; i < words.size(); i++){
                    if (!checkWord.equals(words.get(i)))
                        words.add(checkWord);
                }
            }

            array = words.toArray(new String[0]);
        }
        catch(FileNotFoundException e){
            array = new String[] {null};
        }



        JFrame window = new JFrame("Java!");
        RandomStringsPanel content = new RandomStringsPanel(array);
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.setSize(350,250);
        window.setVisible(true);
    }

}

