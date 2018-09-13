import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A program that shows a RandomStringsPanel as its content pane.
 */
public class RandomStrings {


    private static String[] processFile(String fileName) {
        try {
            // open the file
            Scanner in = new Scanner(new FileReader(fileName));
            // count how many words are there?
            // Urgh. Or, use an arraylist?
            ArrayList<String> words = new ArrayList<String>();
            while (in.hasNext()) {
                // read all words in, discarding duplicates
                String nextWord = in.next();
                if (!isPresent(nextWord, words)) {
                    words.add(nextWord);
                }
            }
            // return that array to the caller
            String[] wordArray = new String[1];
            wordArray = words.toArray(wordArray);
            return wordArray;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Gimme a file: ");
        String fileName = in.nextLine();

        String[] words = processFile(fileName);

        JFrame window = new JFrame("Word Art");
        RandomStringsPanel content = new RandomStringsPanel(words);

        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.setSize(350,250);
        window.setVisible(true);
    }

}

