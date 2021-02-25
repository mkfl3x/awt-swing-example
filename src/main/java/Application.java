import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Application {

    private final JTextField firstOperand = getTextField();

    private final JTextField secondOperand = getTextField();

    private final JTextField resultField = getTextField();

    private final JButton sumButton = new JButton("+");

    private JTextField getTextField() {
        JTextField field = new JTextField(10);
        field.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        return field;
    }

    public Application() {
        sumButton.addActionListener(e -> {
            final int sum = Integer.parseInt(firstOperand.getText()) + Integer.parseInt(secondOperand.getText());
            resultField.setText(Integer.toString(sum));
        });

        JPanel panel = new JPanel();
        panel.add(firstOperand);
        panel.add(sumButton);
        panel.add(secondOperand);
        panel.add(new Label(" = "));
        panel.add(resultField);

        JFrame frame = new JFrame("Sum two numbers");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JTextField getFirstOperand() {
        return firstOperand;
    }

    public JTextField getSecondOperand() {
        return secondOperand;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getSumButton() {
        return sumButton;
    }
}
