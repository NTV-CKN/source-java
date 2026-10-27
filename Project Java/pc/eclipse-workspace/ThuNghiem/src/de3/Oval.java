package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape{
	public Oval(Point point1, Point point2, String option) {
		super(point1, point2, option);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawOval(point1.x, point1.y, 20, 20);
	}

	@Override
	void fillShape(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(point1.x, point1.y, 20, 20);
	}
}
