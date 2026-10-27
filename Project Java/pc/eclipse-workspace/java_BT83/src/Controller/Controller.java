package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class Controller implements ActionListener{
	private View v;
	public Controller(View v) {
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if(src.equals("Text Red")) {
			this.v.changeTextColor_red();
		}else if(src.equals("Text Yellow")) {
			this.v.changeTextColor_yellow();
		}else if(src.equals("Text Green")) {
			this.v.changeTextColor_green();
		}else if(src.equals("BG Red")) {
			this.v.changeBGColor_red();
		}else if(src.equals("BG Yellow")) {
			this.v.changeBGColor_yellow();
			}else if(src.equals("BG Green")) {
				this.v.changeBGColor_green();
				}
	}

}
