import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lucas extends JFrame implements ActionListener{

    private final String[] str = {"+", "-", "*", "/", "OK"};
    JButton[] buttons = new JButton[str.length];
    /*除了声明语句外，其他语句都应放在方法中
    for(int i = 0; i < str.length; i++) {
        buttons[i] = new JButton(str[i]);
    }
    */
    JTextField num1 = new JTextField(" ");
    JLabel opt = new JLabel(" ");
    JTextField num2 = new JTextField(" ");
    JLabel  lead = new JLabel("=");
    JLabel output = new JLabel("0.0");

    public Lucas(){

        super("Easy Calculator");

        JPanel mainPanel = new JPanel(new GridLayout(2,5));
        mainPanel.add(num1);
        mainPanel.add(opt);
        mainPanel.add(num2);
        mainPanel.add(lead);
        mainPanel.add(output);
        for (int i = 0; i < str.length; i++) {
            buttons[i] = new JButton(str[i]);
            mainPanel.add(buttons[i]);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("Center", mainPanel);


        for (int i = 0; i < str.length; i++) {
            buttons[i].addActionListener(this);
        }
        addWindowListener(new WindowCloser());

        setSize(400,200);
        setVisible(true);
        pack();
    }

    //boolean isOperate = false;    //panduan shifou yunsuanguo
    double number = 0;
    String operator = "=";

    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if (key.equals("+")) {
            number = Double.valueOf(num1.getText()) + Double.valueOf(num2.getText());
            operator = "+";                  
        } else if (key.equals("-")) {
            number = Double.valueOf(num1.getText()) - Double.valueOf(num2.getText());
            operator = "-";
        } else if (key.equals("*")) {
            number = Double.valueOf(num1.getText()) * Double.valueOf(num2.getText());
            operator = "*";
        } else if (key.equals("/")) {
            number = Double.valueOf(num1.getText()) / Double.valueOf(num2.getText());
            operator = "/";
        } else if (key.equals("OK")) {
            opt.setText(operator);
            output.setText(String.valueOf(number));
        }

    }

    private class WindowCloser extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    
    public static void main(String[] args){
        new Lucas();
    }
}
