package lab8;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class Ex10 extends JFrame {
	private JScrollBar hjscb, vjscb;
	private JLabel jlb_image;

	public Ex10() {
		this.init();
	}

	public void init() {
		hjscb = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 200);
		hjscb.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				jlb_image.setText("Horizon: " + hjscb.getValue() + ", vertical: " + vjscb.getValue());
			}
		});
		vjscb = new JScrollBar(JScrollBar.VERTICAL, 30, 20, 0, 200);
		vjscb.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				jlb_image.setText("Horizon: " + hjscb.getValue() + ", vertical: " + vjscb.getValue());
			}
		});
		jlb_image = new JLabel(" ",
				new ImageIcon("D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/anime1.jpg"),
				DEFAULT_CURSOR);

		this.setLayout(new BorderLayout());
		this.add(hjscb, BorderLayout.SOUTH);
		this.add(vjscb, BorderLayout.EAST);
		this.add(jlb_image, BorderLayout.CENTER);
		this.setTitle("JScrollBar Demo");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex10();
	}
}
