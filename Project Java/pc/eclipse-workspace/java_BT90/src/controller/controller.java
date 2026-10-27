package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view;

public class controller implements ActionListener{
	private view v;
	public controller(view v) {
		this.v =v;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("Open file")) {
			this.v.setTextNe(str);
		}else if(str.equals("Undo typing")) {
			this.v.setTextNe(str);
		}else if(str.equals("Generate Constructor using Fields")) {
			this.v.setTextNe(str);
		}else if(str.equals("Rename")) {
			this.v.setTextNe(str);
		}else if(str.equals("Back")) {
			this.v.setTextNe(str);
		}else if(str.equals("Search")) {
			this.v.setTextNe(str);
		}else if(str.equals("Java Project")) {
			this.v.setTextNe(str);
		}
	}

}
