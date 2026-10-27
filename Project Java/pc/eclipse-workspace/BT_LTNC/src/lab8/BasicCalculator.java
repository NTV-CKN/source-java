package lab8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicCalculator extends JFrame {
	public BasicCalculator() {
		this.init();
	}

	private JPanel jp_Grid = new JPanel(new GridLayout(4, 4));
	private JTextField jtxF = new JTextField();
	private JButton jbtn_Number, jbn_plus, jbn_except, jbn_multi, jbn_divide, jbn_plaski, jbn_Dot;
	private List<JButton> listNumber = new ArrayList<JButton>();

	public void init() {
		this.jbn_plus = new JButton("+");
		this.jbn_except = new JButton("-");
		this.jbn_multi = new JButton("*");
		this.jbn_divide = new JButton("/");
		this.jbn_plaski = new JButton("=");
		this.jbn_Dot = new JButton(".");

		for (int i = 0; i < 10; i++) {
			this.jbtn_Number = new JButton("" + i);
			this.listNumber.add(jbtn_Number);
		}
		this.jp_Grid.add(listNumber.get(7));
		this.jp_Grid.add(listNumber.get(8));
		this.jp_Grid.add(listNumber.get(9));
		this.jp_Grid.add(this.jbn_divide);
		this.jp_Grid.add(listNumber.get(4));
		this.jp_Grid.add(listNumber.get(5));
		this.jp_Grid.add(listNumber.get(6));
		this.jp_Grid.add(jbn_multi);
		this.jp_Grid.add(listNumber.get(1));
		this.jp_Grid.add(listNumber.get(2));
		this.jp_Grid.add(listNumber.get(3));
		this.jp_Grid.add(jbn_except);
		this.jp_Grid.add(listNumber.get(0));
		this.jp_Grid.add(jbn_Dot);
		this.jp_Grid.add(jbn_plaski);
		this.jp_Grid.add(jbn_plus);

		this.setLayout(new BorderLayout());
		this.add(jtxF, BorderLayout.NORTH);
		this.add(jp_Grid, BorderLayout.CENTER);
		
		this.setTitle("Traffic Light Program");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BasicCalculator();
	}
}
