package de3;

import java.awt.Graphics;

import javax.swing.JButton;

public class MakeButton extends JButton {
	public MakeButton() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, getWidth(), getHeight());
	}
}
