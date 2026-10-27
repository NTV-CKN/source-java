package model.interfaces;

import model.Unit;

public interface IConvertStrategy {
	public String getResultFromConvert(Unit from, Unit to, double value);
}
