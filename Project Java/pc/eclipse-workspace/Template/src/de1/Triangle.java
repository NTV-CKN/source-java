package de1;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	public Triangle(java.awt.Point point1, java.awt.Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fillColor(Graphics g, Color color) {
		g.setColor(color);
		int pointx[] = { point1.x, point2.x, point1.x };
		int pointy[] = { point1.y, point2.y, point2.y };
		g.fillPolygon(pointx, pointy, 3);
	}

	@Override
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(point1.x, point1.y, point2.x, point2.y);
		g.drawLine(point2.x - (point2.x - point1.x), point2.y, point1.x, point1.y);
		g.drawLine(point2.x - (point2.x - point1.x), point2.y, point2.x, point2.y);
	}

	@Override
	public void delete(Graphics g) {
		// TODO Auto-generated method stub

	}
}
