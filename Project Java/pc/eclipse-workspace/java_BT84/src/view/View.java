package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Model;

public class View extends JFrame{
	private Model model;
	private JTextField jtf_1, jtf_2, jtf_3;
	private JButton jb1, jb2,jb3,jb4,jb5,jb6,jb7;
	//constructor
	public View() {
	 this.model = new  Model();
		this.init();
}
	//interface
	public void init() {
		this.setTitle("Mini Calculater");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		//ac
		Controller ac = new Controller(this);
		//font
		Font font_1 = new Font("Arial", Font.BOLD, 20);
		//jpanel
		JPanel jp1 = new JPanel(new GridLayout(3,2,  10, 10));
		JPanel jp2 = new JPanel(new GridLayout(2,3, 5,5));
		
		//jbutton
		this.jb1 = new JButton("+");
		jp2.add(jb1);
		this.jb1.setFont(font_1);
		this.jb1.addActionListener(ac);
		
		this.jb2 = new JButton("-");
		jp2.add(jb2);
		this.jb2.setFont(font_1);
		this.jb2.addActionListener(ac);
		
		this.jb3 = new JButton("x");
		jp2.add(jb3);
		this.jb3.setFont(font_1);
		this.jb3.addActionListener(ac);
		
		this.jb4 = new JButton("/");
		jp2.add(jb4);
		this.jb4.setFont(font_1);
		this.jb4.addActionListener(ac);
		
		this.jb5 = new JButton("^");
		jp2.add(jb5);
		this.jb5.setFont(font_1);
		this.jb5.addActionListener(ac);
		
		this.jb6 = new JButton("mod");
		jp2.add(jb6);
		this.jb6.setFont(font_1);
		this.jb6.addActionListener(ac);
		
		//this.jb7 = new JButton("=");
		//jp2.add(jb7);
		
		
		//jtextfield
		this.jtf_1 = new JTextField();
		jtf_1.setFont(font_1);
		
		this.jtf_2 = new JTextField();
		jtf_2.setFont(font_1);
		
		this.jtf_3 = new JTextField();
		jtf_3.setFont(font_1);
		
		
		//jlabel
		JLabel jlb_1 = new JLabel("Enter Number 1");
		jlb_1.setFont(font_1);
		
		//jp1.add(jlb_1);
		
		JLabel jlb_2 = new JLabel("Enter Number 2");
		jlb_2.setFont(font_1);
		//jp1.add(jlb_2);
		
		JLabel jlb_3 = new JLabel("Your answer: ");
		jlb_3.setFont(font_1);
		//jp1.add(jlb_3);
		
		//set jpanel
		jp1.add(jlb_1);
		jp1.add(jtf_1);
		jp1.add(jlb_2);
		jp1.add(jtf_2);
		jp1.add(jlb_3);
		jp1.add(jtf_3);
	
		//set Frame
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH );

		//display
		this.setVisible(true);
	}
	//methods
	public void plus() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.plus();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
	public void except() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.except();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
	public void mutiply() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.mutiply();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
	public void divide() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.divide();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
	public void pow() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.pow();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
	public void mod() {
		double a, b;
		a = Double.valueOf( this.jtf_1.getText());
		b = Double.valueOf( this.jtf_2.getText());
		this.model.setA(a);
		this.model.setB(b);
		this.model.mod();
		this.jtf_3.setText(this.model.getAnswer()+"");
	}
}
