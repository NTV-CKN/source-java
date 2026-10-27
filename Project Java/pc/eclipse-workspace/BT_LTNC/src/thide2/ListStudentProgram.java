package thide2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListStudentProgram extends JFrame {
	private Cau3 c3 = new Cau3();
	private JMenuBar jmb;
	private JMenuItem jmni_listCourse, jmni_listStudent;
	private JMenu jmn_action, jmn_exit;

	private JLabel jlb_QLSV, jlb_mssv, jlb_tensv, jlb_diem, jlb_monhoc;
	private JTextArea jtxa;
	private JLabel jlb_MaSV, jlb_TenSV, jlb_MonHoc, jlb_Diem, jlb_DSSV;
	private JButton jbt_add, jbt_clear, jbt_sort;
	private JComboBox<String> jcbx_MH;
	private JPanel jp_42, jp_flow, jp_11;
	private JTextField jtxf_ten, jtxf_diem, jtxf_masv;
	// private ButtonGroup bg;

	public ListStudentProgram() {
		this.init();
	}

	public void init() {
		c3.createList();

		jlb_QLSV = new JLabel("QUAN LI SINH VIEN", JLabel.CENTER);
		Font font = new Font("Arial", ABORT, 50);
		jlb_QLSV.setForeground(Color.red);
		jlb_QLSV.setFont(font);

		jtxf_diem = new JTextField();
		jtxf_masv = new JTextField();
		jtxf_ten = new JTextField();

		jtxa = new JTextArea();
		jlb_DSSV = new JLabel("Danh Sach Sinh Vien");
		jlb_mssv = new JLabel("MSSV");
		jlb_tensv = new JLabel("Ten SV");
		jlb_monhoc = new JLabel("Mon hoc");
		jlb_diem = new JLabel("Diem");

		jlb_MaSV = new JLabel("MSSV");
		jlb_TenSV = new JLabel("Ten SV");
		jlb_MonHoc = new JLabel("Mon hoc");
		jlb_Diem = new JLabel("Diem");

		jbt_add = new JButton("Add");
		jbt_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					StringBuilder strB = new StringBuilder();
					Subject subTemp = new Subject("biebfiebfiefe", (String) jcbx_MH.getSelectedItem(), -1000);
					Student temp = new Student(jtxf_masv.getText(), jtxf_ten.getText(), subTemp,
							Double.parseDouble(jtxf_diem.getText()));
					for (int i = 0; i < c3.listStu.size(); i++) {
						if (c3.listStu.get(i).equals(temp)) {
							strB.append(c3.listStu.get(i) + "\n");
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
				jtxf_diem.setText("");
				jtxf_masv.setText("");
				jtxf_ten.setText("");
			}
		});
		jbt_sort = new JButton("Sort");
		jbt_sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder strB = new StringBuilder();
				Collections.sort(c3.listStu);
				for (int i = 0; i < c3.listStu.size(); i++) {
					strB.append(c3.listStu.get(i) + "\n");
				}
				jtxa.setText(strB.toString());
			}
		});

		String[] arr = { "LTNC", "LTCB", "CTMT" };
		jcbx_MH = new JComboBox<String>(arr);

		jp_42 = new JPanel(new GridLayout(4, 2));
		jp_flow = new JPanel(new FlowLayout());
		jp_11 = new JPanel(new GridLayout(1, 4));

		jp_42.add(jlb_mssv);
		jp_42.add(jtxf_masv);
		jp_42.add(jlb_tensv);
		jp_42.add(jtxf_ten);
		jp_42.add(jlb_monhoc);
		jp_42.add(jcbx_MH);
		jp_42.add(jlb_diem);
		jp_42.add(jtxf_diem);

		jp_flow.add(jbt_add);
		jp_flow.add(jbt_clear);
		jp_flow.add(jbt_sort);

		jp_11.add(jlb_MaSV);
		jp_11.add(jlb_TenSV);
		jp_11.add(jlb_MonHoc);
		jp_11.add(jlb_Diem);

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
		this.add(jlb_QLSV);
		this.add(jp_42);
		this.add(jp_flow);
		this.add(jlb_DSSV);
		this.add(jp_11);
		this.add(jtxa);

		this.setTitle("Danh sach sinh vien");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ListStudentProgram();
	}
}
