package bufferimage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test extends JPanel {
	BufferedImage bg;
	Timer timer;
	int indexCur = 0;
	int x = 20;
	JLabel lb;
	public Test() throws IOException {
		setLayout(null);
		timer= new Timer(2000, (e) -> {repaint();});
		bg = ImageIO.read(getClass().getResourceAsStream("bg.png"));
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("happy.gif"));

	 lb= new JLabel(imageIcon);
		lb.setSize(100, 100);
		lb.setLocation(20, 400);timer.start();
		this.add(lb);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(bg, 0, 0, 800, 600, null);
		if(lb != null) lb.setLocation(++x, 400);
		
	}
}
