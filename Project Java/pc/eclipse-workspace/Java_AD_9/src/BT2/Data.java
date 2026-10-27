package BT2;

public class Data {
	private int number;
	private int index;
	private int total;
	public Data() {
		this.total = 0;
		this.index = 1;
	}
	//sum
	public synchronized int sum(int number) {
		return total+=number;
	}
	//check
	public synchronized boolean isAvailable() {
		return this.total < 200;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
