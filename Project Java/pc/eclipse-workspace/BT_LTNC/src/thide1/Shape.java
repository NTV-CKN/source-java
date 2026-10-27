package thide1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	protected Point point1, point2;

	public Shape(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	abstract void draw(Graphics g);

	abstract void fill(Graphics g, Color color);

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
}
