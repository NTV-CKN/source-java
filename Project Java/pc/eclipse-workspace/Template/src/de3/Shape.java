package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	Point point, point2;
	String status;

	public abstract void fill(Graphics g, Color color);

	public abstract void outline(Graphics g, Color color);

	public abstract void remove(Graphics g);

	public Shape(Point point, Point point2) {
		super();
		this.point = point;
		this.point2 = point2;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public void setStat(String str) {
		status = str;
	}

	public String getStat() {
		return status;
	}
}
