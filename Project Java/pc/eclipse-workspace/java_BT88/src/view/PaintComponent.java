package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PaintComponent extends JPanel{

	private Image pic;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.cyan);
		
		g.drawRect(500, 300, 333, 333);
		g.setColor(Color.BLACK);
	    pic = Toolkit.getDefaultToolkit().getImage("anime");

	    g.draw3DRect(200, 300, 1100, 200, getFocusTraversalKeysEnabled());
	}
	
}
