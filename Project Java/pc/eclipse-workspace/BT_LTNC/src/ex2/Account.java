package ex2;

public class Account {
	private String name, numberCard;
	private double money;

	// constructor
	public Account(String name, String numberCard) {
		this.name = name;
		this.numberCard = numberCard;
		this.money = 0;
	}

	// getter and setter
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public String getNumberCard() {
		return numberCard;
	}

	// deposit
	public double deposit(double amount) {
		if (this.money >= amount) {
			this.setMoney(this.getMoney() - amount);
			return amount;
		}
		return 0;
	}

	// withdrawal
	public void withdrawal(double amount) {
		if (this.money >= amount) {
			this.setMoney(this.getMoney() - amount);
		}
	}

	@Override
	public String toString() {
		return "Name: " + name + ", numberCard: " + numberCard + ", money: " + money +"\n";
	}

}
