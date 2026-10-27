package model;

import model.interfaces.IConvertStrategy;

public class DistanceConverter implements IConvertStrategy {

	@Override
	public String getResultFromConvert(Unit from, Unit to, double value) {
		switch (from) {
		case Meter: {
			if (to == Unit.Kilometer) {
				return value / 1000 + "";
			} else if (to == Unit.Centimeter) {
				return value * 100 + "";
			}
			break;
		}
		case Centimeter: {
			if (to == Unit.Meter) {
				return value / 100 + "";
			}
			break;
		}
		case Kilometer: {
			if (to == Unit.Meter) {
				return value * 1000 + "";
			}
			break;
		}
		}
		return value + "";
	}
}
