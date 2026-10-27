package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllor.ConvertControllor;
import controllor.IConvertControllor;
import model.Converter;
import model.DistanceConverter;
import model.TemperatureConverter;
import model.Unit;
import model.interfaces.IModel;
import model.interfaces.Observable;

public class ConvertView extends JFrame implements Observer {
	private IConvertControllor controllor;
	private IModel model;
	private JLabel jlb_result;
	private JButton jbtn_convert;
	private JComboBox<Unit> jcb_to, jcb_from;
	private JComboBox<String> jcb_choose_unit;
	private Unit[] array_distance = { Unit.Centimeter, Unit.Kilometer, Unit.Meter },
			array_temperature = { Unit.Celsius, Unit.Fahrenheit, Unit.Kelvin };
	private String[] array_choose_unit = { "Distance", "Temperature" };
	private JTextField jtf_input_value;

	public ConvertView(IModel model) throws HeadlessException {
		super();
		this.controllor = new ConvertControllor(this, model);
		this.model = model;
		
		if(model instanceof Observable) {
			((Observable) model).addObserver(this);
		}
		
		displayView();
	}

	private void displayView() {
		generateWidget();
		this.setTitle("Converter");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void generateWidget() {
		this.jcb_from = new JComboBox<Unit>(array_distance);
		this.jcb_to = new JComboBox<Unit>(array_distance);
		this.jcb_choose_unit = new JComboBox<String>(array_choose_unit);
		this.jcb_choose_unit.addActionListener(e -> {
			if (jcb_choose_unit.getSelectedItem().toString().equals(array_choose_unit[0])) {
				this.jcb_from.removeAllItems();
				this.jcb_to.removeAllItems();
				for (Unit unit : array_distance) {
					jcb_from.addItem(unit);
					jcb_to.addItem(unit);
				}

				this.model.setStrategy(new DistanceConverter());
			} else {
				this.jcb_from.removeAllItems();
				this.jcb_to.removeAllItems();
				for (Unit unit : array_temperature) {
					jcb_from.addItem(unit);
					jcb_to.addItem(unit);
				}

				this.model.setStrategy(new TemperatureConverter());
			}
			this.revalidate();
		});

		this.jcb_choose_unit.setSelectedIndex(0);// 0 la distance

		this.jtf_input_value = new JTextField();

		this.jbtn_convert = new JButton("Convert");
		this.jbtn_convert.addActionListener((ActionListener) controllor);
		this.jlb_result = new JLabel("Result: ");

		JPanel jp_grid = new JPanel(new GridLayout(5, 2, 2, 2));
		jp_grid.add(new JLabel("Choose Option You Want Convert"));
		jp_grid.add(jcb_choose_unit);
		jp_grid.add(new JLabel("Input value: "));
		jp_grid.add(this.jtf_input_value);
		jp_grid.add(new JLabel("Unit From:"));
		jp_grid.add(jcb_from);
		jp_grid.add(new JLabel("Unit To:"));
		jp_grid.add(jcb_to);
		jp_grid.add(jbtn_convert);
		jp_grid.add(jlb_result);

		this.add(jp_grid, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable observable, Object obj) {
		if (observable instanceof Converter) {
			jlb_result.setText("Result: " + obj.toString());
			return;
		}
		jlb_result.setText("Result: " + obj.toString());
	}

	public IConvertControllor getControllor() {
		return controllor;
	}

	public IModel getModel() {
		return model;
	}

	public JLabel getJlb_result() {
		return jlb_result;
	}

	public JButton getJbtn_convert() {
		return jbtn_convert;
	}

	public JComboBox<Unit> getJcb_to() {
		return jcb_to;
	}

	public JComboBox<Unit> getJcb_from() {
		return jcb_from;
	}

	public JComboBox<String> getJcb_choose_unit() {
		return jcb_choose_unit;
	}

	public Unit[] getArray_distance() {
		return array_distance;
	}

	public Unit[] getArray_temperature() {
		return array_temperature;
	}

	public String[] getArray_choose_unit() {
		return array_choose_unit;
	}

	public JTextField getJtf_input_value() {
		return jtf_input_value;
	}

}
