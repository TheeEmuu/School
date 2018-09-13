import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame("Stats");
        Display content = new Display();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000,500);
        window.setVisible(true);
    }
}
