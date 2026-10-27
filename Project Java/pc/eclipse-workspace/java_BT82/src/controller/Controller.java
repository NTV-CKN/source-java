package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class Controller implements ActionListener{
	private View view;
	public Controller(View c) {
	this.view = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(e);
		if(src.equals("1")) {
			this.view.pick_1();
		}else if(src.equals("2")) {
			this.view.pick_2();
		}else if(src.equals("3")) {
			this.view.pick_3();
		}else if(src.equals("4")) {
			this.view.pick_4();
		}
	}
}
