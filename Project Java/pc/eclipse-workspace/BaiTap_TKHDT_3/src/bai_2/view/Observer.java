package bai_2.view;

import bai_2.Observable;

public interface Observer {
	public void update(Observable observable, Object obj);
}
