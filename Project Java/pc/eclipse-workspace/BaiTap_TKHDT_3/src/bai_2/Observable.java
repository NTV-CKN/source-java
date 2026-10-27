package bai_2;

import bai_2.view.Observer;

public interface Observable {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObserver(Object obj);
}
