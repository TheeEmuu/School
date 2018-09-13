import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCloud extends JPanel {
    ArrayList<Word> fileText;
    Scanner filein;

    public WordCloud(String file){

        fileText = new ArrayList<>();
        try {
            filein = new Scanner(new FileReader(file));
            System.out.println("Text found");
            do{
                String input = filein.next();
                arraySearch(input);
            } while  (filein.hasNext());
            repaint();
        }
        catch (FileNotFoundException e){
            System.out.println("Text not found");
            Word word = new Word("File not found");
            fileText.add(word);
        }
    }

    private void arraySearch(String search) {
        for (Word str : fileText) {
            if (search.equals(str.word)) {
                str.frequency++;
                return;
            }
        }

        fileText.add(new Word(search));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Font font = new Font("Main", Font.PLAIN, 12);
        for(Word word : fileText){
            setBackground(Color.BLACK);
            g.setFont(new Font("Font", Font.PLAIN, 12 * word.frequency));

            //region Color
            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            //endregion

            Color color = new Color(red, green, blue);
            g.setColor(color);
            g.drawString(word.word, (int)(Math.random() * 400 + 50), (int)(Math.random() * 400 + 50));
        }
    }
}

class Word{
    String word;
    int frequency;

    Word(){ }
    Word(String word){
        this.word = word;
        this.frequency = 1;
    }
}