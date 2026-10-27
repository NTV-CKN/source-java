package view;

import model.interfaces.Observable;

public interface Observer {
	public void update(Observable observable, Object obj);
}
