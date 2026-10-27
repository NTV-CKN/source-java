package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rect extends Shape{

	public Rect(Point point, Point point2) {
		super(point, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fill(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(point.x, point.y, 20, 20);
	}

	@Override
	public void outline(Graphics g, Color color) {
		g.setColor(color);
		g.drawRect(point.x, point.y, 20, 20);
	}

	@Override
	public void remove(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
