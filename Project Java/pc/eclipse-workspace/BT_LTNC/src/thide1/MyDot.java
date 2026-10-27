package thide1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyDot extends Shape{

	public MyDot(Point point1, Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		g.drawOval(point1.x, point1.y, 1, 1);
	}

	@Override
	void fill(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(point1.x, point1.y, 1, 1);
	}

}
