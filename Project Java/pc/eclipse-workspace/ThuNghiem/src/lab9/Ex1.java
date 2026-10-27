package lab9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1 extends JFrame {
	private JPanel jp;
	private int index = 0;
	private Point point = new Point(0, 0);

	public Ex1() {
		this.init();
	}

	public void init() {
		jp = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				while (point.y < getHeight()) {
					if (index % 2 == 0) {
						int count = 0;
						while (point.x < getWidth()) {
							if (count % 2 == 1) {
								g.setColor(Color.WHITE);
							} else if (count % 2 == 0) {
								g.setColor(Color.BLACK);
							}
							count++;
							g.fillRect(point.x, point.y, 100, 60);
							point.x = 100 + point.x;
						}
						point.y = point.y + 60;
						point.x = 0;
						index++;

					} else if (index % 2 == 1) {
						int count = 0;
						while (point.x < getWidth()) {
							if (count % 2 == 0) {
								g.setColor(Color.WHITE);
							} else if (count % 2 == 1) {
								g.setColor(Color.BLACK);
							}
							count++;
							g.fillRect(point.x, point.y, 100, 60);
							point.x = 100 + point.x;
						}
						point.y = point.y + 60;
						point.x = 0;
						index++;
					}
				}

			}
		};
		jp.setBackground(Color.white);

		this.add(jp);
		this.setTitle("Grid test");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex1();
	}
}
