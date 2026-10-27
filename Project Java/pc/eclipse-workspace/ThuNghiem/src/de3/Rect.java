package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rect extends Shape {
	public Rect(Point point1, Point point2, String option) {
		super(point1, point2, option);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawRect(point1.x, point1.y, 20, 20);
//		if (point1.x > point2.x && point1.y > point2.y) {
//			g.drawRect(point2.x, point2.y, point1.x, point1.y);
//		} else if (point1.x < point2.x && point1.y < point2.y) {
//			g.drawRect(point1.x, point1.y, point2.x, point2.y);
//		} else {
//			g.drawRect(point1.x, point1.y, point2.x, point2.y);
//		}

	}

	@Override
	void fillShape(Graphics g, Color color) {
		g.setColor(color);
		System.out.println("s");
		g.fillRect(point1.x, point1.y, 20, 20);
	}
}
