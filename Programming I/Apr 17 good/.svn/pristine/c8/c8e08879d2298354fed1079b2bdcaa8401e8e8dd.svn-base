import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringsWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel controlPanel;

    private RandomStringsPanel strPanel;

    private JTextField drawText;
    private JButton drawButton;
    private JButton rotateButton;
    private JSlider textSize;

    public StringsWindow() {
        createComponents();
        createLayout();
        attachListeners();
    }

    private void attachListeners() {
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strPanel.setMessage(getMessage());
            }
        });
        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strPanel.rotate();
            }
        });
        textSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                strPanel.setFontSize(getTextSize());
            }
        });
    }

    private void createLayout() {
        mainPanel.add(strPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        controlPanel.add(drawText);
        controlPanel.add(drawButton);
        controlPanel.add(rotateButton);
        controlPanel.add(textSize);

        this.setContentPane(mainPanel);
    }

    private void createComponents() {
        mainPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(); // def layout = flow

        strPanel = new RandomStringsPanel();

        drawText = new JTextField(20);
        drawButton = new JButton("Draw");
        rotateButton = new JButton("Rotate");
        textSize = new JSlider(1, 20, 4);
    }

    public String getMessage(){ return drawText.getText();}
    public Double getTextSize(){ return textSize.getValue() * .25;}


    public void run() {

        this.setTitle("String Demo");
        this.setResizable(true);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
