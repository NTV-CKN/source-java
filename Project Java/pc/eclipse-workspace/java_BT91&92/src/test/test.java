package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.view;

public class test {
	public static void main(String[] args) {
		//look and feel
		try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		
		 new view();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
