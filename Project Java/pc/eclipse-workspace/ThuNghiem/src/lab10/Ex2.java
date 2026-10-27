package lab10;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex2 extends JFrame {
	private Point point1, point2, point3;
	private ButtonGroup bg;
	private JRadioButton rd1, rd2, rd3;
	private JLabel jlb;
	private JPanel jp2, jp1;

	public Ex2() {
		this.init();
	}

	public void init() {
		ItemListener iL = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (rd1.isSelected()) {
					jp1.repaint();
				} else if (rd2.isSelected()) {
					jp1.repaint();
				} else {
					jp1.repaint();
				}
			}
		};
		jp2 = new JPanel(new FlowLayout());
		jlb = new JLabel("Select: ");
		point1 = new Point(300, 30);
		point2 = new Point(400, 30);
		point3 = new Point(500, 30);

		jp1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				if (rd1.isSelected()) {
					g.setColor(Color.RED);
					g.fillOval(point1.x, point1.y, 80, 80);
				} else {
					g.setColor(Color.BLACK);
					g.fillOval(point1.x, point1.y, 80, 80);
				}

				if (rd2.isSelected()) {
					g.setColor(Color.GREEN);
					g.fillOval(point2.x, point2.y, 80, 80);
				} else {
					g.setColor(Color.BLACK);
					g.fillOval(point2.x, point2.y, 80, 80);
				}

				if (rd3.isSelected()) {
					g.setColor(Color.YELLOW);
					g.fillOval(point3.x, point3.y, 80, 80);
				} else {
					g.setColor(Color.BLACK);
					g.fillOval(point3.x, point3.y, 80, 80);
				}
			}
		};

		bg = new ButtonGroup();
		rd1 = new JRadioButton("Red");
		bg.add(rd1);
		rd1.addItemListener(iL);
		rd2 = new JRadioButton("Green");
		bg.add(rd2);
		rd2.addItemListener(iL);
		rd3 = new JRadioButton("Yellow");
		bg.add(rd3);
		rd3.addItemListener(iL);
		jp2.add(jlb);
		jp2.add(rd1);
		jp2.add(rd2);
		jp2.add(rd3);

		this.setLayout(new GridLayout(2, 1));
		this.add(jp1);
		this.add(jp2);
		this.setTitle("Den giao thong");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex2();
	}
}
