package lab7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex1 extends JFrame {
	private JLabel jlb_so1, jlb_so2, jlb_kq;
	private JButton jbt_plus, jbt_except, jbt_multi, jbt_divide, jbt_plaski;
	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JTextField jtxf_one, jtxf_two, jtxf_result;

	public Ex1() {
		this.init();
	}

	public void init() {
		jlb_so1 = new JLabel("Number one: ");
		jlb_so2 = new JLabel("Number Two: ");
		jlb_kq = new JLabel("result: ");

		jbt_plus = new JButton("+");
		jbt_except = new JButton("-");
		jbt_multi = new JButton("*");
		jbt_divide = new JButton("/");
		jbt_plaski = new JButton("=");

		jtxf_one = new JTextField(20);
		jtxf_two = new JTextField(20);
		jtxf_result = new JTextField(20);

		//event plus
		jbt_plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(jtxf_one.getText());
				double y = Double.parseDouble(jtxf_two.getText());
				jtxf_result.setText(x + y + "");
			}
		});
		
		//event except
		jbt_except.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(jtxf_one.getText());
				double y = Double.parseDouble(jtxf_two.getText());
				jtxf_result.setText(x - y + "");
		}});
		
		//event multi
		jbt_multi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(jtxf_one.getText());
				double y = Double.parseDouble(jtxf_two.getText());
				jtxf_result.setText(x * y + "");
			}
		});
		
		//event divide
		jbt_divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(jtxf_one.getText());
				double y = Double.parseDouble(jtxf_two.getText());
				jtxf_result.setText(x / y + "");
			}
		});
		
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new FlowLayout());
		jp4 = new JPanel(new FlowLayout());
		jp5 = new JPanel(new FlowLayout());

		jp1.add(jlb_so1);
		jp1.add(jtxf_one);

		jp2.add(jbt_plus);
		jp2.add(jbt_except);
		jp2.add(jbt_multi);
		jp2.add(jbt_divide);

		jp3.add(jlb_so2);
		jp3.add(jtxf_two);

		jp4.add(jbt_plaski);

		jp5.add(jlb_kq);
		jp5.add(jtxf_result);

		this.setLayout(new GridLayout(5, 1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);

		this.setTitle("Calculator");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex1();
	}
}
