package de6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class KetQuaPhieuBau extends JFrame {
	public KetQuaPhieuBau() {
		this.init();
	}

	private JLabel jlb_capphuong, jlb_capquan, jlb_capcity, jlb_phieubaucu;
	private JPanel jp_grid_cp, jp_grid_cq, jp_grid_ctp;
	private JButton jbt_thoat;
	private JTextArea jtfa_cq, jtfa_cp, jtfa_ctp;

	private void init() {
		jbt_thoat = new JButton("Thoat");
		jbt_thoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PhieuBauCuCacCap();
			}
		});

		jtfa_cp = new JTextArea(ShareData.listCapPhuong.toString());
		jtfa_cq = new JTextArea(ShareData.listQuan.toString());
		jtfa_ctp = new JTextArea(ShareData.listCapCity.toString());

		jp_grid_cp = new JPanel(new GridLayout(2, 1));
		jp_grid_cq = new JPanel(new GridLayout(2, 1));
		jp_grid_ctp = new JPanel(new GridLayout(2, 1));

		jlb_phieubaucu = new JLabel("PHIEU BAU CU", JLabel.CENTER);
		jlb_phieubaucu.setFont(new Font("Arial", Font.BOLD, 50));

		jlb_capcity = new JLabel("Cap thanh pho");
		jp_grid_ctp.add(jlb_capcity);

		jlb_capphuong = new JLabel("Cap phuong");
		jp_grid_cp.add(jlb_capphuong);

		jlb_capquan = new JLabel("Cap quan");
		jp_grid_cq.add(jlb_capquan);

		jp_grid_cp.add(jtfa_cp);
		jp_grid_cq.add(jtfa_cq);
		jp_grid_ctp.add(jtfa_ctp);

		JPanel jp = new JPanel(new GridLayout(1, 3));
		jp.add(jp_grid_cp);
		jp.add(jp_grid_cq);
		jp.add(jp_grid_ctp);

		this.setLayout(new BorderLayout());
		this.add(jlb_phieubaucu, BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);
		this.add(jbt_thoat, BorderLayout.SOUTH);
		this.setTitle("Ket qua phieu bau cu cac cap");
		this.setSize(700, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new KetQuaPhieuBau();
	}
}
