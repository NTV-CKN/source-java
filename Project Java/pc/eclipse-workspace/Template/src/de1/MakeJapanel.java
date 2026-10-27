package de1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class MakeJapanel extends JPanel {
	private HashMap<Shape, Color> map = new HashMap<Shape, Color>();
	private String option_Shape = "";
	private Color colorOption = Color.BLACK;
	private String option = "";
	private List<Shape> listFill = new ArrayList<Shape>();

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Color getColorOption() {
		return colorOption;
	}

	public void setColorOption(Color colorOption) {
		this.colorOption = colorOption;
	}

	private Point point1 = new Point(), point2 = new Point();

	public String getOption_Shape() {
		return option_Shape;
	}

	public void setOption_Shape(String option_Shape) {
		this.option_Shape = option_Shape;
	}

	public MakeJapanel() {
		this.setBackground(Color.white);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				point2 = e.getPoint();
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				point1 = e.getPoint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Shape temp = null;
		if (option.equals("FillColor")) {
			for (Map.Entry<Shape, Color> e : map.entrySet()) {
				if (point1.x >= e.getKey().getPoint1().x && point1.y >= e.getKey().getPoint1().y
						&& point1.x <= e.getKey().getPoint2().x && point1.y <= e.getKey().getPoint2().y) {
					e.getKey().fillColor(g, colorOption);
					listFill.add(e.getKey());
					map.put(e.getKey(), colorOption);
				}
			}
		}
		if (option_Shape.equals("Point")) {
			temp = new de1.Point(point1, point2);
			map.put(temp, colorOption);
		} else if (option_Shape.equals("Rect")) {
			temp = new de1.Rect(point1, point2);
			map.put(temp, colorOption);
		} else if (option_Shape.equals("Oval")) {
			temp = new de1.Oval(point1, point2);
			map.put(temp, colorOption);
		} else if (option_Shape.equals("Triangle")) {
			temp = new de1.Triangle(point1, point2);
			map.put(temp, colorOption);
		} else if (option_Shape.equals("Line")) {
			temp = new de1.Line(point1, point2);
			map.put(temp, colorOption);
		}
		for (Map.Entry<Shape, Color> e : map.entrySet()) {
			if (e.getKey().getOptionDelete().equals("Delete")) {

			} else if (listFill.contains(e.getKey())) {
				e.getKey().fillColor(g, e.getValue());
			} else {
				e.getKey().draw(g, e.getValue());
			}
		}
	}
}
