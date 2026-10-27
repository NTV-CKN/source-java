package lab11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3 extends JFrame {
	private JLabel jlb;
	
	private JPanel jp_colors;
	private Jp_paint jp_paint;
	private JButton jbt_red, jbt_black, jbt_orange, jbt_blue, jbt_yellow, jbt_green, jbt_clear;
	private Color colorsave = Color.BLACK;
	private Point point1, point2;

	public Ex3() {
		this.init();
	}

	public void init() {
		 jp_paint = new Jp_paint(); 
		point1 = new Point();
		point2 = new Point();
		jlb = new JLabel("Keo va tha de ve hinh");

		jbt_black = new JButton(" ");
		jbt_black.setBackground(Color.black);
		jbt_black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.black;
				jp_paint.setColorSave(colorsave);
			}
		});
		jbt_blue = new JButton(" ");
		jbt_blue.setBackground(Color.blue);
		jbt_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.blue;jp_paint.setColorSave(colorsave);
			}
		});
		jbt_green = new JButton(" ");
		jbt_green.setBackground(Color.GREEN);
		jbt_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.green;jp_paint.setColorSave(colorsave);
			}
		});
		jbt_orange = new JButton(" ");
		jbt_orange.setBackground(Color.orange);
		jbt_orange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.orange;jp_paint.setColorSave(colorsave);
			}
		});
		jbt_red = new JButton(" ");
		jbt_red.setBackground(Color.red);
		jbt_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.red;jp_paint.setColorSave(colorsave);
			}
		});
		jbt_yellow = new JButton(" ");
		jbt_yellow.setBackground(Color.yellow);
		jbt_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.yellow;jp_paint.setColorSave(colorsave);
				
			}
		});
		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Graphics g = jp_paint.getGraphics();
				g.setColor(Color.white);
				g.clearRect(0, 0, jp_paint.getWidth(),  jp_paint.getHeight());
			}
		});

		jp_colors = new JPanel(new FlowLayout());
		jp_colors.add(jbt_black);
		jp_colors.add(jbt_blue);
		jp_colors.add(jbt_green);
		jp_colors.add(jbt_orange);
		jp_colors.add(jbt_red);
		jp_colors.add(jbt_yellow);
		jp_colors.add(jbt_clear);

		
//		jp_paint.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				point1 = e.getPoint();
//				jp_paint.setPoint1(point1);
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				point2 = e.getPoint();
//				jp_paint.setPoint2(point2);
//			}
//		});

		this.setLayout(new BorderLayout());
		this.add(jp_paint);
		this.add(jlb, BorderLayout.NORTH);
		this.add(jp_colors, BorderLayout.SOUTH);
		this.setTitle("Paint");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex3();
	}
}
