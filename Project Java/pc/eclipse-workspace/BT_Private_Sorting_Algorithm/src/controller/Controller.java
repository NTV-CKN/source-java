package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BubbleSortWorker;
import view.View;


public class Controller implements ActionListener{
	View v;
	public Controller(View v) {
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String getCommand = e.getActionCommand();
		
		if(getCommand.equals("Search")){
			System.out.println(v.jtext_Search_Sort.getText());
		}else if(getCommand.equals("Accept")) {
			v.splitJText_Array(v.jtext_Array.getText());
		}else if(getCommand.equals("Start")) {
		   v.startArrayV2(v.nums);
		}else if(getCommand.equals("Display/Reset")) {
			v.displayArray();
		}
	}

}
