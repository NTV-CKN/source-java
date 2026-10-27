package thide1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Bai3 extends JFrame{
	private JButton jbt_red, jbt_blue, jbt_green, jbt_cyan, jbt_black, jbt_orange,jbt_pink, jbt_gray;
	private JButton jbt_point, jbt_line, jbt_rect, jbt_oval, jbt_triagle, jbt_fillcolor, jbt_choosecolor, jbt_delete;
	private JPanel jp_flow, jp_flow_color;
	private jp_paint jp_paint;
	private JMenuBar jmb;
	private JMenu jmn_Menu, jmn_Help;
	private String saveOption = "Point";
	private Point point1, point2;
	
	public Bai3() {
		this.init();
	}
	
	public void init() {
		point1 = new Point(0,0);
		point2 = new Point(0,0);
		jmb = new JMenuBar();
		jmn_Menu = new JMenu("Menu");
		jmn_Help = new JMenu("Help");
		
		jmb.add(jmn_Menu); jmb.add(jmn_Help);
		this.setJMenuBar(jmb);
		
		jbt_red = new JButton(); jbt_blue = new JButton();
		jbt_red.setBackground(Color.red);
		jbt_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.red);
			}});
		jbt_blue.setBackground(Color.blue);
		jbt_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.blue);
			}});
		jbt_green = new JButton();jbt_cyan = new JButton();
		jbt_green.setBackground(Color.green);
		jbt_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.green);
			}});
		jbt_cyan.setBackground(Color.cyan);
		jbt_cyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.cyan);
			}});
		jbt_black = new JButton();jbt_orange = new JButton();
		jbt_black.setBackground(Color.black);
		jbt_black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.black);
			}});
		jbt_orange.setBackground(Color.orange);
		jbt_orange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.orange);
			}});
		jbt_pink = new JButton(); jbt_gray = new JButton();
		jbt_pink.setBackground(Color.pink);
		jbt_pink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.pink);
			}});
		jbt_gray.setBackground(Color.gray);
		jbt_gray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setColor(Color.gray);
			}});
		
		jp_paint = new jp_paint();
		
		jbt_point = new JButton("Point");
		jbt_point.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = "Point";
				jp_paint.setSaveOption(saveOption);
			}
		});
		jbt_line = new JButton("Line");
		jbt_line.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = "Line";
				jp_paint.setSaveOption(saveOption);
			}
		});
		jbt_rect = new JButton("Rectangle");
		jbt_rect.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = "Rect";
				jp_paint.setSaveOption(saveOption);
			}
		});
		jbt_oval = new JButton("Oval");
		jbt_oval.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = "Oval";
				jp_paint.setSaveOption(saveOption);
			}
		});
		jbt_triagle = new JButton("Triangle");
		jbt_triagle.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = "Triangle";
				jp_paint.setSaveOption(saveOption);
			}
		});
		jbt_fillcolor = new JButton("Fill Color");
		jbt_fillcolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setSaveOption("Fill");
			}
		});
		jbt_choosecolor = new JButton("Choose color");
		jbt_choosecolor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Color Chooser Example");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Color selectedColor = JColorChooser.showDialog(frame, "Choose a Color", Color.BLUE);
				jp_paint.setColor(selectedColor);
			}
		});
		jbt_delete = new JButton("Delete");
		jbt_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setSaveOption("Delete");
			}
		});
		
		jp_flow = new JPanel(new FlowLayout());
		jp_flow.add(jbt_point); jp_flow.add(jbt_line);
		jp_flow.add(jbt_rect); jp_flow.add(jbt_oval);
		jp_flow.add(jbt_triagle); jp_flow.add(jbt_fillcolor);
		jp_flow.add(jbt_choosecolor);jp_flow.add(jbt_delete);
		
		jp_flow_color = new JPanel(new FlowLayout());
		jp_flow_color.add(jbt_red); jp_flow_color.add(jbt_blue);
		jp_flow_color.add(jbt_green); jp_flow_color.add(jbt_cyan);
		jp_flow_color.add(jbt_black); jp_flow_color.add(jbt_orange);
		jp_flow_color.add(jbt_pink); jp_flow_color.add(jbt_gray);
		
		jp_flow.setBackground(Color.black);
		jp_flow_color.setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add(jp_flow, BorderLayout.NORTH);
		this.add(jp_paint, BorderLayout.CENTER);
		this.add(jp_flow_color, BorderLayout.SOUTH);
		this.setTitle("My paint");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Bai3();
	}
}
