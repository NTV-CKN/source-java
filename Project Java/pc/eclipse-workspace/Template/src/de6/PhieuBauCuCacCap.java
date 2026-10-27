package de6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhieuBauCuCacCap extends JFrame {
	public PhieuBauCuCacCap() {
		this.init();
	}

	private JCheckBox jck_capphuong[], jck_capquan[], jck_capcity[];
	private JLabel jlb_capphuong, jlb_capquan, jlb_capcity, jlb_showcp, jlb_showcq, jlb_showctp, jlb_phieubaucu;
	private JPanel jp_grid_cp, jp_grid_cq, jp_grid_ctp;
	private Font font;
	private int countCP = 0, countCQ = 0, countCTP = 0;
	private JButton jbt_bophieu;
	private String str = "So nguoi da chon: ";

	
	public boolean checkSoPhieu(int count1, int count2, int count3) {
		if (count1 >= 3 && count2 >= 4 && count3 >= 5) {
			return true;
		}
		return false;
	}

	private void init() {
		ShareData.listCapCity = new ArrayList<String>();
		ShareData.listCapPhuong = new ArrayList<String>();
		ShareData.listQuan = new ArrayList<String>();
		
		jbt_bophieu = new JButton("BO PHIEU");
		jbt_bophieu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkSoPhieu(countCP, countCQ, countCTP)) {
					new KetQuaPhieuBau();
				} else {
					ShareData.listCapCity = new ArrayList<String>();
					ShareData.listCapCity.add("Phieu khong hop le");
					ShareData.listCapPhuong = new ArrayList<String>();
					ShareData.listCapPhuong.add("Phieu khong hop le");
					ShareData.listQuan = new ArrayList<String>();
					ShareData.listQuan.add("Phieu khong hop le");
					new KetQuaPhieuBau();
				}
			}
		});

		jp_grid_cp = new JPanel(new GridLayout(6, 1));
		jp_grid_cq = new JPanel(new GridLayout(8, 1));
		jp_grid_ctp = new JPanel(new GridLayout(9, 1));

		font = new Font("Arial", Font.BOLD, 40);

		jlb_capcity = new JLabel("Cap thanh pho (chon 5)");
		jp_grid_ctp.add(jlb_capcity);

		jlb_capphuong = new JLabel("Cap phuong (chon 3)");
		jp_grid_cp.add(jlb_capphuong);

		jlb_capquan = new JLabel("Cap quan (chon 4)");
		jp_grid_cq.add(jlb_capquan);

		jlb_phieubaucu = new JLabel("PHIEU BAU CU", JLabel.CENTER);
		jlb_phieubaucu.setFont(font);
		jlb_phieubaucu.setBackground(Color.yellow);
		jlb_phieubaucu.setOpaque(true);

		jlb_showcp = new JLabel(str + countCP);
		jlb_showcq = new JLabel(str + countCQ);
		jlb_showctp = new JLabel(str + countCTP);

		String[] capphuongs = { "Nguyen Tan Khoi", "Nguyen Xi", "Nguyen Xuan An", "Ho Thanh Ha" };
		String[] capquans = { "Vu Thai Hoa", "Do Thi Thanh Phuong", "Lam Quoc Quan", "Ho Thi Lan", "Nguyen Van Kien",
				"Nguyen Tan phat" };
		String[] capcitys = { "Le Huu Chuong", "Nguyen Huu Thinh", "Huynh Thanh An", "Nguyen Van Canh",
				"Ta Thi Kim Chi", "Dang Quoc Cuong", "Tran Quoc Dao" };

		jck_capcity = new JCheckBox[capcitys.length];
		jck_capphuong = new JCheckBox[capphuongs.length];
		jck_capquan = new JCheckBox[capquans.length];

		for (int i = 0; i < capcitys.length; i++) {
			int index = i;
			jck_capcity[i] = new JCheckBox(capcitys[i]);
			jp_grid_ctp.add(jck_capcity[i]);
			jck_capcity[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (jck_capcity[index].isSelected()) {
						countCTP++;
						ShareData.listCapCity.add(jck_capcity[index].getText() + "\n");
						jlb_showctp.setText(str + countCTP);
					} else {
						countCTP--;
						ShareData.listCapCity.remove(jck_capcity[index].getText() + "\n");
						jlb_showctp.setText(str + countCTP);
					}
				}
			});
		}
		for (int i = 0; i < capphuongs.length; i++) {
			int index = i;
			jck_capphuong[i] = new JCheckBox(capphuongs[i]);
			jp_grid_cp.add(jck_capphuong[i]);
			jck_capphuong[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (jck_capphuong[index].isSelected()) {
						countCP++;
						ShareData.listCapPhuong.add(jck_capphuong[index].getText() + "\n");
						jlb_showcp.setText(str + countCP);
					} else {
						countCP--;
						ShareData.listCapPhuong.remove(jck_capphuong[index].getText() + "\n");
						jlb_showcp.setText(str + countCP);
					}
				}
			});
		}
		for (int i = 0; i < capquans.length; i++) {
			int index = i;
			jck_capquan[i] = new JCheckBox(capquans[i]);
			jp_grid_cq.add(jck_capquan[i]);
			jck_capquan[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (jck_capquan[index].isSelected()) {
						countCQ++;
						ShareData.listQuan.add(jck_capquan[index].getText() + "\n");
						jlb_showcq.setText(str + countCQ);
					} else {
						countCQ--;
						ShareData.listQuan.remove(jck_capquan[index].getText() + "\n");
						jlb_showcq.setText(str + countCQ);
					}
				}
			});
		}

		jp_grid_cp.add(jlb_showcp);
		jp_grid_cq.add(jlb_showcq);
		jp_grid_ctp.add(jlb_showctp);

		JPanel jp = new JPanel(new GridLayout(1, 3));
		jp.add(jp_grid_cp);
		jp.add(jp_grid_cq);
		jp.add(jp_grid_ctp);

		this.setLayout(new BorderLayout());
		this.add(jlb_phieubaucu, BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);
		this.add(jbt_bophieu, BorderLayout.SOUTH);
		this.setTitle("Phieu bau cu cac cap");
		this.setSize(700, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new PhieuBauCuCacCap();
	}
}
