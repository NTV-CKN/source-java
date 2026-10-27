package lab8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex11 extends JFrame {
	private List<JCheckBox> listCheckBox;
	private List<JLabel> listLabel;
	private JLabel jlb_result;
	private JPanel jp;

	public Ex11() {
		this.init();
	}

	public void init() {
		ItemListener iL = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				StringBuilder strB = new StringBuilder();
				for (int i = 0; i < listCheckBox.size(); i++) {
					if(listCheckBox.get(i).isSelected()) {
						strB.append(listLabel.get(i).getText() + " ");
					}
				}
				jlb_result.setText(strB.toString());
			}
		};
		listCheckBox = new ArrayList<JCheckBox>();
		listLabel = new ArrayList<JLabel>();
		jlb_result = new JLabel("Result");
		jp = new JPanel(new GridLayout(13, 2));
		String[] arr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve" };
	
		for (int i = 0; i < 13; i++) {
			listCheckBox.add(new JCheckBox("Selection " + i));
			listLabel.add(new JLabel(arr[i]));
			jp.add(listLabel.get(i));
			jp.add(listCheckBox.get(i));
			listCheckBox.get(i).addItemListener(iL);
		}

		this.setLayout(new BorderLayout());
		this.add(jlb_result, BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);
		this.setTitle("JScrollBar Demo");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex11();
	}
}
