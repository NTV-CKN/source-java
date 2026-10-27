package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class Controller implements ActionListener{
	private View v;
	//constructor
	public Controller(View v) {
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("TAI")) {
			this.v.tai();
		}else if(src.equals("XIU")) {
			this.v.xiu();
		}else if(src.equals("Tung Xuc Sac")) {
			this.v.thongKe();
		}else if(src.equals("Xac Nhan")) {
			this.v.xacNhan();
		}
	}
	
}
