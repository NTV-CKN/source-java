package bai_2.distance_convert;

import bai_2.IStrategy;
import bai_2.SymbolUnit;
import bai_2.strategy_distance.DistanceConversion;
import bai_2.strategy_distance.MeterToMile;
import bai_2.strategy_distance.MeterToYard;
import bai_2strategy.type_convert.TypeConvert;

public class DistanceMeasure implements TypeConvert {
	private double value;
	private DistanceConversion conversion;

	public DistanceMeasure(double value, DistanceConversion conversion) {
		super();
		this.value = value;
		this.conversion = conversion;
	}

	@Override
	public void changeStrategy(IStrategy strategy) {
		if (strategy instanceof MeterToMile || strategy instanceof MeterToYard)
			this.conversion = (DistanceConversion) strategy;
	}

	@Override
	public String convert(double value, SymbolUnit sym) {
		this.value =value;
		return conversion.convert(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public DistanceConversion getConversion() {
		return conversion;
	}
}
