package lab7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class Ex4 extends JFrame{
	private JTextArea jtxA = new JTextArea("Thay doi tin hieu den giao thong\n-Do\n-Xanh\n-Vang");
	private JRadioButton radioButtonered, radioButtonyellow, radioButtongreen;
	private JLabel jlb = new JLabel("Chon loai den");
	private ButtonGroup bg = new ButtonGroup();
	private JPanel jp = new JPanel(new FlowLayout());

	public Ex4() {
		this.init();
	}
	public void init() {
		ActionListener ac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radioButtonered.isSelected()) {
					jtxA.setText("Thay doi tin hieu den giao thong\n-DoBan da chon do\n-Xanh\n-Vang");
				}else if(radioButtonyellow.isSelected()) {
					jtxA.setText("Thay doi tin hieu den giao thong\n-Do\n-Xanh\n-VangBan da chon vang");
				}else {
					jtxA.setText("Thay doi tin hieu den giao thong\n-Do\n-XanhBan da chon xanh\n-Vang");
				}
			}
		};
		this.radioButtonered = new JRadioButton("Do");
		this.radioButtonered.addActionListener(ac);
		this.radioButtongreen = new JRadioButton("Xanh");
		this.radioButtongreen.addActionListener(ac);
		this.radioButtonyellow = new JRadioButton("Vang");
		this.radioButtonyellow.addActionListener(ac);

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
		new Ex4();
	}
}
