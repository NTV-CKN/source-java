package lab11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	protected Point point1, point2;
	
	public Shape(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}

	abstract void drawRect(Graphics g, Color color);
}
