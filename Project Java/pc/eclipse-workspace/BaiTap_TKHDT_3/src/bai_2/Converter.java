package bai_2;

import java.util.ArrayList;
import java.util.List;

import bai_2.view.Observer;
import bai_2strategy.type_convert.TypeConvert;

public class Converter implements IModel, Observable {
	private TypeConvert type;
	private List<Observer> observers = new ArrayList<Observer>();

	public Converter(TypeConvert type) {
		super();
		this.type = type;
	}

	@Override
	public void addObserver(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void notifyObserver(Object obj) {
		for (Observer observer : observers) {
			observer.update(this, obj);
		}
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public String convert(double value, SymbolUnit unit) {
		try {
			if (type != null) {
				String result = type.convert(value, unit);
				notifyObserver(result);
				return result;
			}
			notifyObserver("You still not assign typeconvert");
			return "You still not assign typeconvert";
		} catch (Exception e) {
			notifyObserver("We don't support this unit: " + unit);
			return "We don't support this unit: " + unit;
		}

	}

	public void setStrategyForTypeConvert(IStrategy strategy) {
		type.changeStrategy(strategy);
	}

	public TypeConvert getType() {
		return type;
	}

	public void setType(TypeConvert type) {
		this.type = type;
	}

}
