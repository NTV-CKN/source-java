package lab10;

import lab10.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex1 extends JFrame {
	private JTextField jtf = new JTextField();
	private JButton jbt_number, jbt_start, jbt_stop, jbt_place;
	private List<JButton> listBt = new ArrayList<JButton>();
	private JPanel jp1, jp2;

	public Ex1() {
		this.init();
	}

	void init() {
		jbt_start = new JButton("Start");
		jbt_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText(jbt_start.getText());
			}
		});
		jbt_stop = new JButton("Stop");
		jbt_stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText(jbt_stop.getText());
			}
		});
		jbt_place = new JButton("Food to be placed here");
		jbt_place.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText(jbt_place.getText());
			}
		});

		for (int i = 0; i < 10; i++) {
			jbt_number = new JButton(i + "");
			listBt.add(jbt_number);int x = i;
			listBt.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jtf.setText(listBt.get(x).getText());
				}
			});
		}

		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new GridLayout(4, 3));

		jp1.add(jtf, BorderLayout.NORTH);

		for (int i = 1; i < 10; i++) {
			jp2.add(listBt.get(i));

		}
		jp2.add(listBt.get(0));
		jp2.add(jbt_start);
		jp2.add(jbt_stop);

		jp1.add(jp2, BorderLayout.CENTER);

		this.setLayout(new GridLayout(1, 2));
		this.add(jbt_place);
		this.add(jp1);

		this.setTitle("Ex2");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex1();
	}
}
