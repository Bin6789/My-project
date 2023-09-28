package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasioSimulation {
    private double memory = 0.0;
    private double currentValue = 0.0;
    private String operator = "";
    private JTextField displayField;

    public CasioSimulation() {
        JFrame frame = new JFrame("Máy Tính Bỏ Túi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        displayField = new JTextField("");
        displayField.setEditable(false);
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" 
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9.]")) {
                displayField.setText(displayField.getText() + command);
            } else if (command.matches("[+\\-*/]")) {
                if (!displayField.getText().isEmpty()) {
                    memory = Double.parseDouble(displayField.getText());
                    operator = command;
                    displayField.setText("");
                }
            } else if (command.equals("=")) {
                if (!operator.isEmpty() && !displayField.getText().isEmpty()) {
                    try {
                        currentValue = Double.parseDouble(displayField.getText());
                        if ("/".equals(operator)) {
                            memory /= currentValue;
                        } else if ("*".equals(operator)) {
                            memory *= currentValue;
                        } else if ("-".equals(operator)) {
                            memory -= currentValue;
                        } else if ("+".equals(operator)) {
                            memory += currentValue;
                        }
                        displayField.setText(String.valueOf(memory));
                        operator = "";
                    } catch (NumberFormatException ex) {
                        displayField.setText("Error");
                    }
                }
            } else if (command.equals("C")) {
                displayField.setText("");
                memory = 0.0;
                currentValue = 0.0;
                operator = "";
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CasioSimulation());
    }
}
