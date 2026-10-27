package de1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class PaintProgram extends JFrame {
	public PaintProgram() {
		this.init();
	}

	private JButton jbt_rect, jbt_line, jbt_oval, jbt_point, jbt_triangle, jbt_fillColor, jbt_chooseColor, jbt_delete;
	private JMenuBar jmb;
	private JMenu jmn_menu, jmn_help;
	private JButton jbt_red, jbt_blue, jbt_green, jbt_cyan, jbt_black, jbt_orange, jbt_pink, jbt_gray;
	private MakeJapanel jp_paint;

	private void init() {
		jmb = new JMenuBar();
		jp_paint = new MakeJapanel();
		this.setJMenuBar(jmb);
		jmn_help = new JMenu("Help");
		jmn_menu = new JMenu("Menu");

		jmb.add(jmn_menu);
		jmb.add(jmn_help);

		jbt_point = new JButton("Point");
		jbt_point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption_Shape("Point");
			}
		});
		jbt_line = new JButton("Line");
		jbt_line.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption_Shape("Line");
			}
		});
		jbt_rect = new JButton("Rectangle");
		jbt_rect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption_Shape("Rect");
			}
		});
		jbt_oval = new JButton("Oval");
		jbt_oval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption_Shape("Oval");
			}
		});
		jbt_triangle = new JButton("Triangle");
		jbt_triangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption_Shape("Triangle");
			}
		});
		jbt_fillColor = new JButton("FillColor");
		jbt_fillColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption("FillColor");
			}
		});
		jbt_chooseColor = new JButton("ChooseColor");
		jbt_delete = new JButton("Delete");
		jbt_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jp_paint.setOption("Delete");
			}
		});

		JPanel jp_flow_shape = new JPanel(new FlowLayout());
		jp_flow_shape.add(jbt_point);
		jp_flow_shape.add(jbt_line);
		jp_flow_shape.add(jbt_rect);
		jp_flow_shape.add(jbt_oval);
		jp_flow_shape.add(jbt_triangle);
		jp_flow_shape.add(jbt_fillColor);
		jp_flow_shape.add(jbt_chooseColor);
		jp_flow_shape.add(jbt_delete);

		List<JButton> listButton = new ArrayList<JButton>();
		JButton[] buttonColors = { jbt_red, jbt_blue, jbt_green, jbt_cyan, jbt_black, jbt_orange, jbt_pink, jbt_gray };
		Color[] colors = { Color.red, Color.blue, Color.green, Color.cyan, Color.black, Color.orange, Color.pink,
				Color.gray };

		JPanel jp_flow_color = new JPanel(new FlowLayout());
		jp_flow_color.setBackground(Color.black);
		jp_flow_shape.setBackground(Color.black);

		for (int i = 0; i < colors.length; i++) {
			buttonColors[i] = new JButton();
			listButton.add(buttonColors[i]);
			listButton.get(i).setBackground(colors[i]);
			jp_flow_color.add(listButton.get(i));
			int index = i;
			listButton.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jp_paint.setColorOption(colors[index]);
				}
			});
		}

		this.setLayout(new BorderLayout());
		this.add(jp_flow_shape, BorderLayout.NORTH);
		this.add(jp_paint, BorderLayout.CENTER);
		this.add(jp_flow_color, BorderLayout.SOUTH);
		this.setTitle("My Paint!!!");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new PaintProgram();
	}
}
