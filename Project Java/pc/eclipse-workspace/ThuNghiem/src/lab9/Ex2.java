package lab9;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex2 extends JFrame {
	private JPanel jp;
	private JLabel jlb;
	private StringBuilder strB;

	public Ex2() {
		this.init();
	}

	public void init() {
		strB = new StringBuilder();
		jp = new JPanel(new GridLayout(11, 11));
		for (int i = 1; i < 12; i++) {
			for (int j = 0; j < i; j++) {
				strB.append((j + 1) + " ");
			}
			jlb = new JLabel(strB.toString());
			jp.add(jlb);
		}
		
		this.add(jp);
		this.setTitle("Hehe");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex2();
	}
}
