package lab8;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ex8 extends JFrame {
	private JScrollPane jsp;
	private JList<String> jlist;
	private JLabel jlb;
	public Ex8() {
		this.init();
	}

	private void init() {
		String categories[] = { "Household", "Office", "Extended Family", "Company (US)", "Company (World)", "Team",
				"Will", "Birthday Card List", "High School", "Country", "Continent", "Planet" };
	//	jlist = new JList<String>(categories);
		jlist = new JList<String>(categories);
		
		jlist.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Object[] o = jlist.getSelectedValues();
				StringBuilder strb = new StringBuilder();
				for (int i = 0; i < o.length; i++) {
					strb.append(o[i].toString() + " ");
				}
				jlb.setText(strb.toString());
			}
		});
		
		jlb = new JLabel("j");
		
		jsp = new JScrollPane(jlist);
		

		this.setLayout(new BorderLayout());
		this.add(jsp, BorderLayout.CENTER);
		this.add(jlb, BorderLayout.NORTH);
		this.setTitle("JScrollPane Demo");
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex8();
	}
}
