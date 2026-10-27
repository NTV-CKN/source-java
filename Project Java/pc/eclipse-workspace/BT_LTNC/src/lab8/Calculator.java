package lab8;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
    private JButton jbn_plus, jbn_except, jbn_multi, jbn_divide, jbn_plaski;
    private JLabel jlb_one, jlb_two, jlb_result, jlb_n;
    private JTextField jtx_one, jtx_two, jtx_result;
    private JPanel jp_one, jp_result, jp_plaski;
    
    public void init() {
        this.jbn_plus = new JButton("+");
        this.jbn_except = new JButton("-");
        this.jbn_multi = new JButton("*");
        this.jbn_divide = new JButton("/");
        this.jbn_plaski = new JButton("=");

        this.jtx_one = new JTextField();
        this.jtx_two = new JTextField();
        this.jtx_result = new JTextField();

        this.jlb_one = new JLabel("number 1: ");
        this.jlb_two = new JLabel("number 2: ");
        this.jlb_result = new JLabel("result: ");

        this.jp_one = new JPanel(new GridLayout(3, 2));

        this.jp_one.add(jlb_one);
        this.jp_one.add(jtx_one);
        this.jp_one.add(jbn_plus);
        this.jp_one.add(jbn_except);
        this.jp_one.add(jbn_multi);
        this.jp_one.add(jbn_divide);
        this.jp_one.add(jlb_two);
        this.jp_one.add(jtx_two);
        this.jp_one.add(jbn_plaski);
        this.jp_one.add(jlb_result);
        this.jp_one.add(jtx_result);

        this.add(jp_one);

        this.setTitle("Calculator");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.init();
    }
}
