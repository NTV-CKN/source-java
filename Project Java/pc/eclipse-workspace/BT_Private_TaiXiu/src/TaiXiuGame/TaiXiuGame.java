package TaiXiuGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaiXiuGame extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public TaiXiuGame() {
        setTitle("Tài Xỉu Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setSize(1024, 900);
        setSize(getMaximumSize());
        setLayout(new FlowLayout());
       setLocationRelativeTo(null);
        
        label = new JLabel("Nhập một số: ");
        textField = new JTextField(10);
        button = new JButton("Kiểm tra");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(textField.getText());
                String result = checkTaiXiu(number);
                JOptionPane.showMessageDialog(null, result);
            }
        });

        add(label);
        add(textField);
        add(button);

        setVisible(true);
    }

    private String checkTaiXiu(int number) {
        if (number % 2 == 0) {
            return "Tài";
        } else {
            return "Xỉu";
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TaiXiuGame();
            }
        });
    }
}
