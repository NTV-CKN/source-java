package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.view;

public class controller implements ActionListener, MouseListener{
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
		}else if(str.equals("Save")) {
			this.v.setTextNe(str);
		}else if(str.equals("Copy")) {
			this.v.setTextNe(str);
		}else if(str.equals("Cut")) {
			this.v.setTextNe(str);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.v.jppm.show(v, e.getX(), e.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.v.jppm.show(v, e.getX(), e.getY());
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
