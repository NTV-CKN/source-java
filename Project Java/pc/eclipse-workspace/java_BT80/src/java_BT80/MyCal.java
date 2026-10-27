package java_BT80;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MyCal extends JFrame {
	public MyCal() {
		this.setTitle("Computer Interface");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//JTextField
		JTextField jt = new JTextField(100);
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(jt, BorderLayout.CENTER);
		//JButton 
		JButton jb;
		List<JButton>listButton = new ArrayList<JButton>();
		for(int i=0; i<10; i++) {
			 jb = new JButton(""+i);
			 listButton.add(jb);
		}
		JButton jb_cong = new JButton("+");
		JButton jb_tru = new JButton("-");
		JButton jb_nhan = new JButton("x");
		JButton jb_chia = new JButton("/");
		JButton jb_bang = new JButton("=");
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(5,3));
		for (JButton list : listButton) {
			jp2.add(list);
		}
		jp2.add(jb_cong);
		jp2.add(jb_tru);
		jp2.add(jb_nhan);
		jp2.add(jb_chia);
		jp2.add(jb_bang);
		
		//setlayoutFrame
		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		
		//display
		this.setVisible(true);
		//Exit_on_close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	public static void main(String[] args) {
		
			//look and feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		MyCal mc = new MyCal();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
