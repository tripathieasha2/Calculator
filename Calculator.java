import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    double firstNum = 0;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789.".contains(cmd)) {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("=")) {
            double secondNum = Double.parseDouble(display.getText());
            switch(operator) {
                case "+": display.setText("" + (firstNum + secondNum)); break;
                case "-": display.setText("" + (firstNum - secondNum)); break;
                case "*": display.setText("" + (firstNum * secondNum)); break;
                case "/": display.setText("" + (firstNum / secondNum)); break;
            }
            operator = "";
        } else {
            firstNum = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
