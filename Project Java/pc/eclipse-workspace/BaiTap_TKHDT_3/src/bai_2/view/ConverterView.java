package bai_2.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bai_2.Converter;
import bai_2.IModel;
import bai_2.Observable;
import bai_2.SymbolUnit;
import bai_2.controllor.ConverterControllor;
import bai_2.controllor.IControllor;

public class ConverterView extends JFrame implements Observer {
	private IModel model;
	private IControllor controllor;
	public JLabel jlb_result;
	public JTextField jtf_input_value;
	public JComboBox<SymbolUnit> jcb_unit_from, jcb_unit_to;
	public JComboBox<String> jcb_choose_type_convert;
	public String[] arrTypeConverrt = { "Distance", "Concurrency" };
	public JButton jbtn_convert;

	public ConverterView(IModel model) throws HeadlessException {
		super();
		this.model = model;
		controllor = new ConverterControllor(model, this);
		if (model instanceof Converter)
			((Converter) model).addObserver(this);

		displayView();
	}

	private void displayView() {
		genWidgets();

		this.setVisible(true);
		this.setTitle("Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
	}

	private void genWidgets() {
		jcb_choose_type_convert = new JComboBox<String>(arrTypeConverrt);
		jcb_choose_type_convert.setSelectedIndex(0);
		jcb_choose_type_convert.addItemListener((ItemListener) controllor);

		jcb_unit_from = new JComboBox<SymbolUnit>();
		jcb_unit_from.addActionListener(e -> {
			if (jcb_choose_type_convert.getSelectedItem().equals(arrTypeConverrt[0])) {
				jcb_unit_to.setSelectedItem(jcb_unit_from.getSelectedItem());
			}
		});
		jcb_unit_to = new JComboBox<SymbolUnit>();
		jcb_unit_to.addActionListener(e -> {
			if (jcb_choose_type_convert.getSelectedItem().equals(arrTypeConverrt[0])) {
				jcb_unit_from.setSelectedItem(jcb_unit_to.getSelectedItem());
			}
		});

		changeItemOfJcb(arrTypeConverrt[0]);

		jbtn_convert = new JButton("Convert");
		jbtn_convert.addActionListener((ActionListener) controllor);

		jtf_input_value = new JTextField();

		jlb_result = new JLabel();

		JPanel jp_grid = new JPanel(new GridLayout(5, 2, 2, 2));
		jp_grid.add(new JLabel("Choose type convert:"));
		jp_grid.add(jcb_choose_type_convert);
		jp_grid.add(new JLabel("Input your value:"));
		jp_grid.add(jtf_input_value);
		jp_grid.add(new JLabel("Unit from:"));
		jp_grid.add(jcb_unit_from);
		jp_grid.add(new JLabel("Unit to:"));
		jp_grid.add(jcb_unit_to);
		jp_grid.add(jbtn_convert);
		jp_grid.add(jlb_result);
		this.add(jp_grid);
	}

	public void changeItemOfJcb(String str) {
		jcb_unit_from.removeAllItems();
		jcb_unit_to.removeAllItems();
		if (str.equals(arrTypeConverrt[0])) {
			jcb_unit_from.addItem(SymbolUnit.MeterToMile);
			jcb_unit_from.addItem(SymbolUnit.MeterToYard);
			jcb_unit_to.addItem(SymbolUnit.MeterToMile);
			jcb_unit_to.addItem(SymbolUnit.MeterToYard);

		} else {
			for (int i = 0; i < 4; i++) {
				jcb_unit_from.addItem(SymbolUnit.values()[i]);
				jcb_unit_to.addItem(SymbolUnit.values()[i]);
			}
		}
	}

	@Override
	public void update(Observable observable, Object obj) {
		this.jlb_result.setText(obj.toString());

	}
}
