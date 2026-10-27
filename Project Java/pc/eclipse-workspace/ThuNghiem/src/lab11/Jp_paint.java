package lab11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Jp_paint extends JPanel {
	private Point point1 = new Point(), point2 = new Point();
	private Color colorSave = Color.black;
	private String option;
	public Color getColorSave() {
		return colorSave;
	}

	public void setColorSave(Color colorSave) {
		this.colorSave = colorSave;
	}

	private HashMap<Shape, Color> list = new HashMap<Shape, Color>();

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

	public Jp_paint() {
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
		list.put(new Rectangle(point1, point2), colorSave);
		for (Map.Entry<Shape, Color> shapes : list.entrySet()) {
			shapes.getKey().drawRect(g, shapes.getValue());
		}
	}
}
