package bai_2.controllor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import bai_2.Converter;
import bai_2.IModel;
import bai_2.SymbolUnit;
import bai_2.currency_convert.CurrencyMeasure;
import bai_2.currency_convert.CurrencyUnit;
import bai_2.distance_convert.DistanceMeasure;
import bai_2.strategy_distance.DistanceConversion;
import bai_2.strategy_distance.MeterToMile;
import bai_2.strategy_distance.MeterToYard;
import bai_2.view.ConverterView;
import bai_2strategy.conversion.EURConversion;
import bai_2strategy.conversion.GBPConversion;
import bai_2strategy.conversion.JPYConversion;
import bai_2strategy.conversion.VNDConversion;

public class ConverterControllor implements IControllor, ActionListener, ItemListener {
	private IModel model;
	private ConverterView view;

	public ConverterControllor(IModel model, ConverterView view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		try {
			if (cmd.equals(view.jbtn_convert.getText())) {
				if (model instanceof Converter) {
					Converter tmp = (Converter) model;
					if (view.jcb_choose_type_convert.getSelectedItem().equals(view.arrTypeConverrt[1])) {
						tmp.setType(new CurrencyMeasure(0,
								findCurrentUnit((SymbolUnit) view.jcb_unit_from.getSelectedItem())));
						tmp.convert(Double.parseDouble(view.jtf_input_value.getText()),
								(SymbolUnit) view.jcb_unit_to.getSelectedItem());
					} else if (view.jcb_choose_type_convert.getSelectedItem().equals(view.arrTypeConverrt[0])) {
						tmp.setType(new DistanceMeasure(0,
								findMesuareDistance((SymbolUnit) view.jcb_unit_from.getSelectedItem())));
						tmp.convert(Double.parseDouble(view.jtf_input_value.getText()), null);
					}
				}
			}
		} catch (Exception e2) {
			view.update(null, "Da xay ra loi");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("sss");
			if (view.jcb_choose_type_convert.getSelectedItem().equals(view.arrTypeConverrt[0])) {// distance
				view.changeItemOfJcb(view.arrTypeConverrt[0]);
			} else if (view.jcb_choose_type_convert.getSelectedItem().equals(view.arrTypeConverrt[1])) {// concurrency
				view.changeItemOfJcb(view.arrTypeConverrt[1]);
			}

		}

	}

	private DistanceConversion findMesuareDistance(SymbolUnit selectedItem) {
		switch (selectedItem) {
		case MeterToMile: {
			return new MeterToMile();
		}
		case MeterToYard: {
			return new MeterToYard();
		}
		}

		throw new IllegalArgumentException();
	}

	private CurrencyUnit findCurrentUnit(SymbolUnit unit) {
		CurrencyUnit conCurrencyUnit = new CurrencyUnit(unit, null);
		switch (unit) {
		case EUR: {
			conCurrencyUnit.setConversion(new EURConversion());
			break;
		}
		case GBP: {
			conCurrencyUnit.setConversion(new GBPConversion());
			break;
		}
		case JPY: {
			conCurrencyUnit.setConversion(new JPYConversion());
			break;
		}
		case VND: {
			conCurrencyUnit.setConversion(new VNDConversion());
			break;
		}
		}
		if (conCurrencyUnit.getConversion() == null)
			throw new IllegalArgumentException();
		return conCurrencyUnit;
	}
}
