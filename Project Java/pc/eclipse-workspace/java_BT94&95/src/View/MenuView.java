package View;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ControllerMenu;
import model.ModelMenu;


public class MenuView extends JFrame{
	public ArrayList<JRadioButton> arrList = new ArrayList<JRadioButton>();
	public ArrayList<JCheckBox> arrListCheckBox = new ArrayList<JCheckBox>();
	public JRadioButton rdo_Com;
	//khoi tao model(null)
	public JRadioButton rdo_Pho;
	public JCheckBox jcb_Coca;
	public JCheckBox jcb_KhoaiTay;
	public JCheckBox jcb_PhoMai;
	private JLabel jlb;
	private ModelMenu model;
	public JButton jbt_ThanhToan;
	private JLabel jlb_ThanhToan;
	/**
	 * ButtonGroup giup ta lua chon chi co mot
	 */
	public MenuView() {
		this.model = new ModelMenu();
	 this.init();
	}

	private void init() {
		this.setTitle("Thuc Don");
		this.setSize(824, 643);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//set imag+e
		java.net.URL urlImage = MenuView.class.getResource("anime.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(urlImage);
		
		//jpanel thuc don chinh va phu
		JPanel jp_ThucDonChinh = new JPanel(new GridLayout(1,2));
		JPanel jp_ThucDonPhu = new JPanel(new GridLayout(1, 3));
		JPanel jp_thanhToan = new JPanel(new GridLayout(1, 2));
		 jbt_ThanhToan = new JButton("Thanh Toan");
		 jlb_ThanhToan = new JLabel();
		jp_thanhToan.add(jbt_ThanhToan);
		jp_thanhToan.add(jlb_ThanhToan);
		JPanel jp_Ca_hai = new JPanel(new BorderLayout());
		//ac
		ControllerMenu ac = new ControllerMenu(this);
		//JRadioButton
		rdo_Com = new JRadioButton("COM");
		rdo_Pho = new JRadioButton("PHO");
		//addJradioButton
		arrList.add(rdo_Com);
		arrList.add(rdo_Pho);
		 jbt_ThanhToan.addActionListener(ac);
		//JCheckBox
		jcb_Coca = new JCheckBox("Coca");
		jcb_KhoaiTay = new JCheckBox("Khoai Tay");
		jcb_PhoMai = new JCheckBox("Pho Mai");
		//JCheckBox
		arrListCheckBox.add(jcb_Coca);
		arrListCheckBox.add(jcb_KhoaiTay);
		arrListCheckBox.add(jcb_PhoMai);
		
		 //add panel
		 jp_ThucDonChinh.add(rdo_Pho);
		 jp_ThucDonChinh.add(rdo_Com);
		 
		 jp_ThucDonPhu.add(jcb_Coca);
		 jp_ThucDonPhu.add(jcb_KhoaiTay);
		 jp_ThucDonPhu.add(jcb_PhoMai);
		 
		 jp_Ca_hai.add(jp_ThucDonChinh, BorderLayout.CENTER);
		 jp_Ca_hai.add(jp_ThucDonPhu, BorderLayout.NORTH);
		 
		 
		 //layout	
		 jlb = new JLabel();	
		 this.jlb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage( MenuView.class.getResource("anime.jpg"))));
		
		 this.setLayout(new BorderLayout());
		 this.add(jlb, BorderLayout.CENTER);
		 this.add(jp_Ca_hai, BorderLayout.SOUTH);
		this.setIconImage(img);
		 this.add(jp_thanhToan, BorderLayout.NORTH);
	
		 
		this.setVisible(true);
	}
	//ThanhToan
	public void thanhToan() {
		
	}
}
