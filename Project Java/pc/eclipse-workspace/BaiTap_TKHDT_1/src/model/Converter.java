package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IConvertStrategy;
import model.interfaces.IModel;
import model.interfaces.Observable;
import view.Observer;

public class Converter implements IModel, Observable {
	private List<Observer> observers = new ArrayList<Observer>();
	private IConvertStrategy strategy;

	public Converter(IConvertStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	@Override
	public void notifyObservers(Object obj) {
		for (Observer observer : observers) {
			observer.update(this, obj);
		}
	}

	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);

	}

	@Override
	public void removeObserver(Observer ob) {
		observers.remove(ob);

	}

	@Override
	public String convert(Unit from, Unit to, double value) {
		String result = strategy.getResultFromConvert(from, to, value);
		this.notifyObservers(result);
		return result;
	}
	
	public IConvertStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(IConvertStrategy strategy) {
		this.strategy = strategy;
	}
}
