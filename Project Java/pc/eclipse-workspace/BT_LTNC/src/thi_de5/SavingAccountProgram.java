package thi_de5;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SavingAccountProgram extends JFrame {
	private JButton jbt_add, jbt_clear;
	private JPanel jp_addclear, jp_textf, jp_bar;
	private JLabel jlb_checking, jlb_ID, jlb_Name, jlb_interest, jlb_CurrentBalance, jlb_IR, jlb_CB, jlb_id, jlb_name;
	private JTextField jtxf_ID, jtxf_Name, jtxf_IR, jtxf_Curr;
	private JTextArea jtxa;
	private Bai3 b3 = new Bai3();
	private Account[] list = b3.myAccount();

	public SavingAccountProgram() {
		this.init();
	}

	private void init() {
		jbt_add = new JButton("Add", new ImageIcon("C:\\Users\\pc\\Desktop\\shot1.png"));
		jbt_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SavingAccount temp;
				StringBuilder strB = new StringBuilder();
				SavingAccount check = new SavingAccount(jtxf_ID.getText(), jtxf_Name.getText(),
						Double.parseDouble(jtxf_IR.getText()), Double.parseDouble(jtxf_Curr.getText()));
				for (int i = 0; i < list.length; i++) {
					if (list[i] != null && list[i] instanceof SavingAccount) {
						temp = (SavingAccount) list[i];
						if (check.getId().equals(list[i].getId()) || check.getName().equals(temp.getName())
								|| check.getCurrentBalance() == list[i].getCurrentBalance()
								|| check.getInterestRate() == temp.getInterestRate()) {
							strB.append(temp + "\n");
						}
					} 
				}
				jtxa.setText(strB.toString());
			}
		});
		jbt_clear = new JButton("Clear",
				new ImageIcon("C:\\Users\\pc\\Pictures\\Screenshots\\Ảnh chụp màn hình 2024-05-07 230555.png"));
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtxf_Curr.setText("");
				jtxf_ID.setText("");
				jtxf_IR.setText("");
				jtxf_Name.setText("");
			}
		});
		jp_addclear = new JPanel(new FlowLayout());
		jp_textf = new JPanel(new GridLayout(5, 2));
		jp_bar = new JPanel(new FlowLayout());

		jlb_checking = new JLabel("Checking account infomation");
		jlb_ID = new JLabel("ID");
		jlb_Name = new JLabel("Name");
		jlb_interest = new JLabel("Interest Rate");
		jlb_CurrentBalance = new JLabel("Current Balance");
		jlb_id = new JLabel("ID");
		jlb_name = new JLabel("Name");
		jlb_CB = new JLabel("CB");
		jlb_IR = new JLabel("IR (%)");

		jtxf_ID = new JTextField("");
		jtxf_Name = new JTextField("");
		jtxf_Curr = new JTextField("");
		jtxf_IR = new JTextField("");
		jtxa = new JTextArea("");

		jp_bar.add(jlb_ID);
		jp_bar.add(jlb_name);
		jp_bar.add(jlb_IR);
		jp_bar.add(jlb_CB);
		jp_addclear.add(jbt_add);
		jp_addclear.add(jbt_clear);
		jp_textf.add(jlb_ID);
		jp_textf.add(jtxf_ID);
		jp_textf.add(jlb_Name);
		jp_textf.add(jtxf_Name);
		jp_textf.add(jlb_interest);
		jp_textf.add(jtxf_IR);
		jp_textf.add(jlb_CurrentBalance);
		jp_textf.add(jtxf_Curr);
		jp_textf.add(jlb_checking);

		this.setLayout(new GridLayout(4, 1));
		this.add(jp_addclear);
		this.add(jp_textf);
		this.add(jp_bar);
		this.add(jtxa);
		this.setTitle("Saving Account");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SavingAccountProgram();
	}
}
