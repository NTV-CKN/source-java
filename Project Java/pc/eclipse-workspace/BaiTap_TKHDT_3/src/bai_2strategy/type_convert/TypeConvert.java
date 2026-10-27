package bai_2strategy.type_convert;

import bai_2.IStrategy;
import bai_2.SymbolUnit;

public interface TypeConvert {
	public String convert(double value, SymbolUnit sym);
	public void changeStrategy(IStrategy strategy);
}
