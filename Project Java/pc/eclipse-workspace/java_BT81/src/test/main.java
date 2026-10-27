package test;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import model.CounterModel;
import view.CounterView;
import view.CounterView;

public class main {
	public static void main(String[] args) {
		//CounterModel ctm = new CounterModel();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			CounterView ctv = new CounterView();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
