package FlowLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class flowLayout extends JFrame {
	public flowLayout() {
		
	}
	//flowLayout flo = new flowLayout();
	//rong
	public void flowLayOutRong() {
	FlowLayout fl = new FlowLayout();
	//setlayout
	this.setLayout(fl);
	
	this.setSize(600, 300);
	this.setLocationRelativeTo(null);
	this.setTitle("FlowLayout Null");
	
	//set buttons
	JButton j1 = new JButton("1");
	JButton j2 = new JButton("2");
	JButton j3 = new JButton("3");
	JButton j4 = new JButton("4");
	
	this.add(j1);	this.add(j2);	this.add(j3);	this.add(j4);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
	public void flowLayout() {
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 50, 40);
		this.setLayout(fl);
		this.setSize(900, 500);
		this.setTitle("FlowLayout Have Parameter");
		this.setLocationRelativeTo(null);
		
		JButton j1 = new JButton("1");
		JButton j2 = new JButton("2");
		JButton j3 = new JButton("3");
		JButton j4 = new JButton("4");
		
		this.add(j1);	this.add(j2);	this.add(j3);	this.add(j4);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		flowLayout flow = new flowLayout();
		flow.flowLayOutRong();
		flow.flowLayout();
	}
	}
