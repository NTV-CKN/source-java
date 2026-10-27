package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	Point point1, point2;
	String option;

	public Shape(Point point1, Point point2, String option) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.option = option;
	}

	abstract void fillShape(Graphics g, Color color);

	// draw
	abstract void draw(Graphics g, Color color);

}
