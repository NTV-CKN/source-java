package thide1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class jp_paint extends JPanel {
	private Point point1 = new Point(), point2 = new Point();
	private String saveOption = "Point";
	private Color color = Color.red;
	private HashMap<Shape, Color> list = new HashMap<Shape, Color>();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	private List<Shape> shapes;

	public jp_paint() {
		this.setBackground(Color.white);
		shapes = new ArrayList<Shape>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				point1 = e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				point2 = e.getPoint();
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (saveOption.equals("Delete")) {
			for (Shape shape : shapes) {
				if (point1.x >= Math.min(shape.getPoint1().x, shape.getPoint2().x)
						&& point1.x <= Math.max(shape.getPoint1().x, shape.getPoint2().x)
						&& point1.y >= Math.min(shape.getPoint1().y, shape.getPoint2().y)
						&& point1.y <= Math.max(shape.getPoint1().y, shape.getPoint2().y)) {
					shape.fill(g, Color.white);
					list.put(shape, Color.white);
				} else if (list.containsKey(shape)) {
					shape.fill(g, list.get(shape));
				} else {
					g.setColor(Color.black);
					shape.draw(g);
				}
			}
			return;
		} else if (saveOption.equals("Fill")) {
			int index = 0;
			for (Shape shape : shapes) {
				if (list.containsKey(shape)) {
					shape.fill(g, list.get(shape));
				} else if (point1.x >= Math.min(shape.getPoint1().x, shape.getPoint2().x)
						&& point1.x <= Math.max(shape.getPoint1().x, shape.getPoint2().x)
						&& point1.y >= Math.min(shape.getPoint1().y, shape.getPoint2().y)
						&& point1.y <= Math.max(shape.getPoint1().y, shape.getPoint2().y)) {
					shape.fill(g, color);
					list.put(shape, color);
					shapes.set(index, shape);
				} else {
					g.setColor(Color.black);
					shape.draw(g);
				}
				index++;
			}
			return;
		} else if (saveOption.equals("Point")) {
			shapes.add(new MyDot(point1, point2));
		} else if (saveOption.equals("Line")) {
			shapes.add(new MyLine(point1, point2));
		} else if (saveOption.equals("Triangle")) {
			shapes.add(new MyTriangle(point1, point2));
		} else if (saveOption.equals("Rect")) {
			shapes.add(new MyRect(point1, point2));
		} else if (saveOption.equals("Oval")) {
			shapes.add(new MyOval(point1, point2));
		}
		for (Shape shape : shapes) {
			g.setColor(Color.black);
			if (list.containsKey(shape)) {
				shape.fill(g, list.get(shape));
			}
			shape.draw(g);
		}
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public String getSaveOption() {
		return saveOption;
	}

	public void setSaveOption(String saveOption) {
		this.saveOption = saveOption;
	}
}
