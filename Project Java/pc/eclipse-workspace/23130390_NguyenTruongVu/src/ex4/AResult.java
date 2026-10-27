package ex4;

import java.util.List;

public class AResult {
	public String date;
	public String specialPrice, firstPrice, secondPrice;

	public AResult(String date, String specialPrice, String firstPrice, String secondPrice) {
		super();
		this.date = date;
		this.specialPrice = specialPrice;
		this.firstPrice = firstPrice;
		this.secondPrice = secondPrice;
	}

	public String getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(String specialPrice) {
		this.specialPrice = specialPrice;
	}

	public String getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(String firstPrice) {
		this.firstPrice = firstPrice;
	}

	public String getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(String secondPrice) {
		this.secondPrice = secondPrice;
	}
}
