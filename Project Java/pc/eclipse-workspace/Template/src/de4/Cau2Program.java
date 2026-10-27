package de4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cau2Program extends JFrame {
	public Cau2Program() {
		this.init();
	}

	private JLabel jlb_ngheNghiep;
	private JTextField jtf_show;
	private ButtonGroup bg;
	private JRadioButton jrd_hocsinh, jrd_sv, jrd_kisu;
	private JCheckBox jckb_docsach, jckb_nghenhac, jckb_docbao;
	private JComboBox<String> jcbox;
	private JPanel jp_grid;
	private String radio = "";
	private List<String> listString = new ArrayList<String>();

	private void init() {
		String[] hocsinhs = { "Phan ban", "Khong phan ban" };
		String[] kisus = { "CK", "CNTT" };
		String[] sinhviens = { "Ki thuat", "Xa hoi" };

		jcbox = new JComboBox<String>(hocsinhs);

		jlb_ngheNghiep = new JLabel("Nghe nghiep");

		jtf_show = new JTextField();

		jrd_hocsinh = new JRadioButton("Hoc sinh");
		jrd_hocsinh.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jrd_hocsinh.isSelected()) {
					jtf_show.setText("");

					jcbox.removeAllItems();
					updateRadio(jrd_hocsinh.getText());
					for (int i = 0; i < hocsinhs.length; i++) {
						jcbox.addItem(hocsinhs[i]);
					}
					updateCheckbox();
				}
			}
		});

		jrd_kisu = new JRadioButton("Ki su");
		jrd_kisu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jrd_kisu.isSelected()) {
					jtf_show.setText("");
					jcbox.removeAllItems();
					updateRadio(jrd_kisu.getText());
					for (int i = 0; i < kisus.length; i++) {
						jcbox.addItem(kisus[i]);
					}
					updateCheckbox();
				}
			}
		});

		jrd_sv = new JRadioButton("Sinh vien");
		jrd_sv.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jrd_sv.isSelected()) {
					jtf_show.setText("");
					updateRadio(jrd_sv.getText());
					jcbox.removeAllItems();
					for (int i = 0; i < sinhviens.length; i++) {
						jcbox.addItem(sinhviens[i]);
					}
					updateCheckbox();
				}
			}
		});

		bg = new ButtonGroup();
		bg.add(jrd_hocsinh);
		bg.add(jrd_kisu);
		bg.add(jrd_sv);
		jrd_hocsinh.setSelected(true);

		jckb_docbao = new JCheckBox("Doc bao");
		jckb_docbao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jckb_docbao.isSelected()) {
					listString.add(jckb_docbao.getText());
					updateCheckbox();
				} else {
					if (listString.contains(jckb_docbao.getText())) {
						listString.remove(jckb_docbao.getText());
						updateCheckbox();
					}
				}
			}
		});

		jckb_docsach = new JCheckBox("Doc sach");
		jckb_docsach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jckb_docsach.isSelected()) {
					listString.add(jckb_docsach.getText());
					updateCheckbox();
				} else {
					if (listString.contains(jckb_docsach.getText())) {
						listString.remove(jckb_docsach.getText());
						updateCheckbox();
					}
				}
			}
		});

		jckb_nghenhac = new JCheckBox("Nghe nhac");
		jckb_nghenhac.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jckb_nghenhac.isSelected()) {
					listString.add(jckb_nghenhac.getText());
					updateCheckbox();
				} else {
					if (listString.contains(jckb_nghenhac.getText())) {
						listString.remove(jckb_nghenhac.getText());
						updateCheckbox();
					}
				}
			}
		});

		jcbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcbox.getSelectedIndex() != -1) {
					updateCheckbox();
				}
			}
		});

		jp_grid = new JPanel(new GridLayout(4, 2));
		jp_grid.add(jlb_ngheNghiep);
		jp_grid.add(jcbox);
		jp_grid.add(jrd_hocsinh);
		jp_grid.add(jckb_docbao);
		jp_grid.add(jrd_sv);
		jp_grid.add(jckb_docsach);
		jp_grid.add(jrd_kisu);
		jp_grid.add(jckb_nghenhac);

		this.setLayout(new BorderLayout());
		this.add(jp_grid, BorderLayout.CENTER);
		this.add(jtf_show, BorderLayout.SOUTH);
		this.setTitle("Input Frame");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void updateRadio(String str) {
		radio = str;
	}

	public void updateCheckbox() {
		StringBuilder strB = new StringBuilder();
		strB.append(radio + " " + jcbox.getSelectedItem().toString() + ": ");
		for (int i = 0; i < listString.size(); i++) {
			strB.append(listString.get(i) + ", ");
		}
		strB.delete(strB.length() - 2, strB.length());
		jtf_show.setText(strB.toString());
	}

	public static void main(String[] args) {
		new Cau2Program();
	}
}
