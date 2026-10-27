package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;import javax.swing.border.Border;

import controller.ControllerEx;
import model.MouseEx;

public class ViewEx extends JFrame{
	private MouseEx model;
	private JPanel jp_center_view;
	private JPanel jp_south;
	private JLabel jlb_rep_check_area;
	private JLabel jlb_x;
	private JLabel jlb_y;
	private JLabel jlb_count;
	
	//constructor
	public ViewEx() {
	this.model = new MouseEx();
	this.init();
	}
	//giao dien
	private void init() {
		this.setTitle("MOUSE");
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//mouselistener
		ControllerEx mouseAC = new ControllerEx(this);
		
		//font
		Font font = new Font("Arial", Font.BOLD, 35);
		//jpanel
		jp_center_view = new JPanel();
		jp_south = new JPanel(new GridLayout(3,3));
		//add mouseAC 
		jp_center_view.addMouseListener(mouseAC);
		jp_center_view.addMouseMotionListener(mouseAC);	
		
		//setbackground jpanel
		jp_center_view.setBackground(Color.cyan);
		jp_south.setBackground(Color.LIGHT_GRAY);
		//jlabel
		JLabel jlb_position = new JLabel("Position: ");
		JLabel jlb_check_area = new JLabel("Check area: ");
		JLabel jlb_click_count = new JLabel("Number of clicks:");
		
		JLabel jlb_empty_1 = new JLabel();
		JLabel jlb_empty_2 = new JLabel();
		 jlb_rep_check_area = new JLabel("no");
		 jlb_x = new JLabel("X");
		 jlb_y = new JLabel("Y");
		 jlb_count = new JLabel();
		 //add layout south
		 jp_south.add(jlb_position);
		 jp_south.add(jlb_x);
		 jp_south.add(jlb_y);
		 jp_south.add(jlb_check_area);
		 jp_south.add(jlb_rep_check_area);
		 jp_south.add(jlb_empty_1);
		 jp_south.add(jlb_click_count);
		 jp_south.add(jlb_count);
		 jp_south.add(jlb_empty_2);
		 //jframe
		 this.setLayout(new BorderLayout());
		 this.add(jp_center_view, BorderLayout.CENTER);
		 this.add(jp_south, BorderLayout.SOUTH);
		 
		
		this.setVisible(true);
	}
	//methods
	public void count() {
		this.model.count();
		this.jlb_count.setText(this.model.getCount()+"");
	}
	public void entered() {
		this.model.setCheckIn("yes");
		this.jlb_rep_check_area.setText(this.model.getCheckIn());
	}
	public void exited() {
		this.model.setCheckIn("no");
		this.jlb_rep_check_area.setText(this.model.getCheckIn());
	}
	public void updatePosition(int x, int y) {
		this.model.setX(x);
		this.model.setY(y);
		
		jlb_x.setText(this.model.getX()+"");
		jlb_y.setText(this.model.getY()+"");

	}
}
