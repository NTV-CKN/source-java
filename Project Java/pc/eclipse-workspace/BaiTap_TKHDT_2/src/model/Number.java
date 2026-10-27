package model;

import java.util.ArrayList;
import java.util.List;

import model.strategy.ConversionFunction;
import view.Observer;

public class Number implements Observable, IModel {
	private int valueDec;
	private ConversionFunction strategy;
	private List<Observer> observers = new ArrayList<Observer>();

	public Number(int valueDec, ConversionFunction strategy) {
		super();
		this.valueDec = valueDec;
		this.strategy = strategy;
	}

	public String convert() {
		return strategy.convert(valueDec);
	}

	public int getValueDec() {
		return valueDec;
	}

	public void setValueDec(int valueDec) {
		this.valueDec = valueDec;
	}

	public ConversionFunction getStrategy() {
		return strategy;
	}

	public void setStrategy(ConversionFunction strategy) {
		this.strategy = strategy;
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
	public void notifyObservers(Object obj) {
		for (Observer observer : observers) {
			observer.update(this, obj);
		}
	}
}
