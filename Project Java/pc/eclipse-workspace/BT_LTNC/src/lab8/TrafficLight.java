package lab8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class TrafficLight extends JFrame {
	public TrafficLight() {
		this.init();
	}

	private JTextArea jtxA = new JTextArea("Thay doi tin hieu den giao thong\n-Do\n-Xanh\n-Vang");
	private JRadioButton radioButtonered, radioButtonyellow, radioButtongreen;
	private JLabel jlb = new JLabel("Chon loai den");
	private ButtonGroup bg = new ButtonGroup();
	private JPanel jp = new JPanel(new FlowLayout());

	public void init() {
		this.radioButtonered = new JRadioButton("Do");
		this.radioButtongreen = new JRadioButton("Xanh");
		this.radioButtonyellow = new JRadioButton("Vang");

		this.bg.add(radioButtonered);
		this.bg.add(radioButtongreen);
		this.bg.add(radioButtonyellow);

		jp.add(jlb);
		jp.add(radioButtonered);
		jp.add(radioButtongreen);
		jp.add(radioButtonyellow);

		this.setLayout(new BorderLayout());
		this.add(jtxA, BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);

		this.setTitle("Traffic Light Program");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TrafficLight();
	}
}
