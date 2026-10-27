package model;

public class Model {
	private int value;

	//constructor
	public Model() {
		this.value = 0;
	}
	//setter & setter
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	//methods
	public void pick_1() {
		this.setValue(1);
	}
	public void pick_2() {
		this.setValue(2);
	}
	public void pick_3() {
		this.setValue(3);
	}
	public void pick_4() {
		this.setValue(4);
	}
}
