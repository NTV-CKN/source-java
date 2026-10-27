package lab10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex3 extends JFrame {
	private List<ModelEx3> listModel;
	private JPanel jp_grid;
	private JTextArea jtxa;
	private JButton jbt_add, jbt_sort;
	private JLabel jlb_inf, jlb_name, jlb_year, jlb_loaiTranh, jlb_pcach, jlb_tg;
	private JTextField jtf_name, jtf_year;
	private JComboBox<String> jcb_sd, jcb_pc, jcb_tg;

	public Ex3() {
		this.init();
	}

	public void init() {
		jtf_name = new JTextField();
		jtxa = new JTextArea();

		jlb_inf = new JLabel("Infor");
		jlb_name = new JLabel("name");
		jlb_year = new JLabel("Year");
		jlb_loaiTranh = new JLabel("Loai tranh");
		jlb_pcach = new JLabel("Phong cach");
		jlb_tg = new JLabel("Tac gia");

		jtf_year = new JTextField();
		String[] arr = { "Son dau" };
		String[] arr2 = { "phong canh" };
		String[] arr3 = { "Tac gia" };

		jcb_sd = new JComboBox<String>(arr);
		jcb_pc = new JComboBox<String>(arr2);
		jcb_tg = new JComboBox<String>(arr3);

		listModel = new ArrayList<ModelEx3>();
		listModel.add(new ModelEx3("Tranh 1", "Mua he"));
		listModel.add(new ModelEx3("Tranh 2", "Mua dong"));
		listModel.add(new ModelEx3("Tranh 3", "Mua thu"));
		listModel.add(new ModelEx3("Tranh 4", "Mua xuan"));
		listModel.add(new ModelEx3("Tranh5", "Mua fa"));
		jtxa.setText(listModel.toString());
		jbt_add = new JButton("Add",
				new ImageIcon("D:\\esclipse\\Project Java\\pc\\eclipse-workspace\\ThuNghiem\\src\\image\\plus.png"));
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.add(new ModelEx3(jtf_name.getText(), jtf_year.getText()));
				jtxa.setText(listModel.toString());
			}
		});
		jbt_sort = new JButton("Sort");
		jbt_sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(listModel);
				jtxa.setText(listModel.toString());
			}
		});
		jp_grid = new JPanel(new GridLayout(7, 2));
		jp_grid.add(jlb_name);
		jp_grid.add(jtf_name);
		jp_grid.add(jlb_year);
		jp_grid.add(jtf_year);
		jp_grid.add(jlb_loaiTranh);
		jp_grid.add(jcb_sd);
		jp_grid.add(jlb_pcach);
		jp_grid.add(jcb_pc);
		jp_grid.add(jlb_tg);
		jp_grid.add(jcb_tg);
		jp_grid.add(jbt_add);
		jp_grid.add(jbt_sort);
		jp_grid.add(jlb_inf);

		this.setLayout(new GridLayout(3,1));
		this.add(new JLabel("Ve tranh"));
		this.add(jp_grid);
		this.add(jtxa);
		this.setTitle("Ex3");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex3();
	}
}
