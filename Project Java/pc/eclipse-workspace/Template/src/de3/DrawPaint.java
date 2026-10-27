package de3;

import java.awt.BorderLayout;
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

public class DrawPaint extends JFrame{
	public DrawPaint() {
		this.init();
	}

	private JMenu jmn_hinh, jmn_mau;
	private JMenuBar jmb;
	private JMenuItem jmni_oval, jmni_rect, jmni_line, jmni_xanh, jmni_do, jmni_vang;
	private ButtonGroup bgMau, bgType;
	private JRadioButton jrd_green, jrd_red, jrd_yellow, jrd_fill, jrd_outline;
	private MakeButton jbtmake_do, jbtmake_den, jbtmake_trang, jbtmake_vang, jbtmake_xanh, jbtmake_luc;
	private JButton jbt_clear, jbt_exit;	
	private MakeJpanel makeJapnel;
	private JPanel jp_grid_tool, jp_grid_type, jp_grid_color, jp_grid_button;
	private JLabel jlb_tool, jlb_select, jlb_color;
	
	private void init() {
		makeJapnel = new MakeJpanel();
		
		jlb_color = new JLabel("Color");
		jlb_tool = new JLabel("Tool");
		jlb_select = new JLabel("Select Type");
		
		jbtmake_do = new MakeButton();
		jbtmake_do.setBackground(Color.red);
		
		jbtmake_den = new MakeButton();
		jbtmake_den.setBackground(Color.black);
		
		jbtmake_luc = new MakeButton();
		jbtmake_luc.setBackground(Color.green);
		
		jbtmake_trang = new MakeButton();
		jbtmake_trang.setBackground(Color.white);
		
		jbtmake_vang = new MakeButton();
		jbtmake_vang.setBackground(Color.yellow);
		
		jbtmake_xanh = new MakeButton();
		jbtmake_xanh.setBackground(Color.blue);
		
		jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		
		jmn_hinh = new JMenu("Hinh");
		jmn_mau = new JMenu("Mau");
		
		jmb.add(jmn_hinh); jmb.add(jmn_mau);
		
		jmni_do = new JMenuItem("Do");
		jmni_vang = new JMenuItem("Vang");
		jmni_xanh = new JMenuItem("Xanh");
		jmn_mau.add(jmni_do); jmn_mau.add(jmni_xanh); jmn_mau.add(jmni_vang);
		
		jmni_line = new JMenuItem("Line");
		jmni_line.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeJapnel.setOptionDraw("Line");
			}
		});
		
		jmni_oval = new JMenuItem("Oval");
		jmni_oval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeJapnel.setOptionDraw("Oval");
			}
		});
		
		jmni_rect = new JMenuItem("Rect");
		jmni_rect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeJapnel.setOptionDraw("Rect");
			}
		});
		
		jmn_hinh.add(jmni_line);jmn_hinh.add(jmni_oval);jmn_hinh.add(jmni_rect);
		
		jrd_fill = new JRadioButton("fill");
		jrd_fill.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				makeJapnel.setOptionFill("Fill");
			}
		});
		
		jrd_outline = new JRadioButton("outline");
		jrd_outline.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				makeJapnel.setOptionFill("Outline");

			}
		});
		
		bgType = new ButtonGroup();
		bgType.add(jrd_fill); bgType.add(jrd_outline);
		
		jrd_green = new JRadioButton("Green");
		jrd_green.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				makeJapnel.setOptionColor(Color.green);
	
			}
		});
		jrd_red = new JRadioButton("Red");
		jrd_red.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				makeJapnel.setOptionColor(Color.red);

			}
		});
		jrd_yellow = new JRadioButton("Yellow");
		jrd_yellow.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				makeJapnel.setOptionColor(Color.yellow);
			}
		});
		bgMau = new ButtonGroup();
		bgMau.add(jrd_green); bgMau.add(jrd_red); bgMau.add(jrd_yellow);
		
		jbt_clear = new JButton("Clear"); 
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeJapnel.setOptionDraw("null");
				repaint();
			}
		});
		jbt_exit = new JButton("Exit");
		jbt_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jp_grid_color = new JPanel(new GridLayout(3,3));
		jp_grid_color.add(jlb_color); jp_grid_color.add(new JLabel());
		jp_grid_color.add(new JLabel());
		jp_grid_color.add(jbtmake_den);jp_grid_color.add(jbtmake_do);
		jp_grid_color.add(jbtmake_luc);jp_grid_color.add(jbtmake_trang);
		jp_grid_color.add(jbtmake_vang);jp_grid_color.add(jbtmake_xanh);
		
		jp_grid_button = new JPanel(new GridLayout(3,1));
		jp_grid_button.add(jbt_clear); jp_grid_button.add(new JLabel()); jp_grid_button.add(jbt_exit);
		
		jp_grid_tool = new JPanel(new GridLayout(2,3));
		jp_grid_tool.add(jlb_tool); jp_grid_tool.add(new JLabel()); jp_grid_tool.add(new JLabel()); 
		jp_grid_tool.add(jrd_green); jp_grid_tool.add(jrd_red); jp_grid_tool.add(jrd_yellow);
		
		jp_grid_type = new JPanel(new GridLayout(2,2));
		jp_grid_type.add(jlb_select); jp_grid_type.add(new JLabel());
		jp_grid_type.add(jrd_fill);jp_grid_type.add(jrd_outline);
				
		JPanel jp = new JPanel(new GridLayout(1, 4));
		jp.add(jp_grid_tool);
		jp.add(jp_grid_type);
		jp.add(jp_grid_color);
		jp.add(jp_grid_button);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);
		this.add(makeJapnel, BorderLayout.CENTER);
		this.setTitle("Draw  Paint");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DrawPaint();
	}
}
