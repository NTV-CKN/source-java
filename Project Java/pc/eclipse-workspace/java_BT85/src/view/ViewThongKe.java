package view;
/*
 * trong ViewThongKe ta co 1 thuoc tinh object la ModelThongKe
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllerThongKe.ControllerThongKe;
import model.ModelThongKe;

public class ViewThongKe extends JFrame{
	private ModelThongKe modelThongKe;
	private JLabel jlb_ketQua;
	private JTextField jtf_timKiem;
	private JTextArea jta_vanBan;
	private JButton jbutton;
	//constructor
	public ViewThongKe() {
		this.modelThongKe = new ModelThongKe();//khoi tao ModelThongKe
		this.init();
	}
	private void init() {
		this.setTitle("ThongKe");
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//font
		Font font = new Font("Arial", Font.ITALIC, 30);
		//jpanel
		JPanel jp1 = new JPanel(new GridLayout(2,2,10,10));
		//action
		ControllerThongKe ac = new ControllerThongKe(this);
		//jTextField and jTextArea
		 this.jtf_timKiem = new JTextField();
		jtf_timKiem.setFont(font);
		jtf_timKiem.setBackground(Color.PINK);
		this.jta_vanBan = new JTextArea();
		jta_vanBan.setFont(font);
		jta_vanBan.setBackground(Color.PINK);
		
		//jlabel
		JLabel jlb_vanBan = new JLabel("Van Ban");
		jlb_vanBan.setFont(font);
		JLabel jlb_tuKhoa = new JLabel("Tu Khoa");
		jlb_tuKhoa.setFont(font);
		this.jlb_ketQua = new JLabel();
		this.jlb_ketQua.setFont(font);
		this.jlb_ketQua.setBackground(Color.YELLOW);
		this.jlb_ketQua.setOpaque(true);
		
		//jbutton
		this.jbutton = new JButton("Thong Ke");
		jbutton.setBackground(Color.GRAY);
		jbutton.setForeground(Color.YELLOW);
		jbutton.setFont(font);
		jbutton.addActionListener(ac);
		//add jp1
		jp1.add(jlb_tuKhoa);
		jp1.add(jtf_timKiem);
		jp1.add(jbutton);
		jp1.add(jlb_ketQua);
		
		//add layout frame
		this.setLayout(new BorderLayout());
		this.add(jlb_vanBan, BorderLayout.NORTH);
		this.add(jta_vanBan, BorderLayout.CENTER);
		this.add(jp1, BorderLayout.SOUTH);
		//display: true
		this.setVisible(true);
	}
	//method
	public void thongKe() {
		if(this.jta_vanBan.getText().equals("") || this.jtf_timKiem.getText().equals("")) {
			this.jlb_ketQua.setText("Moi nhap van ban va tim kiem!");
		}else {
		this.modelThongKe.setVanBan(this.jta_vanBan.getText());
		this.modelThongKe.setTuKhoa(this.jtf_timKiem.getText());
		this.jlb_ketQua.setText(this.modelThongKe.thongKe());
		}
	}
}
