package thide1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyTriangle extends Shape {

	public MyTriangle(Point point1, Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		g.drawLine(point1.x, point1.y, point2.x, point2.y);
		g.drawLine(point2.x - (point2.x - point1.x), point2.y, point1.x, point1.y);
		g.drawLine(point2.x - (point2.x - point1.x), point2.y, point2.x, point2.y);
	}

	@Override
	void fill(Graphics g, Color color) {
		g.setColor(color);
			int pointx[] = { point1.x, point2.x, point1.x };
			int pointy[] = { point1.y, point2.y, point2.y };
			g.fillPolygon(pointx, pointy, 3);
	}

}
