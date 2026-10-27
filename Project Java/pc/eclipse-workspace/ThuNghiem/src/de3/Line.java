package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape{

	public Line(Point point1, Point point2, String option) {
		super(point1, point2, option);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(point1.x, point1.y, point2.x, point2.y);
	}

	@Override
	void fillShape(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(point1.x, point1.y, point2.x, point2.y);
	}

}
