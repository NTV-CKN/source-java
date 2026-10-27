package de1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	Point point1, point2;
	private String optionDelete = "";

	public String getOptionDelete() {
		return optionDelete;
	}

	public void setOptionDelete(String optionDelete) {
		this.optionDelete = optionDelete;
	}

	public abstract void fillColor(Graphics g, Color color);

	public abstract void draw(Graphics g, Color color);

	public abstract void delete(Graphics g);

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

	public Shape(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}

}
