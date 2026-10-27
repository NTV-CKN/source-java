package model;

public class CounterModel {
	private int value;
	
	//constructor
	public CounterModel() {
		this.value = 0;
	}
	//getter setter

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public void tang() {
		this.value++;
	}
	public void giam() {
		this.value--;
	}
	public void reset() {
		this.value=0;
	}
}
