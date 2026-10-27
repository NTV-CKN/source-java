package SinhKiTuazAZ;

public class SharedData {
	private  int total=0;
	private static SharedData sharedData = null;
	private int number;
	
	 
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static SharedData getData() {
		if(sharedData == null) {
			sharedData = new SharedData();
		}
		return sharedData;
	}
	public  int totalTime(int time) {
		return total+=time;
	}
	public boolean available() {
		return total < 17000;
	}
}
