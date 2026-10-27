package lab6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainProgram extends JFrame {
	private JPanel jp_TextArea_Ans, jp_TextArea_Q, jp_Button;
	private JTextArea jt_Ans, jt_Q;
	private JButton jbutton_Exit = new JButton("Exit"), jbutton;
	private Main_Controller ac = new Main_Controller(this);
	private Font font_Normal = new Font("Arial", Font.BOLD, 15);

	// constructor
	public MainProgram() {
		this.init();
	}

	// set jframe
	void init() {
		this.setTitle("Ex 21");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);

		// jpanel
		jp_TextArea_Q = new JPanel(new GridLayout(3, 3));
		jp_TextArea_Ans = new JPanel(new BorderLayout());
		jp_Button = new JPanel(new GridLayout(5, 5));

		// setbackground
		jp_TextArea_Q.setBackground(Color.PINK);
		jp_TextArea_Ans.setBackground(Color.PINK);
		// j_textArea
		jt_Ans = new JTextArea("Neu chi co mot chuoi tren 1 dong thi cac "
				+ "phuong thuc lien quan 2 chuoi em se goi lai chuoi o dong 1");
		jt_Q = new JTextArea("radar", 3, 3);

		// jbutton
		for (int i = 1; i <= 20; i++) {
			jbutton = new JButton(i + "");
			jbutton.setBackground(Color.YELLOW);
			jbutton.setFont(font_Normal);
			jbutton.addActionListener(ac);
			this.jp_Button.add(jbutton);
		}
		// set button exit
		jbutton_Exit.setBackground(Color.BLACK);
		jbutton_Exit.setForeground(Color.YELLOW);
		jbutton_Exit.addActionListener(ac);
		this.jp_Button.add(jbutton_Exit);

		// add jtextArea
		jp_TextArea_Ans.add(jt_Ans, BorderLayout.CENTER);
		jp_TextArea_Q.add(jt_Q);

		// layout
		this.setLayout(new BorderLayout());
		this.add(jp_TextArea_Q, BorderLayout.NORTH);
		this.add(jp_TextArea_Ans, BorderLayout.CENTER);
		this.add(jp_Button, BorderLayout.SOUTH);
		this.setBackground(Color.GRAY);

		// set default on close and set visible for frame
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// methods
	void getCmd1() {
		jt_Ans.setText(Ex1.reverseString(jt_Q.getText()));
	}

	void getCmd2() {
		jt_Ans.setText(Ex2.isPalindrome(jt_Q.getText()) + "");
	}

	void getCmd3() {
		jt_Ans.setText(Ex3.countVC(jt_Q.getText()));
	}

	void getCmd4() {
		jt_Ans.setText(Ex4.findMaxWord(jt_Q.getText()));
	}

	void getCmd5() {
		String[] str = jt_Q.getText().split("\n");
		if (str.length == 1) {
			jt_Ans.setText(Ex5.isAnagram(str[0], jt_Q.getText()) + "");
			return;
		}
		jt_Ans.setText(Ex5.isAnagram(str[0], str[1]) + "");
	}

	void getCmd6() {
		jt_Ans.setText(Ex6.removeWhiteSpace(jt_Q.getText()));
	}

	void getCmd7() {
		jt_Ans.setText(Ex7.findSecondChar(jt_Q.getText()));
	}

	void getCmd8() {
		jt_Ans.setText(Ex8.removeFL(jt_Q.getText()));
	}

	void getCmd9() {
		jt_Ans.setText(Ex9.countString(jt_Q.getText()) + "");
	}

	void getCmd10() {
		jt_Ans.setText(Ex10.isDigit(jt_Q.getText()) + "");
	}

	void getCmd11() {
		jt_Ans.setText(Ex11.countVowel(jt_Q.getText()) + "");
	}

	void getCmd12() {
		jt_Ans.setText(Ex12.reverseString(jt_Q.getText()));
	}

	void getCmd13() {
		String[] str = jt_Q.getText().split("\n");
		if (str.length == 1) {
			jt_Ans.setText(Ex13.isAnagram(str[0], jt_Q.getText()) + "");
			return;
		}
		jt_Ans.setText(Ex13.isAnagram(str[0], str[1]) + "");
	}

	void getCmd14() {
		jt_Ans.setText(Ex14.removeWhiteSpace(jt_Q.getText()));
	}

	void getCmd15() {
		jt_Ans.setText(Ex15.capitalize(jt_Q.getText()));
	}

	void getCmd16() {
		jt_Ans.setText(Ex16.isPalindrome(jt_Q.getText()) + "");
	}

	void getCmd17() {
		jt_Ans.setText(Ex17.returnSubstring(jt_Q.getText()));
	}

	void getCmd18() {
		jt_Ans.setText(Ex18.reverseString(jt_Q.getText()));
	}

	void getCmd19() {
		String[] str = jt_Q.getText().split("\n");
		if (str.length == 1) {
			jt_Ans.setText(Ex19.concatTwoString(str[0], jt_Q.getText()));
			return;
		}
		jt_Ans.setText(Ex19.concatTwoString(str[0], str[1]));
	}

	void getCmd20() {
		jt_Ans.setText(Ex20.removeSC(jt_Q.getText()));
	}

	void exitProgram() {
		// exitprogram
		System.exit(0);
	}

	public static void main(String[] args) {
		new MainProgram();
	}
}
