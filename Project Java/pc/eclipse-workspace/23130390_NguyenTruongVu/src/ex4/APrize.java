package ex4;

import java.util.ArrayList;
import java.util.List;

/*
 * Giai dac biet = 1 ti, trung het 6 so hoac het 4 so
 * Giai nhat >= 500 trieu va < 1 ti, trung duoc 5 so hoac trung 3 so
 * Giai nhi >= 1 trieu va < 500 trieu, trung duoc 4 so hoac trung 2 so
 */
public abstract class APrize {
	public double amount;
	public String name, rule;
	public List<AResult> listResult;
	private Company company;

	public APrize(double amount, String name, String rule, int size) {
		super();
		this.amount = amount;
		this.name = name;
		this.rule = rule;
		this.listResult = new ArrayList<AResult>();

		for (int i = 0; i < size; i++) {
			// i = 0 DB, 1 nhat, 2 nhi
			this.listResult.add(null);
		}
	}
	
	public abstract void draw();

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "So tien: " + amount;
//	}
}
