package makingchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel() {
        this.register = new Register();
        this.input = new JTextField(10);
        this.changePanel = new PursePanel();

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        JButton makeChangeButton = new JButton("← Make Change UwU");
        inputPanel.add(makeChangeButton);

        makeChangeButton.addActionListener(new InputListener());

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(600, 400));
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
                changePanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid input. Please enter a valid amount.");
            }
        }
    }
}
