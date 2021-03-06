import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Display extends JPanel {
    //region Initializations
    //region JPanel
    private JPanel main;
    private JPanel input;
    private JPanel checkboxes;
    private JPanel statPanel;
    //#endregion

    //region Checkboxes
    JCheckBox average;
    JCheckBox median;
    JCheckBox max;
    JCheckBox min;
    JCheckBox standDev;
    JCheckBox lowPercent;
    JCheckBox highPercent;
    //#endregion

    JTextField fileInput;
    JButton submit;
    //#endregion

    public Display(){
        createComponents();
        createLayout();
        attachListeners();
    }

    private void createComponents(){
        //region JPanels
        main = new JPanel(new BorderLayout());
        input = new JPanel();
        checkboxes = new JPanel();
        statPanel = new JPanel();
        //#endregion

        //region checkboxes
        average = new JCheckBox("Average");
        median = new JCheckBox("Median");
        max = new JCheckBox("Max");
        min = new JCheckBox("Min");
        standDev = new JCheckBox("Standard Deviation");
        lowPercent = new JCheckBox("25th Percentile");
        highPercent = new JCheckBox("75th Percentile");
        //#endregion

        statPanel = new StatPanel();

        fileInput = new JTextField("Input text file name");
        submit = new JButton("Submit");
    }

    private void createLayout() {
        //region main
        main.add(input, BorderLayout.SOUTH);
        main.add(checkboxes, BorderLayout.WEST);
        main.add(statPanel, BorderLayout.CENTER);
        //#endregion

        //region input
        input.add(fileInput);
        input.add(submit);
        //#endregion

        //region checkboxes
        checkboxes.add(average);
        checkboxes.add(median);
        checkboxes.add(max);
        checkboxes.add(min);
        checkboxes.add(standDev);
        checkboxes.add(lowPercent);
        checkboxes.add(highPercent);
        //#endregion
    }

    private void attachListeners() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
