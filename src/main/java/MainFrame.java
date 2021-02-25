import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainFrame implements ActionListener {

    private JTextField getTextField() {
        JTextField field = new JTextField(10);
        field.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        return field;
    }

    private final JTextField firstOperand = getTextField();
    private final JTextField secondOperand = getTextField();
    private final JTextField resultField = getTextField();

    public MainFrame() {
        JButton sumButton = new JButton("+");
        sumButton.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        final int sum = Integer.parseInt(this.firstOperand.getText()) + Integer.parseInt(this.secondOperand.getText());
        resultField.setText(Integer.toString(sum));
    }
}
