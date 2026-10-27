package de5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class AccountProgram extends JFrame {
	public AccountProgram() {
		this.init();
	}

	private JMenuBar jmb;
	private JMenu jmn_account, jmn_exit;
	private JMenuItem jmni_sv, jmni_cd, jmni_ck;

	private void init() {
		jmb = new JMenuBar();
		this.setJMenuBar(jmb);

		jmn_account = new JMenu("Manager accounts");
		jmn_account.setMnemonic('A');
		jmn_exit = new JMenu("Exit");
		jmn_exit.setMnemonic('E');
		jmn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);;
			}
		});

		jmni_cd = new JMenuItem("CD");
		jmni_cd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmni_cd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CDProgram();
			}
		});
		jmni_ck = new JMenuItem("Checking");
		jmni_ck.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmni_ck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new CheckingAccountProgram();
			}
		});
		jmni_sv = new JMenuItem("Saving");
		jmni_sv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmni_sv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SavingAccountProgram();
			}
		});
		jmn_account.add(jmni_cd);
		jmn_account.add(jmni_ck);
		jmn_account.add(jmni_sv);

		jmb.add(jmn_account);
		jmb.add(jmn_exit);

		this.setTitle("Manager account");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AccountProgram();
	}
}
