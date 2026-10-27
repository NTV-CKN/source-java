package lab9;

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

public class Ex4 extends JFrame {
	private JLabel jlb;
	private JPanel jp_paint, jp_colors;
	private JButton jbt_red, jbt_black, jbt_orange, jbt_blue, jbt_yellow, jbt_green, jbt_clear;
	private Color colorsave = Color.BLACK;
	private Point point1, point2;

	public Ex4() {
		this.init();
	}

	public void init() {
		point1 = new Point();
		point2 = new Point();
		jlb = new JLabel("Keo va tha de ve hinh");

		jbt_black = new JButton(" ");
		jbt_black.setBackground(Color.black);
		jbt_black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.black;
			}
		});
		jbt_blue = new JButton(" ");
		jbt_blue.setBackground(Color.blue);
		jbt_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.blue;
			}
		});
		jbt_green = new JButton(" ");
		jbt_green.setBackground(Color.GREEN);
		jbt_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.green;
			}
		});
		jbt_orange = new JButton(" ");
		jbt_orange.setBackground(Color.orange);
		jbt_orange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.orange;
			}
		});
		jbt_red = new JButton(" ");
		jbt_red.setBackground(Color.red);
		jbt_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.red;
			}
		});
		jbt_yellow = new JButton(" ");
		jbt_yellow.setBackground(Color.yellow);
		jbt_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorsave = Color.yellow;
			}
		});
		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//(jp_paint.getGraphics()).fillRect(0, 0, getWidth(), getHeight());
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

		jp_paint = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// super.paintComponent(g);
				g.setColor(colorsave);
				if (point2.x - point1.x > 0 && point2.y - point1.y > 0) {
					g.drawRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
				} else {
					g.drawRect(point2.x, point2.y, -point2.x + point1.x, -point2.y + point1.y);
				}

			}
		};
		jp_paint.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				point1 = e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				point2 = e.getPoint();
				((JPanel) e.getSource()).repaint();
			}
		});

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
		new Ex4();
	}
}
