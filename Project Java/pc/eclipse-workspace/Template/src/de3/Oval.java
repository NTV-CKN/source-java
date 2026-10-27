package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape{

	public Oval(Point point, Point point2) {
		super(point, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fill(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(point.x, point.y, 20, 20);
	}

	@Override
	public void outline(Graphics g, Color color) {
		g.setColor(color);
		g.drawOval(point.x, point.y, 20, 20);
	}

	@Override
	public void remove(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
