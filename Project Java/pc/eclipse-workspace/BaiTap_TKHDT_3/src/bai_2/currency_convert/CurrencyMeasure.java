package bai_2.currency_convert;

import java.text.DecimalFormat;

import bai_2.IStrategy;
import bai_2.SymbolUnit;
import bai_2strategy.conversion.Conversion;
import bai_2strategy.conversion.EURConversion;
import bai_2strategy.conversion.GBPConversion;
import bai_2strategy.conversion.JPYConversion;
import bai_2strategy.conversion.VNDConversion;
import bai_2strategy.type_convert.TypeConvert;

public class CurrencyMeasure implements TypeConvert {
	private double amount;
	private CurrencyUnit unit;

	public CurrencyMeasure(double amount, CurrencyUnit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public CurrencyUnit getUnit() {
		return unit;
	}

	@Override
	public String convert(double value, SymbolUnit sym) {
		this.amount = value;
		return "Unit " + unit.getSymbol() + " to " + sym + " = "
				+new DecimalFormat("#,###.00").format( unit.getConversion().baseTo(unit.getConversion().toBase(amount), sym));
	}

	@Override
	public void changeStrategy(IStrategy strategy) {
		if (strategy instanceof Conversion) {
			this.unit.setConversion((Conversion) strategy);
			if (strategy instanceof VNDConversion)
				this.unit.setSymbol(SymbolUnit.VND);
			else if (strategy instanceof JPYConversion)
				this.unit.setSymbol(SymbolUnit.JPY);
			else if (strategy instanceof GBPConversion)
				this.unit.setSymbol(SymbolUnit.GBP);
			else if (strategy instanceof EURConversion)
				this.unit.setSymbol(SymbolUnit.EUR);
		}
	}
}
