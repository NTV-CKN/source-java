package bai_2strategy.conversion;

import bai_2.Bai2Utils;
import bai_2.IStrategy;
import bai_2.SymbolUnit;

public class GBPConversion implements Conversion, IStrategy {
	@Override
	public double baseTo(double amount, SymbolUnit toUnit) {
		return Bai2Utils.baseToHelper(amount, toUnit);
	}

	@Override
	public double toBase(double amount) {
		return amount /0.7393;
	}
}