package lab7;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex5 extends JFrame {
	private JLabel jlb_name,  jlb_money, jlb_displayN, jlb_displayG, jlb_displayM;
	private JTextField jtxf_name, jtxf_money;
	private JRadioButton jrd1, jrd2;
	private ButtonGroup bg;

	public Ex5() {
		this.init();
	}

	void init() {
		bg = new ButtonGroup();
		jrd1 = new JRadioButton("nam");
		jrd1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb_displayG.setText("nam");
			}
		});
		jrd2 = new JRadioButton("nu");
		jrd2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb_displayG.setText("nu");
			}
		});
		bg.add(jrd1);
		bg.add(jrd2);

		jtxf_name = new JTextField(20);
		jtxf_name.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jlb_displayN.setText(jtxf_name.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jtxf_money = new JTextField(20);
		jtxf_money.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Double money = Double.parseDouble(jtxf_money.getText());
				jlb_displayM.setText(String.format("%, .2f", money));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jlb_name = new JLabel("Ho va ten: ");
		jlb_money = new JLabel("Nhap tien: ");
		jlb_displayG = new JLabel("null");
		jlb_displayM = new JLabel("null");
		jlb_displayN = new JLabel("null");
		
		this.setLayout(new GridLayout(3,3));
		this.add(jlb_name);
		this.add(jtxf_name);
		this.add(jlb_displayN);
		this.add(jrd1);
		this.add(jrd2);
		this.add(jlb_displayG);
		this.add(jlb_money);
		this.add(jtxf_money);
		this.add(jlb_displayM);
		
		this.setTitle("Ex5");
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex5();
	}
}
