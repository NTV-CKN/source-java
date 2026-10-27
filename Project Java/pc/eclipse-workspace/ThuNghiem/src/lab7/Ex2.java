package lab7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex2 extends JFrame {
	private JTextField jtf = new JTextField();
	private JButton jbt_number, jbt_start, jbt_stop, jbt_place;
	private List<JButton> listBt = new ArrayList<JButton>();
	private JPanel jp1, jp2;

	public Ex2() {
		this.init();
	}

	void init() {
		jbt_start = new JButton("Start");
		jbt_stop = new JButton("Stop");
		jbt_place = new JButton("Food to be placed here");

		for (int i = 0; i < 10; i++) {
			jbt_number = new JButton(i + "");
			listBt.add(jbt_number);
		}

		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new GridLayout(4, 3));

		jp1.add(jtf, BorderLayout.NORTH);

		for (int i = 1; i < 10; i++) {
			jp2.add(listBt.get(i));
		}
		jp2.add(listBt.get(0));
		jp2.add(jbt_start);
		jp2.add(jbt_stop);

		jp1.add(jp2, BorderLayout.CENTER);

		this.setLayout(new GridLayout(1, 2));
		this.add(jbt_place);
		this.add(jp1);
		
		this.setTitle("Ex2");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex2();
	}
}
