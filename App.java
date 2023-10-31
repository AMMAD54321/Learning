import javax.swing.*;
import java.awt.*;

public class App {
    static JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, eq, C, mul, add, sub, div, cross;
    static JTextField textField,textField2;
    static String currentInput = "";
    static long result = 0;
    static String operator = "";

    public static void main(String[] args) {
        JFrame calculator = new JFrame("Calculator");
        ImageIcon icon =new ImageIcon("download.png");
        JPanel TEXTAREA = new JPanel(new GridLayout(2, 1));
        JPanel BUTTONAREA = new JPanel(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setText("0");
        textField.setEditable(false);

        textField2=new JTextField();
        textField2.setEditable(false);

        TEXTAREA.add(textField);
        TEXTAREA.add(textField2);

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        eq = new JButton("=");
        C = new JButton("C");
        mul = new JButton("*");
        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        cross = new JButton("<<<");

        BUTTONAREA.add(b0);
        BUTTONAREA.add(b1);
        BUTTONAREA.add(b2);
        BUTTONAREA.add(b3);
        BUTTONAREA.add(b4);
        BUTTONAREA.add(b5);
        BUTTONAREA.add(b6);
        BUTTONAREA.add(b7);
        BUTTONAREA.add(b8);
        BUTTONAREA.add(b9);
        BUTTONAREA.add(eq);
        BUTTONAREA.add(C);
        BUTTONAREA.add(mul);
        BUTTONAREA.add(add);
        BUTTONAREA.add(sub);
        BUTTONAREA.add(div);
        BUTTONAREA.add(cross);

        b0.addActionListener(e -> OPTION("0"));
        b1.addActionListener(e -> OPTION("1"));
        b2.addActionListener(e -> OPTION("2"));
        b3.addActionListener(e -> OPTION("3"));
        b4.addActionListener(e -> OPTION("4"));
        b5.addActionListener(e -> OPTION("5"));
        b6.addActionListener(e -> OPTION("6"));
        b7.addActionListener(e -> OPTION("7"));
        b8.addActionListener(e -> OPTION("8"));
        b9.addActionListener(e -> OPTION("9"));
        C.addActionListener(e -> OPTION("C"));
        add.addActionListener(e -> OPTION("+"));
        sub.addActionListener(e -> OPTION("-"));
        mul.addActionListener(e -> OPTION("*"));
        div.addActionListener(e -> OPTION("/"));
        eq.addActionListener(e -> OPTION("="));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        // Calculate frame size (80% width, 60% height)
        int frameWidth = (int) (screenSize.getWidth() * 0.2);
        int frameHeight = (int) (screenSize.getHeight() * 0.51);
        calculator.setSize(frameWidth,frameHeight);
        calculator.setLayout(new GridLayout(2, 1));
        calculator.setIconImage(icon.getImage());
        calculator.add(TEXTAREA);
        calculator.add(BUTTONAREA);
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);
        calculator.setResizable(false);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    static void OPTION(String input) {
        switch (input) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                currentInput += input;
                textField.setText(currentInput);
                break;
            case "C":
                currentInput = "";
                textField.setText("0");
                textField2.setText("");
                result = 0;
                operator = "";
                break;
            case "+":
                textField2.setText("+");
                if (!currentInput.isEmpty()) {
                    if (!operator.isEmpty()) {
                        calculateResult();
                    }
                    operator = input;
                    result = Long.parseLong(currentInput);
                    currentInput = "";
                }
                break;
            case "-":
                textField2.setText("-");
                if (!currentInput.isEmpty()) {
                    if (!operator.isEmpty()) {
                        calculateResult();
                    }
                    operator = input;
                    result = Long.parseLong(currentInput);
                    currentInput = "";
                }
                break;
            case "*":
                textField2.setText("*");
                if (!currentInput.isEmpty()) {
                    if (!operator.isEmpty()) {
                        calculateResult();
                    }
                    operator = input;
                    result = Long.parseLong(currentInput);
                    currentInput = "";
                }
                break;
            case "/":
                textField2.setText("/");
                if (!currentInput.isEmpty()) {
                    if (!operator.isEmpty()) {
                        calculateResult();
                    }
                    operator = input;
                    result = Long.parseLong(currentInput);
                    currentInput = "";
                }
                break;
            case "=":
                textField2.setText("ANSWER");
                if (!currentInput.isEmpty() && !operator.isEmpty()) {
                    calculateResult();
                    operator = "";
                }
                break;
        }
    }

    static void calculateResult() {
        if (!operator.isEmpty()) {
            long currentValue = Long.parseLong(currentInput);
            switch (operator) {
                case "+":
                    result += currentValue;
                    break;
                case "-":
                    result -= currentValue;
                    break;
                case "*":
                    result *= currentValue;
                    break;
                case "/":
                    if (currentValue != 0) {
                        result /= currentValue;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        }
    }
}
