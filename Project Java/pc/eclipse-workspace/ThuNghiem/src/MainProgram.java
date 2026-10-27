

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainProgram {
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);


        JLabel label = new JLabel("Welcome");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);


        JButton button = new JButton("Don't click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "I don't know how to do with 20 button and method :( ");
            }
        });
        frame.add(button);


        frame.setVisible(true);
    }
}