package thi_de5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

public class BankManager extends JFrame {
	private JMenuBar jmb;
	private JMenu jmAM, jmExit;
	private JMenuItem jmi1, jmi2, jmi3;

	public BankManager() {
		this.init();
	}

	void init() {
		jmb = new JMenuBar();
		jmAM = new JMenu("Banking Manager");
		jmExit = new JMenu("Exit");
		jmi1 = new JMenuItem("Checking account");
		jmi2 = new JMenuItem("Saving account");
		jmi3 = new JMenuItem("Certificate of deposit");
		jmAM.add(jmi1);
		jmAM.add(jmi2);
		jmAM.add(jmi3);

		jmAM.setMnemonic('A');
		jmExit.setMnemonic('E');
		jmExit.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				System.exit(0);

			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jmExit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
		jmi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Checking account")) {
					new CheckingAccountProgram();
				}else if((e.CTRL_MASK + e.ALT_MASK + e.TEXT_EVENT_MASK) > Long.MIN_VALUE) {
					new CheckingAccountProgram();
				}
			}
		});
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Saving account")) {
					new SavingAccountProgram();
				}else if((e.CTRL_MASK + e.ALT_MASK + e.TEXT_EVENT_MASK) > Long.MIN_VALUE) {
					new SavingAccountProgram();
				}
			}
		});
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Certificate of deposit")) {
					new CertificateAccountProgram();
				}else if((e.CTRL_MASK + e.ALT_MASK + e.TEXT_EVENT_MASK) > Long.MIN_VALUE) {
					new CertificateAccountProgram();
				}
			}
		});
		
		jmb.add(jmAM);
		jmb.add(jmExit);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(jmb);
		this.setTitle("Banking Manager");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BankManager();
	}
}
