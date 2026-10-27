package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Model;

public class View extends JFrame{
	private Model model;
	private JButton jb1, jb2, jb3, jb4;
	private JLabel jlb;
	private JPanel jp1, jp2;
		
	//display
	private void init() {
		this.setTitle("LastButton");
		this.setSize(800, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//action
		Controller ac = new Controller(this);
		//setfont
		Font font = new Font("Arial", Font.ITALIC, 50);
		Font font2 = new Font("Arial", Font.BOLD, 60);
		//jpanel
		this.jp1= new JPanel(new GridLayout(2,2));
		this.jp2 = new JPanel(new BorderLayout());
		//jbutton
		//1
		this.jb1 = new JButton("1");
		this.jp1.add(jb1);
		this.jb1.setFont(font2);
		this.jb1.addActionListener(ac);
		//
		this.jb2 = new JButton("2");
		this.jp1.add(jb2);
		this.jb2.setFont(font2);
		this.jb2.addActionListener(ac);
		//3
		this.jb3 = new JButton("3");
		this.jp1.add(jb3);
		this.jb3.setFont(font2);
		this.jb3.addActionListener(ac);
		//4
		this.jb4 = new JButton("4");
		this.jp1.add(jb4);
		this.jb4.setFont(font2);
		this.jb4.addActionListener(ac);
		//jlable
		this.jlb = new JLabel("0", JLabel.CENTER);
		this.jp2.add(jlb, BorderLayout.CENTER);
		this.jlb.setFont(font);
		//setLayOutFrame
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.NORTH);
		//display
		this.setVisible(true);
	}
	//constructor
	public View() {
		this.model = new Model();
		this.init();
	}
	//methos
	public void pick_1() {
		this.model.pick_1();
		this.jlb.setText("Last button is"+this.model.getValue());
	}
	public void pick_2() {
		this.model.pick_2();
		this.jlb.setText("Last button is"+this.model.getValue());
	}
	public void pick_3() {
		this.model.pick_3();
		this.jlb.setText("Last button is"+this.model.getValue());
	}
	public void pick_4() {
		this.model.pick_4();
		this.jlb.setText("Last button is"+this.model.getValue());
	}
}
