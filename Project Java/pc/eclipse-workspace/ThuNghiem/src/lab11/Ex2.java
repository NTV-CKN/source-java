package lab11;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ex2 extends JFrame {
    private JPanel jp;
    private int x = 0, y = 0;

    public Ex2() {
        init();
    }

    public void init() {
        jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.fillOval(x, y, 30, 30);
            }
        };

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 50;
                y += 50;
                jp.repaint();
            }
        });

        timer.start();

        this.add(jp);
        this.setTitle("Ex2");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ex2();
    }
}