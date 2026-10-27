package GridLayout;

import java.awt.GridLayout;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;

public class gridLayout extends JFrame {
	public gridLayout() {
		// TODO Auto-generated constructor stub
	}
	public void gridLayout() {
	//	GridLayout gl = new GridLayout(4, 4 , 50, 100);
		GridLayout gl = new GridLayout(4,4);
		//GridLayout gl = new GridLayout();
		this.setLayout(gl);
		
		this.setSize(900, 600);
		this.setTitle("GridLayout null");
		this.setLocationRelativeTo(null);
		
		for (int i = 0; i < 16; i++) {
			JButton jb = new JButton(i+1 +"");
			this.add(jb);
		}
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		gridLayout gl = new gridLayout();
		gl.gridLayout();
	}
}
