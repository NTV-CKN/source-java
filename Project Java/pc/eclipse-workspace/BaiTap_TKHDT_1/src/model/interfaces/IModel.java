package model.interfaces;

import model.Unit;

public interface IModel {
	public String convert(Unit from, Unit to, double value);
	public void setStrategy(IConvertStrategy strategy);
}
