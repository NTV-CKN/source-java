package controllor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Unit;
import model.interfaces.IModel;
import view.ConvertView;

public class ConvertControllor implements IConvertControllor, ActionListener {
	private ConvertView view;
	private IModel model;

	public ConvertControllor(ConvertView view, IModel model) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void startConvert() {
		double value = 0;
		try {
			value = Double.parseDouble(view.getJtf_input_value().getText());
			String result = model.convert((Unit) view.getJcb_from().getSelectedItem(),
					(Unit) view.getJcb_to().getSelectedItem(), value);
		} catch (Exception e) {
			view.update(null, value);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("0");
		if (cmd.equals(view.getJbtn_convert().getText())) {
			System.out.println("1");
			startConvert();
		}
	}

	@Override
	public void setModel(IModel model) {
		this.model = model;
	}
}
