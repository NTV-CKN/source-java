package bai_2.currency_convert;

import bai_2.SymbolUnit;
import bai_2strategy.conversion.Conversion;

public class CurrencyUnit {
	private SymbolUnit symbol;
	private Conversion conversion;

	public CurrencyUnit(SymbolUnit symbol, Conversion conversion) {
		super();
		this.symbol = symbol;
		this.conversion = conversion;
	}

	public Conversion getConversion() {
		return conversion;
	}

	public void setConversion(Conversion conversion) {
		this.conversion = conversion;
	}

	public SymbolUnit getSymbol() {
		return symbol;
	}

	public void setSymbol(SymbolUnit symbol) {
		this.symbol = symbol;
	}
}
