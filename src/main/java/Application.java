import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Application {

    private final JTextField firstOperand = createTextField(true);

    private final JTextField secondOperand = createTextField(true);

    private final JTextField resultField = createTextField(false);

    private final JButton sumButton = new JButton("+");

    private JTextField createTextField(boolean writeable) {
        JTextField field = new JTextField(10);
        field.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        field.setEditable(writeable);
        return field;
    }

    private void clearFields() {
        firstOperand.setText("");
        secondOperand.setText("");
        resultField.setText("");
    }

    private void showMessageBox(String message) {
        JOptionPane.showMessageDialog(null, message, "Ooops...", JOptionPane.INFORMATION_MESSAGE);
    }

    private SumPair handleInput(String x, String y) {
        if (x.isEmpty() || y.isEmpty()) {
            showMessageBox("Both operands should be presented");
            clearFields();
            return null;
        }
        try {
            return new SumPair(Integer.parseInt(x), Integer.parseInt(y));
        } catch (NumberFormatException exception) {
            showMessageBox("Only integer values might be operands");
            clearFields();
        }
        return null;
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

    public Application() {
        JPanel panel = new JPanel();
        panel.add(firstOperand);
        panel.add(sumButton);
        panel.add(secondOperand);
        panel.add(new Label(" = "));
        panel.add(resultField);

        JFrame frame = new JFrame("Sum of two numbers");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        sumButton.addActionListener(e -> {
            SumPair sumPair = handleInput(firstOperand.getText(), secondOperand.getText());
            if (sumPair == null)
                return;
            final int sum = sumPair.getX() + sumPair.getY();
            resultField.setText(Long.toString(sum));
        });
    }
}
