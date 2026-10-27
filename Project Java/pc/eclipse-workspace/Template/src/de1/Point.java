package de1;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{

	public Point(java.awt.Point point1, java.awt.Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fillColor(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(super.getPoint2().x, super.getPoint2().y, 2, 2);
	}

	@Override
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(super.getPoint2().x, super.getPoint2().y, 2, 2);
	}

	@Override
	public void delete(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
