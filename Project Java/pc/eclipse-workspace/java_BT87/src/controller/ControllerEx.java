package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.ViewEx;

public class ControllerEx implements MouseListener, MouseMotionListener{
	private ViewEx view;
	//constructor 
	public ControllerEx(ViewEx v) {
		this.view = v;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.view.updatePosition(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.count();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.view.entered();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.view.exited();
	}

}
