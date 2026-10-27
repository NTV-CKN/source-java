package de3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GuiDrawPaint extends JFrame {
	private JMenuBar jmb;
	private JMenu jmn_Hinh, jmn_Mau;
	private JMenuItem jmni_Oval, jmni_Rect, jmni_Line, jmni_Green, jmni_Red, jmni_Yellow;
	private JRadioButton jrd_Green, jrd_Red, jrd_Yellow, jrd_Fill, jrd_Outline;
	private ButtonGroup bg;
	private JButton jbt_Clear, jbt_Exit;
	private JLabel jlb_tool, jlb_SelectT, jlb_Color, jlb_null;
	private ButtonEdit bE_red, bE_black, bE_white, bE_yellow, bE_blue, bE_green;
	private JPanel jp_tool, jp_SelectT, jp_ChooseColor, jp_Button;
	private JpanelEdit jp_Edit;
	private String option, shape;

	public GuiDrawPaint() {
		this.init();
	}

	private void init() {
		jp_Edit = new JpanelEdit();
		// jlb
		jlb_Color = new JLabel("Choose color");
		jlb_null = new JLabel();
		jlb_SelectT = new JLabel("Select Type");
		jlb_tool = new JLabel("Tool");

		// jbutton clear exit
		jbt_Clear = new JButton("Clear");
		jbt_Clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setOption("Clear");
				repaint();
			}
		});
		jbt_Exit = new JButton("Exit");
		jbt_Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// jradio and buttongroup
		jrd_Fill = new JRadioButton("Fill");
		jrd_Fill.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				jp_Edit.setOption("Fill");
			}
		});
		jrd_Outline = new JRadioButton("Outline");
		jrd_Outline.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				jp_Edit.setOption("OutLine");
			}
		});
		jrd_Green = new JRadioButton("Green");
		jrd_Green.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				jp_Edit.setColor(Color.green);
			}
		});
		jrd_Red = new JRadioButton("Red");
		jrd_Red.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				jp_Edit.setColor(Color.red);
			}
		});
		jrd_Yellow = new JRadioButton("Yellow");
		jrd_Yellow.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				jp_Edit.setColor(Color.yellow);
			}
		});

		bg = new ButtonGroup();
		bg.add(jrd_Fill);
		bg.add(jrd_Green);
		bg.add(jrd_Outline);
		bg.add(jrd_Red);
		bg.add(jrd_Yellow);

		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_Hinh = new JMenu("Hinh");
		jmn_Mau = new JMenu("Mau");

		jmni_Green = new JMenuItem("Green");
		jmni_Green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.green);
			}
		});
		jmni_Line = new JMenuItem("Line");
		jmni_Line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setShape("Line");
			}
		});
		jmni_Oval = new JMenuItem("Oval");
		jmni_Oval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setShape("Oval");
			}
		});
		jmni_Rect = new JMenuItem("Rect");
		jmni_Rect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setShape("Rect");
			}
		});
		jmni_Red = new JMenuItem("Red");
		jmni_Red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.red);
			}
		});
		jmni_Yellow = new JMenuItem("Yellow");
		jmni_Yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.yellow);
			}
		});

		jmn_Hinh.add(jmni_Oval);
		jmn_Hinh.add(jmni_Line);
		jmn_Hinh.add(jmni_Rect);

		jmn_Mau.add(jmni_Green);
		jmn_Mau.add(jmni_Red);
		jmn_Mau.add(jmni_Yellow);

		jmb.add(jmn_Hinh);
		jmb.add(jmn_Mau);

		// jpanel
		jp_Button = new JPanel(new GridLayout(3, 1));
		jp_ChooseColor = new JPanel(new GridLayout(3, 3));

		jp_SelectT = new JPanel(new GridLayout(2, 2));
		jp_tool = new JPanel(new GridLayout(2, 4));

		// Button edit
		bE_black = new ButtonEdit(Color.black);
		bE_black.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.black);
			}
		});
		bE_blue = new ButtonEdit(Color.blue);
		bE_blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.blue);
			}
		});
		bE_green = new ButtonEdit(Color.green);
		bE_green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.green);
			}
		});
		bE_red = new ButtonEdit(Color.red);
		bE_red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.red);
			}
		});
		bE_white = new ButtonEdit(Color.white);
		bE_white.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.white);
			}
		});
		bE_yellow = new ButtonEdit(Color.yellow);
		bE_yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_Edit.setColor(Color.yellow);
			}
		});

		// set jpanel
		jp_SelectT.add(jlb_SelectT);
		jp_SelectT.add(new JLabel());
		jp_SelectT.add(jrd_Fill);
		jp_SelectT.add(jrd_Outline);

		jp_tool.add(jlb_tool);
		for (int i = 0; i < 3; i++) {
			jp_tool.add(new JLabel());
		}
		jp_tool.add(jrd_Green);
		jp_tool.add(jrd_Red);
		jp_tool.add(jrd_Yellow);
		jp_tool.add(jp_SelectT);

		jp_ChooseColor.add(jlb_Color);
		jp_ChooseColor.add(new JLabel());
		jp_ChooseColor.add(new JLabel());
		jp_ChooseColor.add(bE_black);
		jp_ChooseColor.add(bE_blue);
		jp_ChooseColor.add(bE_green);
		jp_ChooseColor.add(bE_red);
		jp_ChooseColor.add(bE_white);
		jp_ChooseColor.add(bE_yellow);

		jp_Button.add(jbt_Clear);
		jp_Button.add(jlb_null);
		jp_Button.add(jbt_Exit);

		jp_Edit.setBackground(Color.white);

		JPanel jp_All = new JPanel(new FlowLayout());
		jp_All.add(jp_tool);
		jp_All.add(jp_ChooseColor);
		jp_All.add(jp_Button);

		this.setLayout(new GridLayout(2, 1));
		this.add(jp_All);
		this.add(jp_Edit);
		this.setTitle("Draw Paint");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GuiDrawPaint();
	}
}
