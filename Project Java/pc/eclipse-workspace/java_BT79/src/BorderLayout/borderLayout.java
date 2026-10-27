package BorderLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class borderLayout extends JFrame{
	public borderLayout() {
		// TODO Auto-generated constructor stub
	}
	public void borderLayout() {
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.setTitle("BorderLayout");
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		
		for (int i = 0; i < 21; i++) {
			if(i>= 0 && i <=4) {
				int luu = 1+i;
				JButton jb = new JButton(""+ i);
				this.add(jb, BorderLayout.NORTH);		
				
			}	if(i>= 5 && i <=9) {
				JButton jb = new JButton(""+  i);
				this.add(jb, BorderLayout.SOUTH);		
			}	if(i>= 10 && i <=14) {
				JButton jb = new JButton(""+ i);
				this.add(jb, BorderLayout.EAST);		
			}	if(i>= 15 && i <=19) {
				JButton jb = new JButton(""+ i);
				this.add(jb, BorderLayout.WEST);		
			}
		}
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		borderLayout bl = new borderLayout();
		bl.borderLayout();
	}
}
