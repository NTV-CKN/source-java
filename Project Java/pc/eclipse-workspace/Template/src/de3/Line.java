package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {

	public Line(Point point, Point point2) {
		super(point, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fill(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(point2.x, point2.y, point.x, point.y);
	}

	@Override
	public void outline(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(point2.x, point2.y, point.x, point.y);
	}

	@Override
	public void remove(Graphics g) {
		// TODO Auto-generated method stub

	}

}