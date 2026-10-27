package controllor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.IModel;
import model.Number;
import model.strategy.ConversionFunction;
import model.strategy.DectToBin;
import model.strategy.DectToHex;
import model.strategy.DectToOct;
import view.ConvertView;

public class ConvertControllor implements IControllor, ActionListener, ItemListener {
	private IModel model;
	private ConvertView view;

	public ConvertControllor(IModel model, ConvertView view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals(view.getRdBin().getText()))
			itemStateChanged(new ItemEvent(view.getRdBin(), 0, e, ItemEvent.SELECTED));
		else if (cmd.equals(view.getRdHex().getText()))
			itemStateChanged(new ItemEvent(view.getRdHex(), 0, e, ItemEvent.SELECTED));
		else if (cmd.equals(view.getRdOct().getText()))
			itemStateChanged(new ItemEvent(view.getRdOct(), 0, e, ItemEvent.SELECTED));
	}

	@Override
	public void startConvert() {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			try {
				int value = (int) Double.parseDouble(view.getJtf_input_result().getText());
				if (model instanceof Number) {
					Number num = (Number) model;
					num.setValueDec(value);
					num.setStrategy(findRadioChecked());
					num.notifyObservers(num.convert());
				}
			} catch (Exception e2) {
				view.update(null, "Du lieu la mot con so!");
			}
		}
	}

	private ConversionFunction findRadioChecked() {
		if (view.getRdBin().isSelected()) {
			return new DectToBin();
		} else if (view.getRdHex().isSelected()) {
			return new DectToHex();
		} else if (view.getRdOct().isSelected()) {
			return new DectToOct();
		}
		throw new IllegalArgumentException();
	}
}
