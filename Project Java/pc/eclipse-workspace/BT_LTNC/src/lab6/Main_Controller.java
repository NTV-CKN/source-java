package lab6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Controller implements ActionListener {
	private MainProgram view;

	// constructor
	public Main_Controller(MainProgram v) {
		view = v;
	}

	// start the command
	void startTheCommands(int save) {
		switch (save) {
		case 1:
			view.getCmd1();
			break;
		case 2:
			view.getCmd2();
			break;
		case 3:
			view.getCmd3();
			break;
		case 4:
			view.getCmd4();
			break;
		case 5:
			view.getCmd5();
			break;
		case 6:
			view.getCmd6();
			break;
		case 7:
			view.getCmd7();
			break;
		case 8:
			view.getCmd8();
			break;
		case 9:
			view.getCmd9();
			break;
		case 10:
			view.getCmd10();
			break;
		case 11:
			view.getCmd11();
			break;
		case 12:
			view.getCmd12();
			break;
		case 13:
			view.getCmd13();
			break;
		case 14:
			view.getCmd14();
			break;
		case 15:
			view.getCmd15();
			break;
		case 16:
			view.getCmd16();
			break;
		case 17:
			view.getCmd17();
			break;
		case 18:
			view.getCmd18();
			break;
		case 19:
			view.getCmd19();
			break;
		case 20:
			view.getCmd20();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	// override action per button
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		// if Exit => return program
		if (str.equals("Exit")) {
			view.exitProgram();
		} else {
			int save = Integer.parseInt(str);
			this.startTheCommands(save);
		}
	}
}
