package lab7;

import image.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Ex3 extends JFrame {
	private JLabel jlb_so1, jlb_so2, jlb_kq;
	private JButton jbt_plus, jbt_except, jbt_multi, jbt_divide;
	private JPanel jp1, jp2;
	private JTextField jtxf_one, jtxf_two, jtxf_result;
	private JMenuBar jmb;
	private JMenu jm1, jm2;
	private JMenuItem jmi1, jmi2, jmi3, jmi4;

	public Ex3() {
		this.init();
	}

	void init() {
		jlb_so1 = new JLabel("Number one: ");
		jlb_so2 = new JLabel("Number Two: ");
		jlb_kq = new JLabel("result: ");

		jbt_plus = new JButton("+",
				new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/plus.png"));
		jbt_except = new JButton("-",
				new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/minus.png"));
		jbt_multi = new JButton("*",
				new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/multi.png"));
		jbt_divide = new JButton("/",
				new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/divide.png"));

		jtxf_one = new JTextField(20);
		jtxf_two = new JTextField(20);
		jtxf_result = new JTextField(20);

		// event plus
		jbt_plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				plus();
			}
		});

		// event except
		jbt_except.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				minus();
			}
		});

		// event multi
		jbt_multi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				multi();
			}
		});

		// event divide
		jbt_divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				divide();
			}
		});

		jmb = new JMenuBar();
		jm1 = new JMenu("Operation");

		jm2 = new JMenu("Exit");
		JMenuItem jmiE = new JMenuItem("Click exit");
		jm2.add(jmiE);
		jmiE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		jmi1 = new JMenuItem("Plus");
		jmi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				plus();
			}
		});
		jmi2 = new JMenuItem("Minus");
		jmi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				minus();
			}
		});
		jmi3 = new JMenuItem("Multiply");
		jmi3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				multi();
			}
		});
		jmi4 = new JMenuItem("Divide");
		jmi4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				divide();
			}
		});

		jmi1.setIcon(new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/plus.png"));
		jmi2.setIcon(new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/minus.png"));
		jmi3.setIcon(new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/multi.png"));
		jmi4.setIcon(new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/divide.png"));

		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);

		jm1.setMnemonic('O');
		jm2.setMnemonic('E');

		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jmi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		jmi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		jmiE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

		jmb.add(jm1);
		jmb.add(jm2);

		jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
		jp1.add(jlb_so1);
		jp1.add(jtxf_one);
		jp1.add(jlb_so2);
		jp1.add(jtxf_two);
		jp1.add(jlb_kq);
		jp1.add(jtxf_result);

		jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
		jp2.add(jbt_plus);
		jp2.add(jbt_except);
		jp2.add(jbt_multi);
		jp2.add(jbt_divide);

		this.setLayout(new GridLayout(3, 1));
		this.setJMenuBar(jmb);
		this.add(jp1);
		this.add(jp2);

		this.setTitle("Ex3");
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// pack();
		this.setVisible(true);
	}

	public void plus() {
		double x = Double.parseDouble(jtxf_one.getText());
		double y = Double.parseDouble(jtxf_two.getText());
		jtxf_result.setText(x + y + "");
	}

	public void minus() {
		double x = Double.parseDouble(jtxf_one.getText());
		double y = Double.parseDouble(jtxf_two.getText());
		jtxf_result.setText(x - y + "");
	}

	public void multi() {
		double x = Double.parseDouble(jtxf_one.getText());
		double y = Double.parseDouble(jtxf_two.getText());
		jtxf_result.setText(x * y + "");
	}

	public void divide() {
		double x = Double.parseDouble(jtxf_one.getText());
		double y = Double.parseDouble(jtxf_two.getText());
		jtxf_result.setText(x / y + "");
	}

	public static void main(String[] args) {
		new Ex3();
	}
}
