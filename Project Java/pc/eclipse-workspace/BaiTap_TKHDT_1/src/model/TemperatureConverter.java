package model;

import model.interfaces.IConvertStrategy;

public class TemperatureConverter implements IConvertStrategy {

	@Override
	public String getResultFromConvert(Unit from, Unit to, double value) {
		switch (from) {
		case Celsius: { 
			if (to == Unit.Fahrenheit) {
				return (value * 9 / 5) + 32 + "";
			} else if (to == Unit.Kelvin) {
				return value + 273.15 + "";
			}
			break;
		}
		case Fahrenheit: {
			if (to == Unit.Celsius) {
				return (value - 32) * 5 / 9 + "";
			}
			break;
		}
		case Kelvin: {
			if (to == Unit.Celsius) {
				return value - 273.15 + "";
			}
			break;
		}
		}
		return value + "";
	}
}