package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class view extends JFrame{
	private PaintComponent paint;
	//constructor 
	public view() {
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.paint = new PaintComponent();
		this.setLayout(new BorderLayout());
		this.add(paint, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
