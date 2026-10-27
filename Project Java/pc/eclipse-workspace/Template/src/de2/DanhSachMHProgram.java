package de2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DanhSachMHProgram extends JFrame {
	public DanhSachMHProgram() {
		this.init();
	}

	private JMenuBar jmb;
	private JMenu jmn_action, jmn_exit;
	private JLabel jlb_MONHOC, jlb_maMonHoc, jlb_tenMonHoc, jlb_soTinChi;
	private JTextField jtf_maMH, jtf_tenMH, jtf_soTinChi;
	private JButton jbt_add, jbt_clear;
	private JTextArea jta_show;
	private JPanel jp_grid, jp_flow;

	private void init() {
		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_action = new JMenu("Action");
		jmn_exit = new JMenu("Exit");

		jmb.add(jmn_action);
		jmb.add(jmn_exit);

		jlb_maMonHoc = new JLabel("Ma mon hoc");
		jlb_soTinChi = new JLabel("So tin chi");
		jlb_tenMonHoc = new JLabel("Ten mon hoc");

		jlb_MONHOC = new JLabel("MON HOC", JLabel.CENTER);
		jlb_MONHOC.setForeground(Color.red);

		jtf_maMH = new JTextField();
		jtf_soTinChi = new JTextField();
		jtf_tenMH = new JTextField();

		jta_show = new JTextArea();

		jbt_add = new JButton("Add");
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cau3 cau3 = new Cau3();
				cau3.createArr();
				StringBuilder strB = new StringBuilder();
				for (int i = 0; i < cau3.getListMonHoc().size(); i++) {
					if (cau3.getListMonHoc().get(i).getMaMh().equals(jtf_maMH.getText())
							|| cau3.getListMonHoc().get(i).getSoTinChi() == Integer.valueOf(jtf_soTinChi.getText())
							|| cau3.getListMonHoc().get(i).getTenMH().equals(jtf_tenMH.getText())) {
						strB.append(
								cau3.getListMonHoc().get(i).getMaMh() + "\t\t\t\t" + cau3.getListMonHoc().get(i).getTenMH()
										+ "\t\t\t\t" + cau3.getListMonHoc().get(i).getSoTinChi() + "\n");
					}
				}
				jta_show.setText(strB.toString());
			}
		});

		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf_maMH.setText("");
				jtf_soTinChi.setText("");
				jtf_tenMH.setText("");
			}
		});

		jp_flow = new JPanel(new FlowLayout());
		jp_flow.add(jbt_add);
		jp_flow.add(jbt_clear);

		jp_grid = new JPanel(new GridLayout(3, 2));
		jp_grid.add(jlb_maMonHoc);
		jp_grid.add(jtf_maMH);
		jp_grid.add(jlb_tenMonHoc);
		jp_grid.add(jtf_tenMH);
		jp_grid.add(jlb_soTinChi);
		jp_grid.add(jtf_soTinChi);

		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.add(jlb_MONHOC, BorderLayout.NORTH);
		jp1.add(jp_grid, BorderLayout.CENTER);
		jp1.add(jp_flow, BorderLayout.SOUTH);

		JPanel jp2 = new JPanel(new GridLayout(2, 3));
		jp2.add(new JLabel("Danh sach mon hoc"));
		jp2.add(new JLabel());
		jp2.add(new JLabel());
		jp2.add(new JLabel("Ma Mon Hoc"));
		jp2.add(new JLabel("Ten Mon Hoc"));
		jp2.add(new JLabel("So Tin Chi"));

		JPanel jp3 = new JPanel(new BorderLayout());
		jp3.add(jp2, BorderLayout.NORTH);
		jp3.add(jta_show, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp3, BorderLayout.CENTER);
		this.setTitle("Danh sach mon hoc");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DanhSachMHProgram();
	}
}
