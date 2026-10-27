package de7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuanLyTacPhamHoiHoa extends JFrame {
	public QuanLyTacPhamHoiHoa() {
		this.init();
	}

	private JLabel jlb_tpHoiHoa, jlb_tentp, jlb_namST, jlb_loaiTranh, jlb_phongCach, jlb_tacGia;
	private JButton jbt_add, jbt_sort;
	private JTextField jtf_tpHoiHoa, jtf_namST;
	private JComboBox<String> jcbk_loaiTranh, jcbk_phongCach, jcbk_tacGia;
	private JPanel jp_grid, jp_flow;
	private JTextArea jta_show;
	private JScrollPane jscroll;
	private Cau3 cau3 = new Cau3();

	private void init() {
		cau3.createArray();
		jta_show = new JTextArea();
		this.paintList();
		jscroll = new JScrollPane(jta_show);

		jp_flow = new JPanel(new FlowLayout());
		jp_grid = new JPanel(new GridLayout(5, 2));

		jtf_namST = new JTextField();
		jtf_tpHoiHoa = new JTextField();

		String[] loaitranhs = { "Son dau", "Son mai", "Gom", "Don sac", "Men", "Thuy mac" };
		String[] phongcachs = { "Co dien", "Hien dai" };
		String[] tacgias = { "Leonardo Da Vinci", "Vincent Vangogh", "Botero" };

		jcbk_loaiTranh = new JComboBox<String>(loaitranhs);
		jcbk_phongCach = new JComboBox<String>(phongcachs);
		jcbk_tacGia = new JComboBox<String>(tacgias);

		jlb_loaiTranh = new JLabel("Loai tranh", JLabel.CENTER);
		jlb_namST = new JLabel("Nam sang tac", JLabel.CENTER);
		jlb_phongCach = new JLabel("Phong cach", JLabel.CENTER);
		jlb_tacGia = new JLabel("Tac gia", JLabel.CENTER);
		jlb_tentp = new JLabel("Ten tac pham", JLabel.CENTER);
		jlb_tpHoiHoa = new JLabel("TAC PHAM HOI HOA", JLabel.CENTER);

		jbt_add = new JButton("Them");
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArtObject temp = new Painting(jcbk_tacGia.getSelectedItem().toString(), jtf_tpHoiHoa.getText(),
							Integer.valueOf(jtf_namST.getText()), jcbk_loaiTranh.getSelectedItem().toString(),
							jcbk_phongCach.getSelectedItem().toString());
					cau3.getList().add(temp);
					paintList();
				} catch (Exception e2) {
					JOptionPane option = new JOptionPane("Nam sang tac phai la so nguyen");
					option.showMessageDialog(option, "Nam sang tac phai la so nguyen");
				}

			}
		});
		jbt_sort = new JButton("Sap xep");
		jbt_sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(cau3.getList());
				paintList();
			}
		});

		jp_grid.add(jlb_tentp);
		jp_grid.add(jtf_tpHoiHoa);
		jp_grid.add(jlb_namST);
		jp_grid.add(jtf_namST);
		jp_grid.add(jlb_loaiTranh);
		jp_grid.add(jcbk_loaiTranh);
		jp_grid.add(jlb_phongCach);
		jp_grid.add(jcbk_phongCach);
		jp_grid.add(jlb_tacGia);
		jp_grid.add(jcbk_tacGia);

		jp_flow.add(jbt_add);
		jp_flow.add(jbt_sort);

		JPanel jp = new JPanel(new BorderLayout());
		jp.add(jp_grid, BorderLayout.CENTER);
		jp.add(jp_flow, BorderLayout.SOUTH);
		jp.add(jlb_tpHoiHoa, BorderLayout.NORTH);

		JPanel jp2 = new JPanel(new BorderLayout());
		jp2.add(new JLabel("Thong tin ve tac pham"), BorderLayout.NORTH);
		jp2.add(jscroll, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.setTitle("Quan li tac pham hoi hoa");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void paintList() {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < cau3.getList().size(); i++) {
			strB.append((i + 1) + "- " + cau3.getList().get(i).getTenTacPham() + "\t\t"
					+ cau3.getList().get(i).getTenTacGia() + "\t\t" + cau3.getList().get(i).getYear() + "\n");
		}
		jta_show.setText(strB.toString());
	}

	public static void main(String[] args) {
		new QuanLyTacPhamHoiHoa();
	}
}
