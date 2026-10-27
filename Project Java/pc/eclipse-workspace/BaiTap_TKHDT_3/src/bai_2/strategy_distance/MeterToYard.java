package bai_2.strategy_distance;

import bai_2.IStrategy;

public class MeterToYard implements DistanceConversion, IStrategy {
	@Override
	public String convert(double value) {
		return "Tu meter to yard = " + value * 0.9144;
	}
}
