package thide2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListCourseProgram extends JFrame {
	private Cau3 c3 = new Cau3();
	private JMenuBar jmb;
	private JMenuItem jmni_listCourse, jmni_listStudent;
	private JMenu jmn_action, jmn_exit;

	private JLabel jlb_MONHOC, jlb_MMH, jlb_TENMONHOC, jlb_SOTINCHI, jlb_dsmh;
	private JTextArea jtxa;
	private JLabel jlb_mmh, jlb_tenmh, jlb_sochi;
	private JButton jbt_add, jbt_clear;
	private JTextField jtxf_tenmh, jtxf_sochi, jtxf_mamh;
	private JPanel jp_33, jp_flow, jp_13;

	public ListCourseProgram() {
		this.init();
	}

	public void init() {
		c3.createList();

		jbt_add = new JButton("Add");
		jbt_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					StringBuilder strB = new StringBuilder();
					Subject temp = new Subject(jtxf_mamh.getText(), jtxf_tenmh.getText(),
							Integer.valueOf(jtxf_sochi.getText()));
					for (int i = 0; i < c3.listSubject.size(); i++) {
						if (c3.listSubject.get(i).equals(temp)) {
							strB.append(c3.listSubject.get(i) + "\n");
						}
					}
					jtxa.setText(strB.toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "LOI DINH DANG");
				}

			}
		});

		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf_mamh.setText("");
				jtxf_sochi.setText("");
				jtxf_tenmh.setText("");
			}
		});

		jlb_dsmh = new JLabel("Danh sach mon hoc");

		jp_13 = new JPanel(new GridLayout(1, 3));
		jp_33 = new JPanel(new GridLayout(3, 3));
		jp_flow = new JPanel(new FlowLayout());

		jtxa = new JTextArea();
		jtxf_mamh = new JTextField();
		jtxf_sochi = new JTextField();
		jtxf_tenmh = new JTextField();

		jlb_MONHOC = new JLabel("MON HOC", JLabel.CENTER);
		Font font = new Font("Arial", ABORT, 50);
		jlb_MONHOC.setForeground(Color.red);
		jlb_MONHOC.setFont(font);

		jlb_mmh = new JLabel("Ma MH");
		jlb_MMH = new JLabel("Ma MH");
//		jlb_tenmh = new JLabel("MH");
//		jlb_TENMONHOC = new JLabel("MH");
		jlb_sochi = new JLabel("So Chi");
		jlb_SOTINCHI = new JLabel("So Chi");
		jlb_tenmh = new JLabel("Ten MH");
		jlb_TENMONHOC = new JLabel("Ten MH");

		jp_33.add(jlb_mmh);
		jp_33.add(jtxf_mamh);
		jp_33.add(jlb_tenmh);
		jp_33.add(jtxf_tenmh);
		jp_33.add(jlb_sochi);
		jp_33.add(jtxf_sochi);

		jp_flow.add(jbt_add);
		jp_flow.add(jbt_clear);

		jp_13.add(jlb_MMH);
		jp_13.add(jlb_TENMONHOC);
		jp_13.add(jlb_SOTINCHI);

		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_action = new JMenu("Action");
		jmn_exit = new JMenu("Exit");

		jmni_listStudent = new JMenuItem("List student");
		jmni_listCourse = new JMenuItem("List course");

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

		this.setLayout(new GridLayout(6, 1));
		this.add(jlb_MONHOC);
		this.add(jp_33);
		this.add(jp_flow);
		this.add(jlb_dsmh);
		this.add(jp_13);
		this.add(jtxa);
		this.setTitle("Danh sach mon hoc");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ListCourseProgram();
	}
}
