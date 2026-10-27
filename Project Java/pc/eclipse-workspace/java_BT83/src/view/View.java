package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import model.Model;

public class View extends JFrame{
	private Model model;
	private JLabel jlb;
	private JPanel jp1, jp2;
	private JButton jb_red, jb_yellow, jb_green, jb_BG_red, jb_BG_green,jb_BG_yellow;
	//constructor
	public View() {
		this.model =new Model();
		this.init();
	}
	//init
	public void init() {
		this.setTitle("LastButton");
		this.setSize(800, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//jpanel
		this.jp1 = new JPanel(new GridLayout(2, 3)); 
		this.jp2 = new JPanel(new BorderLayout());
		//font
		Font font1 = new Font("Arial", Font.BOLD, 30);
		Font font2 = new Font("Arial", Font.ITALIC, 50);
		//ac
		Controller ac = new Controller(this);
		//jlabel
		this.jlb = new JLabel(this.model.getVuhs(), JLabel.CENTER);
		this.jp2.add(jlb);
		this.jlb.setFont(font2);
		
		//jbutton
		this.jb_red = new JButton("Text Red");
		this.jp1.add(jb_red);
		jb_red.setForeground(Color.RED);
		jp1.add(jb_red);
		this.jb_red.setFont(font1);
		this.jb_red.addActionListener(ac);
		
		this.jb_yellow = new JButton("Text Yellow");
		this.jp1.add(jb_yellow);
		jb_yellow.setForeground(Color.YELLOW);
		jp1.add(jb_yellow);
		this.jb_yellow.setFont(font1);
		this.jb_yellow.addActionListener(ac);
		
		this.jb_green = new JButton("Text Green");
		this.jp1.add(jb_green);
		jb_green.setForeground(Color.GREEN);
		jp1.add(jb_green);
		this.jb_green.setFont(font1);
		this.jb_green.addActionListener(ac);
	
		this.jb_BG_red = new JButton("BG Red");
		this.jp1.add(jb_BG_red);
		this.jb_BG_red.setBackground(Color.RED);
		this.jp1.add(jb_BG_red);
		this.jb_BG_red.setFont(font1);
		this.jb_BG_red.addActionListener(ac);
		this.jb_BG_red.setBorderPainted(false);
		
		this.jb_BG_yellow = new JButton("BG Yellow");
		this.jp1.add(jb_BG_yellow);
		this.jb_BG_yellow.setBackground(Color.YELLOW);
		this.jp1.add(jb_BG_yellow);
		this.jb_BG_yellow.setFont(font1);
		this.jb_BG_yellow.addActionListener(ac);
		this.jb_BG_yellow.setBorderPainted(false);
		
		this.jb_BG_green = new JButton("BG Green");
		this.jp1.add(jb_BG_green);
		this.jb_BG_green.setBackground(Color.GREEN);
		this.jp1.add(jb_BG_green);
		this.jb_BG_green.setFont(font1);
		this.jb_BG_green.addActionListener(ac);
		this.jb_BG_green.setBorderPainted(false);
		
		//setLayOutFrame
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.NORTH);
		//display
		this.setVisible(true);
		
		
	}
	//methods 
	public void changeTextColor_red() {
		this.jlb.setForeground(Color.RED);
	}
	public void changeTextColor_yellow() {
		this.jlb.setForeground(Color.YELLOW);
	}
	public void changeTextColor_green() {
		this.jlb.setForeground(Color.GREEN);
		}
	public void changeBGColor_red() {
		this.jp2.setBackground(Color.RED);	
		//this.jb_BG_red.setBorderPainted(false);

		}
	public void changeBGColor_yellow() {
		this.jp2.setBackground(Color.YELLOW);	
		//this.jb_BG_yellow.setBorderPainted(false);

	}
	public void changeBGColor_green() {
		this.jp2.setBackground(Color.GREEN);	
	//	this.jb_BG_green.setBorderPainted(false);

		}
	
}
