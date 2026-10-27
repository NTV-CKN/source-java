package de3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class ButtonEdit extends JButton{
	public ButtonEdit(Color color) {
		this.setBackground(color);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine(0, 0, getWidth(), getHeight());
		g2d.dispose();
	}
}
