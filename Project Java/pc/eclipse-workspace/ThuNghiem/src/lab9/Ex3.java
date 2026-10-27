package lab9;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3 extends JFrame {
	private JPanel jp;

	public Ex3() {
		this.init();
	}

	public void init() {
		jp = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.fillArc(150, 50, 300, 300, 270, 45);
				g.fillArc(150, 50, 300, 300, 0, 45);
				g.fillArc(150, 50, 300, 300, 90, 45);
				g.fillArc(150, 50, 300, 300, 180, 45);
			}
		};

		this.add(jp);
		this.setTitle("Ex3");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex3();
	}
}
