package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CounterView;

public class CounterListener implements ActionListener{
	private CounterView ctv;
	public CounterListener(CounterView v) {
		this.ctv = v;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand()+"";
		//String src = e+"";
		System.out.println(src);
		if(src.equals("UP")) {
			ctv.tang();
		}else if(src.equals("DOWN")) {
			ctv.giam();
		}else if(src.equals("reset")) {
			ctv.reset();
		}
	}

}
