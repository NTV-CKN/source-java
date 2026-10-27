package bai_2;

import bai_2.currency_convert.CurrencyMeasure;
import bai_2.currency_convert.CurrencyUnit;
import bai_2.distance_convert.DistanceMeasure;
import bai_2.strategy_distance.MeterToMile;
import bai_2.strategy_distance.MeterToYard;
import bai_2.view.ConverterView;
import bai_2strategy.conversion.EURConversion;
import bai_2strategy.conversion.JPYConversion;
import bai_2strategy.conversion.VNDConversion;

public class Test {
	public static void main(String[] args) {
		Converter converter = new Converter(
				new CurrencyMeasure(1000, new CurrencyUnit(SymbolUnit.VND, new VNDConversion())));

		
		System.out.println(converter.convert(100000, SymbolUnit.JPY));

		converter.setStrategyForTypeConvert(new JPYConversion());
		System.out.println(converter.convert(100000, SymbolUnit.EUR));
		System.out.println(converter.convert(100000, SymbolUnit.VND));

		converter.setType(new DistanceMeasure(1000, new MeterToMile()));
		System.out.println(converter.convert(100, null));
		converter.setStrategyForTypeConvert(new MeterToYard());
		System.out.println(converter.convert(100, null));
		
		new ConverterView(new Converter(new DistanceMeasure(0, null)));
	}
}
