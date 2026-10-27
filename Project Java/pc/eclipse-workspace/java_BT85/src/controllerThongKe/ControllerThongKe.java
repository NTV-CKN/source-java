package controllerThongKe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewThongKe;

public class ControllerThongKe implements ActionListener {
	private ViewThongKe v;
	//construtor
	public ControllerThongKe(ViewThongKe v) {
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thong Ke")) {
		this.v.thongKe();
	}}

}
