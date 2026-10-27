package thi_de5;

public class Account implements Comparable<Account> {
	private String id, name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", currentBalance=" + currentBalance + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	private double currentBalance;

	public Account(String id, String name, double cur) {
		super();
		this.id = id;
		this.name = name;
		this.currentBalance = cur;
	}

	@Override
	public int compareTo(Account o) {
		if (this.name.compareTo(o.name) == 0) {
			return this.id.compareTo(o.id);
		}
		return this.name.compareTo(o.name);
	}

}
