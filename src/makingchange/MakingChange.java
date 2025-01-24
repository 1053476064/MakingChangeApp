package makingchange;

import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Making Change OvO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new RegisterPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
