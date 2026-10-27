package lab7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex7 extends JFrame {
	private JComboBox<String> jcb;
	private JLabel jlb_display;
	private String[] colors= {"red", "yellow", "green","cyan","black", "dark gray", "gray", "pink"};

	public Ex7() {
		this.init();
	}
	public void init() {
		jcb = new JComboBox<String>(colors);
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = (String) jcb.getSelectedItem();
				System.out.println(str);
				if(str.equals("red")) {
					jlb_display.setBackground(Color.RED);
				}else if(str.equals("green")) {
					jlb_display.setBackground(Color.green);
				}else if(str.equals("yellow")) {
					jlb_display.setBackground(Color.yellow);
				}else if(str.equals("cyan")) {
					jlb_display.setBackground(Color.cyan);
				}else if(str.equals("black")) {
					jlb_display.setBackground(Color.black);
				}else if(str.equals("dark gray")) {
					jlb_display.setBackground(Color.DARK_GRAY);
				}else if(str.equals("gray")) {
					jlb_display.setBackground(Color.gray);
				}else if(str.equals("pink")) {
					jlb_display.setBackground(Color.pink);
				}
			}
		});
		jlb_display = new JLabel();
		jlb_display.setBackground(Color.BLACK);
		jlb_display.setOpaque(true);
		
		this.setLayout(new BorderLayout());
		this.add(jcb, BorderLayout.NORTH);
		this.add(jlb_display, BorderLayout.CENTER);
		this.setTitle("Ex7");
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex7();
	}
}
