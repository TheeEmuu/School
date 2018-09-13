import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {
    //region Initilizations
    JButton load;
    JTextField fileInput;

    JPanel main;
    JPanel input;
    WordCloud wordCloud;
    //endregion

    public Display(){
        createComponents();
        createLayout();
        attachListeners();
    }

    private void createComponents() {
        load = new JButton("Load");
        fileInput = new JTextField();

        main = new JPanel(new BorderLayout());
        input = new JPanel(new BorderLayout());
        wordCloud = new WordCloud("default");
    }

    private void createLayout(){
        //region input
        input.add(fileInput, BorderLayout.CENTER);
        input.add(load, BorderLayout.EAST);
        //endregion

        //region main
        main.add(input, BorderLayout.SOUTH);
        main.add(wordCloud, BorderLayout.CENTER);
        //endregion
    }

    private void attachListeners(){
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordCloud = new WordCloud(fileInput.getText());
            }
        });
    }

    public JPanel getMain(){ return main;}
}
