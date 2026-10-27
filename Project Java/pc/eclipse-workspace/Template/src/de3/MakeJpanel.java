package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class MakeJpanel extends JPanel {
	private String optionDraw = "", optionFill = "";
	private Color optionColor = Color.black;
	private Point point = new Point(), point2 = new Point();
	private HashMap<Shape, Color> map = new HashMap<Shape, Color>();

	public MakeJpanel() {
		setBackground(Color.white);
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {

			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				point = e.getPoint();
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(optionDraw);
		Shape temp;
		if (optionDraw.equals("Oval")) {
			temp = new Oval(point, point2);
			temp.setStat(optionFill);
			map.put(temp, optionColor);
		} else if (optionDraw.equals("Rect")) {
			temp = new Rect(point, point2);
			temp.setStat(optionFill);
			map.put(temp, optionColor);
		} else if (optionDraw.equals("Line")) {
			temp = new Line(point, point2);
			temp.setStat(optionFill);
			map.put(temp, optionColor);
		}else if(optionDraw.equals("null")) {
			for (Map.Entry<Shape, Color> e : map.entrySet()) {
				e.getKey().setStat("null");
			}
		}

		
		for (Map.Entry<Shape, Color> e : map.entrySet()) {
			if (e.getKey().getStat().equals("Fill")) {
				e.getKey().fill(g, e.getValue());
			} else if (e.getKey().getStat().equals("Outline")) {
				e.getKey().outline(g, e.getValue());
			}
		}
	}

	public void setOptionDraw(String str) {
		this.optionDraw = str;
	}

	public void setOptionColor(Color color) {
		this.optionColor = color;
	}

	public void setOptionFill(String str) {
		this.optionFill = str;
	}
}
