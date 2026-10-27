package Bank;

public class MyBank {
	private int money;
	//constructor
	public MyBank(int money) {
		super();
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//withDraw
	public synchronized void withDraw(String name, int money) {
		if(money <= this.money) {
			System.out.println("So tien can rut: "+ money +", "+name);
			this.money -= money;
		}else {
			System.err.println("So tien khong hop le tai: " + name);
		}
		System.out.println("So tien con lai la: "+ this.money);
	}
}
