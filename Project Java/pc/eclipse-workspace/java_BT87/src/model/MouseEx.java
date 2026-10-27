package model;

public class MouseEx {
	private int x,y;
	private int count;
	private String checkIn;
	
	//constructor
	public MouseEx() {
		this.x = 0;
		this.y = 0;
		this.count = 0;
		this.checkIn = "no";
	}
	//getter and setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	//methods
	public void count() {
		this.count++;
	}
}
