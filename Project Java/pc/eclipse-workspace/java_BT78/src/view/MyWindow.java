package view;

import javax.swing.JFrame;

public class MyWindow extends JFrame{
	public MyWindow () {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//display window
	public void showWindow() {
		this.setVisible(true);
	}
	//display window and title
	public void showWT(String name, boolean hienThi) {
		this.setTitle(name);
		this.setVisible(hienThi);
	}
	//display window, title, size, location
	public void showWTSL(String name, int width, int height, int x, int y, boolean hienThi) {
		this.setTitle(name);
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setVisible(hienThi);
	}
	public static void main(String[] args) {
		MyWindow mw1 = new MyWindow();
		MyWindow mw2 = new MyWindow();
		MyWindow mw3 = new MyWindow();
		
//		mw1.showWindow();
//		mw2.showWT("VatLy2", true);
			mw3.showWTSL("ToanCaoCap", 800, 400, 550, 300, true);
	}
}
