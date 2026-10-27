package de2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainProgram extends JFrame {
	public MainProgram() {
		this.init();
	}

	private JMenuBar jmb;
	private JMenu jmn_action, jmn_exit;
	private JMenuItem jmni_listCourse, jmni_listStudent;

	private void init() {
		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_action = new JMenu("Action");
		jmn_exit = new JMenu("Exit");
		jmn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		jmni_listCourse = new JMenuItem("List Course");
		jmni_listCourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DanhSachMHProgram();
			}
		});
		jmni_listStudent = new JMenuItem("List Student");
		jmni_listStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DanhSachSinhVienProgram();
			}
		});

		jmn_action.add(jmni_listCourse);
		jmn_action.add(jmni_listStudent);

		jmb.add(jmn_action);
		jmb.add(jmn_exit);

		JLabel jlb = new JLabel(
				new ImageIcon("D:\\esclipse\\Project Java\\pc\\eclipse-workspace\\Template\\src\\images\\image1.png"));

		this.add(jlb);
		this.setTitle("Danh sach mon hoc");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainProgram();
	}
}
