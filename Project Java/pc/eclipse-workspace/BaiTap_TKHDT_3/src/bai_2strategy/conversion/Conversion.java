package bai_2strategy.conversion;

import bai_2.SymbolUnit;

public interface Conversion {
	public double toBase(double amount);
	public double baseTo(double amount, SymbolUnit toUnit);
}
