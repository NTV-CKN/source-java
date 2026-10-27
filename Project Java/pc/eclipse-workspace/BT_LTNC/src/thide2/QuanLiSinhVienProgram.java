package thide2;

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

public class QuanLiSinhVienProgram extends JFrame {
	private JLabel jlb;
	private JMenuBar jmb;
	private JMenuItem jmni_listCourse, jmni_listStudent;
	private JMenu jmn_action, jmn_exit;

	public QuanLiSinhVienProgram() {
		this.init();
	}

	public void init() {
		jlb = new JLabel(
				new ImageIcon("D:\\esclipse\\Project Java\\pc\\eclipse-workspace\\BT_LTNC\\src\\images\\img1.png"));
		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_action = new JMenu("Action");
		jmn_exit = new JMenu("Exit");

		jmni_listStudent = new JMenuItem("List student");
		jmni_listStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListStudentProgram();
			}
		});
		jmni_listCourse = new JMenuItem("List course");
		jmni_listCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListCourseProgram();
			}
		});
		
		jmn_action.add(jmni_listCourse);
		jmn_action.add(jmni_listStudent);

		jmb.add(jmn_action);
		jmb.add(jmn_exit);

		jmn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		this.add(jlb);
		this.setTitle("Quan li sinh vien");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new QuanLiSinhVienProgram();
	}
}
