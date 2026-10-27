package bufferimage;

import java.io.IOException;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame() {
		setSize(800, 600);
		setTitle("");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test board1;
		try {
			board1 = new Test();
			this.add(board1);
			setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Frame();
	}
}
