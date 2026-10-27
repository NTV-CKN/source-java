package thide1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyRect extends Shape{

	public MyRect(Point point1, Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		g.drawRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
	}

	@Override
	void fill(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
	}

}
