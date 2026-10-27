package lab11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	public Rectangle(Point point1, Point point2) {
		super(point1, point2);

	}

	@Override
	void drawRect(Graphics g, Color color) {
		g.setColor(color);
		Math.abs(point2.x - point1.x);
		if (point2.x - point1.x > 0 && point2.y - point1.y > 0) {
			g.drawRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
		} else {
			g.drawRect(point2.x, point2.y, -point2.x + point1.x, -point2.y + point1.y);
		//	g.drawRect(Math.abs(point2.x - point1.x), Math.abs(point2.y - point1.y), -point2.x + point1.x, -point2.y + point1.y);
		}
	}

}
