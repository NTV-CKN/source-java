package de2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DanhSachSinhVienProgram extends JFrame {
	public DanhSachSinhVienProgram() {
		this.init();
	}

	private JMenuBar jmb;
	private JMenu jmn_action, jmn_exit;
	private JLabel jlb_SINHVIEN, jlb_maSV, jlb_tenSV, jlb_diem, jlb_monHoc;
	private JTextField jtf_maSV, jtf_tenSV, jtf_diem;
	private JComboBox<String> jcbx;
	private JPanel jp_grid, jp_flow;
	private JTextArea jta_show;
	private JButton jbt_add, jbt_clear, jbt_sort;

	private void init() {
		jbt_add = new JButton("Add");
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Cau3 cau3 = new Cau3();
					cau3.createArr();
					StringBuilder strB = new StringBuilder();
					Student temp;
					for (int i = 0; i < cau3.getListStudent().size(); i++) {
						temp = cau3.getListStudent().get(i);
						if (temp.getDiemSo() == Double.parseDouble(jtf_diem.getText())
								|| temp.getMaSV().equals(jtf_maSV.getText())
								|| temp.getMonHoc().getTenMH().equals(jcbx.getSelectedItem().toString())
								|| temp.getTenSV().equals(jtf_tenSV.getText())) {
							strB.append(temp.getMaSV() + "\t\t\t" + temp.getTenSV() + "\t\t\t"
									+ temp.getMonHoc().getTenMH() + "\t\t\t" + temp.getDiemSo() + "\n");
						}
					}
					jta_show.setText(strB.toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Loi dinh dang");
				}
				
			}
		});
		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf_diem.setText("");
				jtf_maSV.setText("");
				jtf_tenSV.setText("");
			}
		});

		jbt_sort = new JButton("Sort");
		jbt_sort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cau3 cau3 = new Cau3();
				cau3.createArr();
				Collections.sort(cau3.getListStudent());
				StringBuilder strB = new StringBuilder();
				Student temp;
				for (int i = 0; i < cau3.getListStudent().size(); i++) {
					temp = cau3.getListStudent().get(i);
					strB.append(temp.getMaSV() + "\t\t\t" + temp.getTenSV() + "\t\t\t" + temp.getMonHoc().getTenMH()
							+ "\t\t\t" + temp.getDiemSo() + "\n");
				}
				jta_show.setText(strB.toString());
			}
		});

		String[] str = { "LTNC", "LTCB", "LWT" };
		jcbx = new JComboBox<String>(str);

		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_action = new JMenu("Action");
		jmn_exit = new JMenu("Exit");

		jmb.add(jmn_action);
		jmb.add(jmn_exit);

		jlb_maSV = new JLabel("Ma SV");
		jlb_monHoc = new JLabel("Mon Hoc");
		jlb_diem = new JLabel("Diem");
		jlb_tenSV = new JLabel("Ten SV");

		jlb_SINHVIEN = new JLabel("QUAN LY SINH VIEN", JLabel.CENTER);
		jlb_SINHVIEN.setForeground(Color.red);

		jtf_maSV = new JTextField();
		jtf_diem = new JTextField();
		jtf_tenSV = new JTextField();

		jta_show = new JTextArea();

		jp_flow = new JPanel(new FlowLayout());
		jp_flow.add(jbt_add);
		jp_flow.add(jbt_clear);
		jp_flow.add(jbt_sort);

		jp_grid = new JPanel(new GridLayout(4, 2));
		jp_grid.add(jlb_maSV);
		jp_grid.add(jtf_maSV);
		jp_grid.add(jlb_tenSV);
		jp_grid.add(jtf_tenSV);
		jp_grid.add(jlb_monHoc);
		jp_grid.add(jcbx);
		jp_grid.add(jlb_diem);
		jp_grid.add(jtf_diem);

		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.add(jlb_SINHVIEN, BorderLayout.NORTH);
		jp1.add(jp_grid, BorderLayout.CENTER);
		jp1.add(jp_flow, BorderLayout.SOUTH);

		JPanel jp2 = new JPanel(new GridLayout(2, 4));
		jp2.add(new JLabel("Danh sach sinh vien"));
		jp2.add(new JLabel());
		jp2.add(new JLabel());
		jp2.add(new JLabel());
		jp2.add(new JLabel("Ma SV"));
		jp2.add(new JLabel("Ten SV"));
		jp2.add(new JLabel("Mon Hoc"));
		jp2.add(new JLabel("Diem"));

		JPanel jp3 = new JPanel(new BorderLayout());
		jp3.add(jp2, BorderLayout.NORTH);
		jp3.add(jta_show, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp3, BorderLayout.CENTER);
		this.setTitle("Danh sach sinh vien");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DanhSachSinhVienProgram();
	}
}
