package de4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class InputFrameProgram extends JFrame {
	private JPanel jp, jp_p;
	private JLabel jlb_nn;
	private JRadioButton jbt_hs, jbt_ks, jbt_sv;
	private ButtonGroup bg;
	private JCheckBox jcheckB_docBao, jcheckB_docSach, jcheckB_ngheNhac;
	private JComboBox<String> jcbx;
	private List<JComboBox<String>> list_Cbx;
	private JTextArea jtxa;
	private StringBuilder str1, str2, str3, save, result = new StringBuilder();
	private int index = 0, startS = 0, endS;

	public InputFrameProgram() {
		this.init();
	}

	private void init() {
		String[] arr1 = { "Phan ban", "Khong phan ban" };
		jcbx = new JComboBox<String>(arr1);
		jcbx.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcbx.getSelectedItem() != null) {
					jcheckB_docBao.setSelected(false);
					jcheckB_docSach.setSelected(false);
					jcheckB_ngheNhac.setSelected(false);
					save.delete(0, save.length());
					System.out.println("ss");
					if (jbt_hs.isSelected()) {
						save.append("Hoc sinh " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_ks.isSelected()) {
						save.append("Ki su " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_sv.isSelected()) {
						save.append("Sinh vien " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					}
				}
			}
		});
		list_Cbx = new ArrayList<JComboBox<String>>();
		list_Cbx.add(jcbx);
		String[] arr2 = { "Ki thuat", "Xa hoi" };
		jcbx = new JComboBox<String>(arr2);
		jcbx.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcbx.getSelectedItem() != null) {
					jcheckB_docBao.setSelected(false);
					jcheckB_docSach.setSelected(false);
					jcheckB_ngheNhac.setSelected(false);
					save.delete(0, save.length());
					System.out.println("ss");
					if (jbt_hs.isSelected()) {
						save.append("Hoc sinh " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_ks.isSelected()) {
						save.append("Ki su " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_sv.isSelected()) {
						save.append("Sinh vien " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					}
				}
			}
		});
		list_Cbx.add(jcbx);

		String[] ar2 = { "CK", "CNTT" };
		jcbx = new JComboBox<String>(ar2);
		save = new StringBuilder();
		save.append("Ki su CK thich:");
		endS = save.length();
		jcbx.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcbx.getSelectedItem() != null) {
					jcheckB_docBao.setSelected(false);
					jcheckB_docSach.setSelected(false);
					jcheckB_ngheNhac.setSelected(false);
					save.delete(0, save.length());
					System.out.println("ss");
					if (jbt_hs.isSelected()) {
						save.append("Hoc sinh " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_ks.isSelected()) {
						save.append("Ki su " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					} else if (jbt_sv.isSelected()) {
						save.append("Sinh vien " + (String) jcbx.getSelectedItem() + " thich:");
						endS = save.length();
						jtxa.setText(save.toString());
					}
				}
			}
		});

		list_Cbx.add(jcbx);

		jcheckB_docBao = new JCheckBox("Doc bao");
		jcheckB_docBao.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (jcheckB_docBao.isSelected()) {
					str1 = new StringBuilder();
					str1.append("Doc bao");
					if (save.indexOf(str1.toString()) >= 0) {
						return;
					}
					if (index == 0) {
						result.append(" " + str1);
						index++;
					} else {
						result.delete(0, result.length());
						result.append(", " + str1);
					}
					save.append(result.toString());
					jtxa.setText(save.toString());
				} else {
					if (jcheckB_docBao.isSelected() == false && jcheckB_docSach.isSelected() == false
							&& jcheckB_ngheNhac.isSelected() == false) {
						save.delete(endS, result.length() + endS);
						result.delete(0, result.length());
						index = 0;
						jtxa.setText(save.toString());
						return;
					}
					System.out.println("sss");
					String str = "Doc bao";

					int start = save.indexOf(str);
					System.out.println(start);
					if (start >= 0) {
						if (save.charAt(start - 2) != ',') {
							save.delete(start, start + str.length() + 2);
							jtxa.setText(save.toString());
						} else {
							save.delete(start - 2, start + str.length());
							jtxa.setText(save.toString());
						}
					}
				}
			}
		});
		jcheckB_docSach = new JCheckBox("Doc sach");
		jcheckB_docSach.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (jcheckB_docSach.isSelected()) {
					str1 = new StringBuilder();
					str1.append("Doc sach");
					if (save.indexOf(str1.toString()) >= 0) {
						return;
					}
					if (index == 0) {
						result.append(" " + str1);
						index++;
					} else {
						result.delete(0, result.length());
						result.append(", " + str1);
					}
					save.append(result.toString());
					jtxa.setText(save.toString());
				} else {
					if (jcheckB_docBao.isSelected() == false && jcheckB_docSach.isSelected() == false
							&& jcheckB_ngheNhac.isSelected() == false) {
						save.delete(endS, result.length() + endS);
						result.delete(0, result.length());
						index = 0;
						jtxa.setText(save.toString());
						return;
					}
					String str = "Doc sach";

					int start = save.indexOf(str);
					System.out.println(start);
					if (start >= 0) {
						if (save.charAt(start - 2) != ',') {
							save.delete(start, start + str.length() + 2);
							jtxa.setText(save.toString());
						} else {
							save.delete(start - 2, start + str.length());
							jtxa.setText(save.toString());
						}
					}
				}
			}
		});
		jcheckB_ngheNhac = new JCheckBox("Nghe nhac");
		jcheckB_ngheNhac.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (jcheckB_ngheNhac.isSelected()) {
					str1 = new StringBuilder();
					str1.append("Nghe nhac");
					if (save.indexOf(str1.toString()) >= 0) {
						return;
					}
					if (index == 0) {
						result.append(" " + str1);
						index++;
					} else {
						result.delete(0, result.length());
						result.append(", " + str1);
					}
					save.append(result.toString());
					jtxa.setText(save.toString());
				} else {
					if (jcheckB_docBao.isSelected() == false && jcheckB_docSach.isSelected() == false
							&& jcheckB_ngheNhac.isSelected() == false) {
						save.delete(endS, result.length() + endS);
						result.delete(0, result.length());
						index = 0;
						jtxa.setText(save.toString());
						return;
					}
					String str = "Nghe nhac";

					int start = save.indexOf(str);
					System.out.println(start);
					if (start >= 0) {
						if (save.charAt(start - 2) != ',') {
							save.delete(start, start + str.length() + 2);
							jtxa.setText(save.toString());
						} else {
							save.delete(start - 2, start + str.length());
							jtxa.setText(save.toString());
						}
					}
				}
			}
		});

		jp = new JPanel(new GridLayout(4, 2));
		jp_p = new JPanel(new GridLayout(1, 1));

		jlb_nn = new JLabel("Nghe nghiep");

		// ButtonGroup
		bg = new ButtonGroup();

		jbt_hs = new JRadioButton("Hoc sinh");
		bg.add(jbt_hs);
		jbt_hs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jcbx = list_Cbx.get(0);
				jp_p.removeAll();
				jp_p.add(jcbx);
				save = new StringBuilder();
				save.delete(0, save.length());
				jtxa.setText(save.toString());
				jp.updateUI();
			}
		});

		jbt_ks = new JRadioButton("Ki su");
		bg.add(jbt_ks);
		jbt_ks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jcbx = list_Cbx.get(2);
				jp_p.removeAll();
				jp_p.add(jcbx);
				save = new StringBuilder();
				save.delete(0, save.length());
				jtxa.setText(save.toString());
				jp.updateUI();
			}
		});
		jbt_ks.setSelected(true);

		jbt_sv = new JRadioButton("Sinh vien");
		bg.add(jbt_sv);
		jbt_sv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jcbx = list_Cbx.get(1);
				jp_p.removeAll();
				jp_p.add(jcbx);
				save = new StringBuilder();
				save.delete(0, save.length());
				jtxa.setText(save.toString());
				jp.updateUI();
			}
		});

		jp_p.add(jcbx);
		jp.add(jlb_nn);
		jp.add(jp_p);
		jp.add(jbt_hs);
		jp.add(jcheckB_docBao);
		jp.add(jbt_sv);
		jp.add(jcheckB_docSach);
		jp.add(jbt_ks);
		jp.add(jcheckB_ngheNhac);

		jtxa = new JTextArea();

		this.setLayout(new GridLayout(2, 1));
		this.add(jp);
		this.add(jtxa);
		this.setTitle("Test");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new InputFrameProgram();
	}
}
