package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import view.View;

public class Controller implements ActionListener {
private View view;
public Controller(View v ) {
this.view = v;
}
@Override
public void actionPerformed(ActionEvent e) {
	String src = e.getActionCommand();
	System.out.println(src);
	if(src.equals("+")) {
		this.view.plus();
	}else if(src.equals("-")) {
		this.view.except();
	}else if(src.equals("x")) {
		this.view.mutiply();
	}else if(src.equals("/")) {
		this.view.divide();
	}else if(src.equals("mod")) {
		this.view.mod();
	}else if(src.equals("^")) {
		this.view.pow();
	}
}
}
