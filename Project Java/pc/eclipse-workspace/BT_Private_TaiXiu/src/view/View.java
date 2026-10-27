package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.ModelTaiXiu;

public class View extends JFrame {
	private ModelTaiXiu model;
	private JButton jb_thongKe, jb_tai, jb_xiu;
	private JTextField jtf_nhapTienCuoc;
	private JLabel jlb_soTienCuaBan,jlb_hienThiTaiXiu,jlb_soTienConLai, jlb_soTienHienCo,jlb_hienThiKq, jlb_thongBao, jlb_nhapTienCuoc,jlb_nhapUserName;
	private JButton jb_xacNhan;
	//constructor
	public View() {
		this.model = new ModelTaiXiu();
		this.init();
	}
	//init
	private void init() {
		this.setTitle("Tai Xiu Cung Vu");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//ac
		Controller ac = new Controller(this);
		//font 
		Font font_vua = new Font("Arial", Font.BOLD, 30);
		Font font_nho = new Font("Arial", Font.BOLD, 15);
		Font font_lon = new Font("Arial", Font.BOLD, 60);
		//jtextfield
		this.jtf_nhapTienCuoc = new JTextField("");
		//this.jtf_hienThiKQ = new JTextField();
		//jpanel
		JPanel jp_layoutTren = new JPanel(new FlowLayout());
		JPanel jp_layoutGiua = new JPanel(new GridLayout(2,3,10,10));
		JPanel jp_layoutDuoi = new JPanel(new GridLayout(2, 2, 10 ,10));
		
		//jbutton
		this.jb_tai = new JButton("TAI");
		this.jb_xiu = new JButton("XIU");
		this.jb_thongKe = new JButton("Tung Xuc Sac");
		this.jb_xacNhan = new JButton("Xac Nhan");
		//set ac
		this.jb_tai.addActionListener(ac);
		this.jb_xiu.addActionListener(ac);
		this.jb_thongKe.addActionListener(ac);
		this.jb_xacNhan.addActionListener(ac);
		//
		this.jb_tai.setFont(font_lon);
		this.jb_xiu.setFont(font_lon);
		this.jb_thongKe.setFont(font_vua);
		this.jb_xacNhan.setFont(font_vua);
		//color
		this.jb_tai.setBackground(Color.GREEN);this.jb_tai.setForeground(Color.YELLOW);
		this.jb_xiu.setBackground(Color.RED);this.jb_xiu.setForeground(Color.BLACK);
		this.jb_thongKe.setBackground(Color.BLUE);this.jb_thongKe.setForeground(Color.YELLOW);
		//khoi tao
		jlb_thongBao = new JLabel("  MOI CHON");
		jlb_thongBao.setFont(font_lon);
		jlb_hienThiKq = new JLabel("Ket Qua: ");
		jlb_nhapTienCuoc = new JLabel("BET:", JLabel.CENTER);
		jlb_nhapTienCuoc.setFont(font_vua);
		jlb_soTienConLai = new JLabel();
		jlb_hienThiTaiXiu = new JLabel(this.model.getKq(), JLabel.CENTER);
		jlb_hienThiTaiXiu.setFont(font_nho);
		jlb_soTienCuaBan = new JLabel();
		jlb_soTienCuaBan.setFont(font_vua);
		jlb_soTienCuaBan.setText("So du kha dung: "+this.model.getTienHienCoStr()+"VND");
		
		jlb_hienThiKq.setForeground(Color.YELLOW);
		jlb_soTienCuaBan.setForeground(Color.YELLOW);
		
		//add jpanelGiua
		jp_layoutGiua.add(jb_tai);
		jp_layoutGiua.add(jlb_thongBao, BorderLayout.CENTER);
		jp_layoutGiua.add(jb_xiu);
		jp_layoutGiua.add(jlb_hienThiKq);
		jp_layoutGiua.add(jlb_hienThiTaiXiu);
		jp_layoutGiua.add(jb_xacNhan);
		
		//setchu
		jlb_hienThiKq.setFont(font_lon);
		jlb_soTienConLai.setFont(font_lon);
		jlb_soTienConLai.setForeground(Color.RED);
		//add jpanelDuoi
		jp_layoutDuoi.add(jlb_nhapTienCuoc);
		jp_layoutDuoi.add(jtf_nhapTienCuoc);
		jp_layoutDuoi.add(jb_thongKe);
		jp_layoutDuoi.add(jlb_soTienCuaBan);
		//add Jframe
		this.setLayout(new BorderLayout());
		this.add(jp_layoutGiua, BorderLayout.CENTER);
		this.add(jp_layoutDuoi, BorderLayout.SOUTH);
		//setback
		jp_layoutGiua.setBackground(Color.LIGHT_GRAY);
		jp_layoutDuoi.setBackground(Color.YELLOW);
		
		//display
		this.setVisible(true);
	}
	//methods
	public void tai() {
		this.model.setChonTaiXiu("TAI");
	}
	public void xiu() {
		this.model.setChonTaiXiu("XIU");
	}
	public void thongKe() {
		if(this.model.getTienCuoc() == 0) {
			this.jlb_hienThiTaiXiu.setText("Moi xac nhan so tien dat cuoc");
		}else {
		this.model.tungXucSac();
		this.jlb_hienThiTaiXiu.setText(this.model.getKq());
		jlb_soTienCuaBan.setText("So du kha dung: "+this.model.getTienHienCoStr()+"VND");

	}
		}
	public void xacNhan() {
		try {   
			double i = Double.parseDouble(this.jtf_nhapTienCuoc.getText());
			if(this.model.getTienHienCo() >= this.model.getTienCuoc()) {		
		         this.model.setTienCuoc(i);
		    }else {
		    	jlb_hienThiTaiXiu.setText("Tien cuoc khong hop le");
		    }
		} catch (Exception e) {
			this.jlb_hienThiTaiXiu.setText("Vui long nhap tien cuoc");
		}

	}
}
