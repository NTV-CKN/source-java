package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class JpanelEdit extends JPanel {
	private String option = new String(), shape = new String();
	private Point point1 = new Point();
	private Color color = Color.black;
	private HashMap<Shape, Color> list = new HashMap<Shape, Color>();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public JpanelEdit() {
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				point1 = e.getPoint();
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		Shape shap;
		if (option.equals("Fill")) {
			if (shape.equals("Rect")) {
				shap = new Rect(point1, point1, option);
				list.put(shap, color);
				shap.fillShape(g, color);
			} else if (shape.equals("Oval")) {
				shap = new Oval(point1, point1, option);
				list.put(shap, color);
				shap.fillShape(g, color);
			} else {
				shap = new Line(point1, point1, option);
				list.put(shap, color);
				shap.fillShape(g, color);
			}
		} else if (option.equals("OutLine")) {
			if (shape.equals("Rect")) {
				shap = new Rect(point1, point1, option);
				list.put(shap, color);
				shap.draw(g, color);
			} else if (shape.equals("Oval")) {
				shap = new Oval(point1, point1, option);
				list.put(shap, color);
				shap.draw(g, color);
			} else {
				shap = new Line(point1, point1, option);
				list.put(shap, color);
				shap.draw(g, color);
			}
		}
		if (option.equals("Clear")) {
			for (Map.Entry<Shape, Color> iterable_element : list.entrySet()) {
				list.put(iterable_element.getKey(), Color.white);
			}
		}
		for (Map.Entry<Shape, Color> iterable_element : list.entrySet()) {
			if (iterable_element.getKey().option.equals("Fill")) {
				iterable_element.getKey().fillShape(g, iterable_element.getValue());
			} else {
				iterable_element.getKey().draw(g, iterable_element.getValue());
			}
		}
	}
}
