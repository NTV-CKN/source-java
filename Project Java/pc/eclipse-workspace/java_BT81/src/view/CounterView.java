package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame {
	private CounterModel ctm;
	private JLabel jlb;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	//init
	public void init() {
		this.setTitle("Test");
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//new actionlistener
		ActionListener ac =  new CounterListener(this);
		//jbutton
		 this.jb1 = new JButton("UP");
		jb1.addActionListener(ac);
		this.jb2 = new JButton("DOWN");
		jb2.addActionListener(ac);
		this.jb3 = new JButton("reset");
		jb3.addActionListener(ac);
		//jlabel
		this.jlb = new JLabel(ctm.getValue()+"", JLabel.CENTER);
		//jpanel
		JPanel jp = new JPanel();
		//setLayOutPanel
		jp.setLayout(new BorderLayout());
		jp.add(jb1, BorderLayout.WEST);
		jp.add(jb3, BorderLayout.SOUTH);
		jp.add(jb2, BorderLayout.EAST);
		jp.add(jlb, BorderLayout.CENTER);
		//setLayOutFrame
		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.CENTER);
		
		//display
		this.setVisible(true);
		
			}	
		//method tang, giam, reset
	public void tang() {
		this.ctm.tang();
		this.jlb.setText(ctm.getValue()+"");
	}
	public void giam() {
		this.ctm.giam();
		this.jlb.setText(ctm.getValue()+"");
	}
	public void reset() {
		this.ctm.reset();
		this.jlb.setText(ctm.getValue()+"");
	}
	//constructor
	public CounterView() {
		this.ctm = new CounterModel();
		this.init();
	}
}
