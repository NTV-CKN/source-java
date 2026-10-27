package de1;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {
	public Rect(java.awt.Point point1, java.awt.Point point2) {
		super(point1, point2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fillColor(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(Math.min(super.getPoint1().x, super.getPoint2().x),
				Math.min(super.getPoint1().y, super.getPoint2().y),
				(Math.max(super.getPoint1().x, super.getPoint2().x)
						- Math.min(super.getPoint1().x, super.getPoint2().x)),
				(Math.max(super.getPoint1().y, super.getPoint2().y)
						- Math.min(super.getPoint1().y, super.getPoint2().y)));
	}

	@Override
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawRect(Math.min(super.getPoint1().x, super.getPoint2().x),
				Math.min(super.getPoint1().y, super.getPoint2().y),
				(Math.max(super.getPoint1().x, super.getPoint2().x)
						- Math.min(super.getPoint1().x, super.getPoint2().x)),
				(Math.max(super.getPoint1().y, super.getPoint2().y)
						- Math.min(super.getPoint1().y, super.getPoint2().y)));
	}

	@Override
	public void delete(Graphics g) {
		// TODO Auto-generated method stub

	}
}
