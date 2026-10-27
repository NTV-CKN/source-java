package bai_2.strategy_distance;

import bai_2.IStrategy;

public class MeterToMile implements DistanceConversion, IStrategy {
	@Override
	public String convert(double value) {
		return "Tu meter sang mile = " + value*1609.344;
	}
}
