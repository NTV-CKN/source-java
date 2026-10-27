package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import view.View;

public class main {
	public static void main(String[] args) {
		//look and feel
		try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		
		 new View();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 }
}
