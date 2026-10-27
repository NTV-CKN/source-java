package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.controller;

public class view extends JFrame{
	private JPanel jp1;
	private JLabel jlb;
	private JMenuItem jmiN;
	private JMenuItem jmi6;
	private JMenuItem jmi5;
	private JMenuItem jmi4;
	private JMenuItem jmi3;
	private JMenuItem jmi2;
	private JMenuItem jmi1;
	private JButton jb3;
	private JButton jb2;
	private JButton jb1;
	private JMenu jmpp1;
	private JMenu jmpp2;
	private JMenuItem jmppi1;
	public JPopupMenu jppm;

	public view() {
		this.init();
	}

	private void init() {
		this.setTitle("Menu");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ac
		controller ac = new controller(this);
		//JMenuBar
		JMenuBar jmb = new JMenuBar();
		
		//JMenu
		JMenu jm1 = new JMenu("File");
		JMenu jm2 = new JMenu("Edit");
		JMenu jm3 = new JMenu("Source");
		JMenu jm4 = new JMenu("Refactor");
		JMenu jm5 = new JMenu("Navigate");
		JMenu jm6 = new JMenu("Search");
		JMenu jmNN = new JMenu("New");
		//JMenuItem in 1 2 3 4 5 6
		 this.jmi1 = new JMenuItem("Open file", KeyEvent.VK_F);
		 this.jmi2 = new JMenuItem("Undo typing", KeyEvent.VK_U);
		 this.jmi3 = new JMenuItem("Generate Constructor using Fields", KeyEvent.VK_G);
		this.jmi4 = new JMenuItem("Rename", KeyEvent.VK_R);
		this.jmi5 = new JMenuItem("Back", KeyEvent.VK_B);
		 this.jmi6 = new JMenuItem("Search", KeyEvent.VK_S);
		this.jmiN = new JMenuItem("Java Project", KeyEvent.VK_J);
		//add jmN
		jmNN.add(jmiN);
		jm1.add(jmNN);
		//add ac
		jmi1.addActionListener(ac);
		jmi2.addActionListener(ac);
		jmi3.addActionListener(ac);
		jmi4.addActionListener(ac);
		jmi5.addActionListener(ac);
		jmi6.addActionListener(ac);
		jmiN.addActionListener(ac);
		//jitem into jmenu
		jm1.add(jmi1);
		jm2.add(jmi2);
		jm3.add(jmi3);
		jm4.add(jmi4);
		jm5.add(jmi5);
		jm6.add(jmi6);
		//jtoolbar
		JToolBar jtb = new JToolBar();
		//jpopupmenu
		 jppm = new JPopupMenu();
		//jmenu cua jpopup
		 jmpp1 = new JMenu("Undo typing");
		 jmpp2 = new JMenu("Open with");
		
		 jmppi1 = new JMenuItem("Undo");
		jmpp1.add(jmppi1);
		
		//add jpopup 
		this.jppm.add(jmpp1);
		this.jppm.add(jmpp2);
		// button jtoolbar
		 jb1 = new JButton("Save");
		 this.jb1.addActionListener(ac);
		 this.jb1.setToolTipText("Dung de save");
		 jb2 = new JButton("Cut");
		 this.jb2.addActionListener(ac);
		 this.jb2.setToolTipText("Dung de Cut");
		 jb3 = new JButton("Copy");
		 this.jb3.addActionListener(ac);
		 this.jb3.setToolTipText("Dung de Copy");
		//add jtoolbar jbutton
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		
		
		//add jmenubar
		this.setLayout(new BorderLayout());
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		//add setAccelerators
		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		jmi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		jmi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		jmi5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		jmi6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jmiN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));

		//setJmenuBar
		this.setJMenuBar(jmb);
		
		this.setLayout(new BorderLayout());
		
		//jlabel
		this.jlb = new JLabel("ddhhhhhhhhhhhhh", JLabel.CENTER);
		Font f = new Font("Arial", Font.BOLD, 30);
		this.jlb.setFont(f);
		//jpanel
		this.jp1 = new JPanel(new BorderLayout());
		this.jp1.add(jlb);
	
		this.jp1.add(jtb, BorderLayout.NORTH);
		jp1.setBackground(Color.BLUE);
		this.add(jp1, BorderLayout.CENTER);
		this.add(jmb, BorderLayout.NORTH);
		
		this.addMouseListener(ac);
		this.jppm.addMouseListener(ac);
		
		this.setVisible(true);
	}
	public void setTextNe(String e) {
		this.jlb.setText("Ban da nhan nut " +e);
	}

}
