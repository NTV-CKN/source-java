package lab8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JScrollPane;

public class Ex9 extends JFrame {
	private List<JRadioButton[]> listRadio;
	private List<ButtonGroup> listBg;
	private JRadioButton[] radios;
	private JScrollPane jscp;
	private JPanel jp;
	private JLabel jlb = new JLabel(" ", DEFAULT_CURSOR);
	private ItemListener iL;

	public Ex9() {
		this.init();
	}

	public void init() {
		String categories[] = { "Household", "Office", "Extended Family", "Company (US)", "Company (World)", "Team",
				"Will", "Birthday Card List", "High School", "Country", "Continent", "Planet" };
		iL = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				StringBuilder strB = new StringBuilder();
				for (int i = 0; i < listBg.size(); i++) {
					if (listRadio.get(i)[0].isSelected() || listRadio.get(i)[1].isSelected()
							|| listRadio.get(i)[2].isSelected()) {
						strB.append("Da chon " + categories[i] + "\t");
					}
				}
				jlb.setText(strB.toString());

			}
		};
		listRadio = new ArrayList<JRadioButton[]>();
		listBg = new ArrayList<ButtonGroup>();

		jp = new JPanel(new GridLayout(categories.length + 1, 4, 5, 5));
		jp.add(new JLabel(" "));
		jp.add(new JLabel("0-1"));
		jp.add(new JLabel("2-5"));
		jp.add(new JLabel("6-10"));

		for (int i = 0; i < categories.length; i++) {
			ButtonGroup bg = new ButtonGroup();
			radios = new JRadioButton[3];
			radios[0] = new JRadioButton();
			radios[0].addItemListener(iL);
			bg.add(radios[0]);
			radios[1] = new JRadioButton();
			radios[1].addItemListener(iL);
			bg.add(radios[1]);
			radios[2] = new JRadioButton();
			radios[2].addItemListener(iL);
			bg.add(radios[2]);
			listBg.add(bg);

			jp.add(new JLabel(categories[i]));
			jp.add(radios[0]);
			jp.add(radios[1]);
			jp.add(radios[2]);
			listRadio.add(radios);
		}

		jscp = new JScrollPane(jp);

		this.setLayout(new BorderLayout());
		this.add(jscp, BorderLayout.CENTER);
		this.add(jlb, BorderLayout.NORTH);
		this.setTitle("JScrollPane demonstration");
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex9();
	}
}
