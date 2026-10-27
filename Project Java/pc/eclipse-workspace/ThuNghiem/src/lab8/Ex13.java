package lab8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex13 extends JFrame {
	private JTextField jtxf;
	private JButton jbt_Backspace, jbt_c, jbt_ce, jbt_plus, jbt_minus, jbt_divide, jbt_multi, jbt_plaski, jbt_dot;
	private List<JButton> listButton;
	private JMenuBar jmb;
	private JMenu jmn_file, jmn_help;
	private JPanel jp;
//	private String[] save;
//	private int indexCur = 0;

	public Ex13() {
		this.init();
	}

	public void init() {
		listButton = new ArrayList<JButton>();

		jmb = new JMenuBar();

		jmn_file = new JMenu("File");
		jmn_file.setMnemonic('F');
		jmn_help = new JMenu("Help");
		jmn_help.setMnemonic('H');

		jmb.add(jmn_file);
		jmb.add(jmn_help);
		this.setJMenuBar(jmb);

		jtxf = new JTextField(2);
		jp = new JPanel(new GridLayout(5, 4));

		jbt_Backspace = new JButton("Backspace");
		jp.add(jbt_Backspace);
		jp.add(new JLabel());

		jbt_c = new JButton("C");
		jp.add(jbt_c);
		jbt_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText("");
			}
		});

		jbt_ce = new JButton("CE");
		jp.add(jbt_ce);
		jbt_ce.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cur = jtxf.getCaretPosition() - 1;
				if (cur >= 0) {
					System.out.println(cur);
					StringBuilder str = new StringBuilder(jtxf.getText());
					str.deleteCharAt(cur);
					jtxf.setText(str.toString());
				}

			}
		});

		jbt_plus = new JButton("+");
		jp.add(jbt_plus);
		jbt_plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText(jtxf.getText() + "+");
			}
		});

		jbt_minus = new JButton("-");
		jp.add(jbt_minus);
		jbt_minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText(jtxf.getText() + "-");
			}
		});

		jbt_multi = new JButton("*");
		jp.add(jbt_multi);
		jbt_multi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText(jtxf.getText() + "*");
			}
		});

		jbt_divide = new JButton("/");
		jp.add(jbt_divide);
		jbt_divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText(jtxf.getText() + "/");
			}
		});

		jbt_plaski = new JButton("=");
		jp.add(jbt_plaski);
		jbt_plaski.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jtxf.getText();
				List<Double> list = new ArrayList<Double>();
				List<Character> listCh = new ArrayList<Character>();
				int index = 0;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '+') {
						listCh.add(str.charAt(i));
						String sub = str.substring(index, i);
						System.out.println(sub);
						list.add(Double.parseDouble(sub));
						index = i + 1;
						continue;
					} else if (str.charAt(i) == '-') {
						listCh.add(str.charAt(i));
						String sub = str.substring(index, i);
						list.add(Double.parseDouble(sub));
						System.out.println(sub);
						index = i + 1;
						continue;
					} else if (str.charAt(i) == '*') {
						listCh.add(str.charAt(i));
						String sub = str.substring(index, i );
						list.add(Double.parseDouble(sub));
						index = i + 1;
						continue;
					} else if (str.charAt(i) == '/') {
						listCh.add(str.charAt(i));
						String sub = str.substring(index, i );
						list.add(Double.parseDouble(sub));
						index = i + 1;
						continue;
					}
				}
				list.add(Double.parseDouble(str.substring(index, str.length())));
				System.out.println(str.substring(index, str.length() ));
				double save = 0;
				index = 0;
				for (int i = 0; i < list.size() - 1; i++) {
					if (listCh.get(index) == '+') {
						save = plus(list.get(i), list.get(i + 1));
						list.set(i + 1, save);
						index++;
						continue;
					} else if (listCh.get(index) == '-') {
						save = minus(list.get(i), list.get(i + 1));
						list.set(i + 1, save);
						index++;
						continue;
					} else if (listCh.get(index) == '*') {
						save = multi(list.get(i), list.get(i + 1));
						list.set(i + 1, save);
						index++;
						continue;
					} else if (listCh.get(index) == '/') {
						save = divide(list.get(i), list.get(i + 1));
						list.set(i + 1, save);
						index++;
						continue;
					}
				}
				jtxf.setText(list.get(list.size() - 1) + "");

			}
		});

		jbt_dot = new JButton(".");
		jp.add(jbt_dot);
		jbt_dot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf.setText(jtxf.getText() + ".");
			}
		});

		for (int i = 0; i < 10; i++) {
			listButton.add(new JButton(i + ""));
			jp.add(listButton.get(i));
			listButton.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jtxf.setText(jtxf.getText() + e.getActionCommand());
				}
			});
		}

		this.setLayout(new BorderLayout());
		this.add(jtxf, BorderLayout.NORTH);
		this.add(jp);
		this.setTitle("JScrollBar Demo");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public double plus(double x, double y) {
		return x + y;
	}

	public double minus(double x, double y) {
		return x - y;
	}

	public double multi(double x, double y) {
		return x * y;
	}

	public double divide(double x, double y) {
		if (y == 0) {
			return -1;
		}
		return x / y;
	}

	public static void main(String[] args) {
		new Ex13();
	}
}
