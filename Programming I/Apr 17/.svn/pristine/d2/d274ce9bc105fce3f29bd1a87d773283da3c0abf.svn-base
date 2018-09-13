import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class RotatingTextPanel extends JPanel implements ActionListener{

    //region Components
    private JTextField textBox;
    private JButton drawButton;
    private JButton rotateButton;
    private RandomStringsPanel draw;
    private JSlider textSize;

    private JPanel control;
    private JPanel main;
    //#endregion
    public RotatingTextPanel() {
        createComponents();
        createLayout();
        attachListeners();
    }

    private void attachListeners() {
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                draw.setMessage(getMessage());
            }
        });
    }

    private void createLayout() {
        //region control
        control = new JPanel();
        control.setLayout(new FlowLayout());
        control.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        control.add(textBox);
        control.add(drawButton);
        control.add(rotateButton);
        control.add(textSize);
        //#endregion


        //main.setLayout(new BorderLayout(5, 7));
        main.add(draw, BorderLayout.CENTER);
        main.add(control, BorderLayout.SOUTH);
    }

    private void createComponents() {
        //region Buttons
        drawButton = new JButton("Draw");
        drawButton.addActionListener(this);
        rotateButton = new JButton("Rotate");
        rotateButton.addActionListener(this);
        //#endregion

        //region Text Box
        textBox = new JTextField("", 50);
        //#endregion

        //region Slider
        textSize = new JSlider(1, 20, 4);
        //endregion

        main = new JPanel(new BorderLayout());
        draw = new RandomStringsPanel("", 1);
    }

    public String getMessage(){
        return textBox.getText();
    }
    public double getTextSize(){ return textSize.getValue() * .25;}

    public void actionPerformed (ActionEvent evt){ }
}
