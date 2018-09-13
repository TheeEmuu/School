import javax.swing.*;
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

    public StringsWindow() {
        createComponents();
        createLayout();
        attachListeners();
    }

    private void attachListeners() {
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createLayout() {
        mainPanel.add(strPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        controlPanel.add(drawText);
        controlPanel.add(drawButton);
        controlPanel.add(rotateButton);

        this.setContentPane(mainPanel);
    }

    private void createComponents() {
        mainPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(); // def layout = flow

        strPanel = new RandomStringsPanel();

        drawText = new JTextField(20);
        drawButton = new JButton("Draw");
        rotateButton = new JButton("Rotate");

    }


    public void run() {

        this.setTitle("String Demo");
        this.setResizable(true);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
