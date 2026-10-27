package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.concurrent.Flow;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controllor.ConvertControllor;
import controllor.IControllor;
import model.IModel;
import model.Number;
import model.Observable;

public class ConvertView extends JFrame implements Observer {
	private IControllor controllor;
	private IModel model;
	private JRadioButton rdBin, rdHex, rdOct;
	private JTextField jtf_input_result;
	private JLabel jlb_result;
	private ButtonGroup bg;

	public ConvertView(IModel model) throws HeadlessException {
		super();
		this.model = model;
		controllor = new ConvertControllor(model, this);
		if (model instanceof Number) {
			((Number) model).addObserver(this);
		}

		displayView();
	}

	private void displayView() {
		generateWidgets();

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Converter");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
	}

	private void generateWidgets() {
		jlb_result = new JLabel();

		rdBin = new JRadioButton("Binary");
		rdBin.addItemListener((ItemListener) controllor);
		rdBin.addActionListener((ActionListener) controllor);

		rdHex = new JRadioButton("Hexadecimal");
		rdHex.addItemListener((ItemListener) controllor);
		rdHex.addActionListener((ActionListener) controllor);

		rdOct = new JRadioButton("Octal");
		rdOct.addItemListener((ItemListener) controllor);
		rdOct.addActionListener((ActionListener) controllor);

		bg = new ButtonGroup();
		bg.add(rdBin);
		bg.add(rdHex);
		bg.add(rdOct);

		jtf_input_result = new JTextField();

		JPanel jp_grid = new JPanel(new GridLayout(3, 2, 2, 2));
		jp_grid.add(new JLabel("Decimal:"));
		jp_grid.add(jtf_input_result);
		jp_grid.add(new JLabel("Result:"));
		jp_grid.add(jlb_result);
		jp_grid.add(new JLabel("Convert to:"));

		JPanel jp_flow = new JPanel(new FlowLayout());
		jp_flow.add(rdBin);
		jp_flow.add(rdHex);
		jp_flow.add(rdOct);

		this.setLayout(new BorderLayout());
		this.add(jp_grid, BorderLayout.CENTER);
		this.add(jp_flow, BorderLayout.SOUTH);
	}

	@Override
	public void update(Observable ob, Object obj) {
		jlb_result.setText("Result: " + obj.toString());
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public IControllor getControllor() {
		return controllor;
	}

	public IModel getModel() {
		return model;
	}

	public JRadioButton getRdBin() {
		return rdBin;
	}

	public JRadioButton getRdHex() {
		return rdHex;
	}

	public JRadioButton getRdOct() {
		return rdOct;
	}

	public JTextField getJtf_input_result() {
		return jtf_input_result;
	}

	public JLabel getJlb_result() {
		return jlb_result;
	}

}
