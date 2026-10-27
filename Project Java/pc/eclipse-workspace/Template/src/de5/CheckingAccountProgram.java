package de5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckingAccountProgram extends JFrame {
	public CheckingAccountProgram() {
		this.init();
	}

	private JButton jbt_add, jbt_clear;
	private JLabel jlb_id1, jlb_name1, jlb_mb1, jlb_cb1;
	private JLabel jlb_id2, jlb_name2, jlb_mb2, jlb_cb2;
	private JTextField jtf_id, jtf_name, jtf_mb, jtf_cd;
	private JLabel show1;
	private JPanel jp_flow, jp_grid;
	private Bai3 bai3 = new Bai3();
	private JTextArea jtfa = new JTextArea();

	private void init() {
		jbt_add = new JButton("Add");
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bai3.createAccounts();
				CheckingAccount temp = new CheckingAccount(jtf_id.getText(), jtf_name.getText(),
						Double.parseDouble(jtf_cd.getText()), Double.parseDouble(jtf_mb.getText()));
				StringBuilder strB = new StringBuilder();
				for (int i = 0; i < bai3.getList().size(); i++) {
					if (bai3.getList().get(i) instanceof CheckingAccount) {
						if (bai3.getList().get(i).getId().equals(temp.getId())
								|| bai3.getList().get(i).getName().equals(temp.getName())
								|| bai3.getList().get(i).getCurrentBalance() == temp.getCurrentBalance()
								|| ((CheckingAccount) bai3.getList().get(i)).getMinBalance() == temp.getMinBalance()) {
							strB.append(bai3.getList().get(i).toString());
						}
					}
				}
				jtfa.setText(strB.toString());
			}
		});
		jbt_clear = new JButton("Clear");
		jbt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf_cd.setText("");
				jtf_id.setText("");
				jtf_mb.setText("");
				jtf_name.setText("");
			}
		});

		jp_flow = new JPanel(new FlowLayout());
		jp_grid = new JPanel(new GridLayout(4, 2));

		jlb_cb1 = new JLabel("CB");
		jlb_id1 = new JLabel("ID");
		jlb_mb1 = new JLabel("MB");
		jlb_name1 = new JLabel("Name");

		jtf_cd = new JTextField();
		jtf_id = new JTextField();
		jtf_mb = new JTextField();
		jtf_name = new JTextField();

		jlb_cb2 = new JLabel("CB");
		jlb_id2 = new JLabel("ID");
		jlb_mb2 = new JLabel("MB");
		jlb_name2 = new JLabel("Name");

		JPanel jp_floww = new JPanel(new GridLayout(2, 4));
		show1 = new JLabel("Checking Account info");
		jp_floww.add(show1);
		jp_floww.add(new JLabel());
		jp_floww.add(new JLabel());
		jp_floww.add(new JLabel());
		jp_floww.add(jlb_id2);
		jp_floww.add(jlb_name2);
		jp_floww.add(jlb_mb2);
		jp_floww.add(jlb_cb2);

		jp_flow.add(jbt_add);
		jp_flow.add(jbt_clear);

		jp_grid.add(jlb_id1);
		jp_grid.add(jtf_id);
		jp_grid.add(jlb_name1);
		jp_grid.add(jtf_name);
		jp_grid.add(jlb_mb1);
		jp_grid.add(jtf_mb);
		jp_grid.add(jlb_cb1);
		jp_grid.add(jtf_cd);

		JPanel jp = new JPanel(new BorderLayout());
		jp.add(jp_flow, BorderLayout.NORTH);
		jp.add(jp_grid, BorderLayout.CENTER);
		jp.add(jp_floww, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);
		this.add(jtfa, BorderLayout.CENTER);
		this.setTitle("Checking account");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CheckingAccountProgram();
	}
}
