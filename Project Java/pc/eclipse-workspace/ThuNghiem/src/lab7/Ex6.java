package lab7;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex6 extends JFrame {
	private JComboBox<String> jcb;
	private JLabel jlb_display;

	public Ex6() {
		this.init();
	}

	public void init() {
		String[] str = { "anime1.jpg", "anime2.jpg", "anime3.jpg" };
		jcb = new JComboBox<String>(str);
		jlb_display = new JLabel(new ImageIcon(
							"D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/anime1.jpg"));
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = (String) jcb.getSelectedItem();
				System.out.println(str);
				if (str.equals("anime1.jpg")) {
					jlb_display.setIcon(new ImageIcon(
							"D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/anime1.jpg"));
					//add(jlb_display, BorderLayout.CENTER);
				} else if (str.equals("anime2.jpg")) {
					jlb_display.setIcon(new ImageIcon(
							"D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/anime2.jpg"));
				//	add(jlb_display, BorderLayout.CENTER);
				} else {
					jlb_display.setIcon(new ImageIcon(
							"D:/esclipse/Project Java/pc/eclipse-workspace/ThuNghiem/src/image/anime3.jpg"));
				}
			}
		});

		this.setLayout(new BorderLayout());
		this.add(jcb, BorderLayout.NORTH);
		this.add(jlb_display, BorderLayout.CENTER);
		this.setTitle("Ex6");
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex6();
	}
}
