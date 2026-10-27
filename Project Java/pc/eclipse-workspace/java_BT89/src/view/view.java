package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class view extends JFrame{
	private JPanel jp1;

	public view() {
		this.init();
	}

	private void init() {
		this.setTitle("Menu");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//JMenuBar
		JMenuBar jmb = new JMenuBar();
		
		//JMenu
		JMenu jm1 = new JMenu("File");
		JMenu jm2 = new JMenu("Edit");
		JMenu jm3 = new JMenu("Source");
		JMenu jm4 = new JMenu("Refactor");
		JMenu jm5 = new JMenu("Navigate");
		JMenu jm6 = new JMenu("Search");
		JMenu jmN = new JMenu("New");
		//JMenuItem in 1 2 3 4 5 6
		JMenuItem jmi1 = new JMenuItem("Open file");
		JMenuItem jmi2 = new JMenuItem("Undo typing");
		JMenuItem jmi3 = new JMenuItem("Generate Constructor using Fields");
		JMenuItem jmi4 = new JMenuItem("Rename");
		JMenuItem jmi5 = new JMenuItem("Back");
		JMenuItem jmi6 = new JMenuItem("Search");
		JMenuItem jmiN = new JMenuItem("Java Project");
		//add jmN
		jmN.add(jmiN);
		jm1.add(jmN);
		//add jmenubar
		this.setLayout(new BorderLayout());
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		this.setLayout(new BorderLayout());
		this.jp1 = new JPanel();
		jp1.setBackground(Color.CYAN);
		this.add(jp1);
		this.add(jmb, BorderLayout.NORTH);

		
		
		this.setVisible(true);
	}
}
