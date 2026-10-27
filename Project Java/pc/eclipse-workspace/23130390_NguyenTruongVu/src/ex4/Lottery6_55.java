package ex4;

import java.util.List;

public class Lottery6_55 extends ADigitalLottery {
	private String name;

	public Lottery6_55(String date, String qrCode, String idSaleAgent, List<String> numberString) {
		super(date, qrCode, idSaleAgent, numberString);
		this.name = Utils.NAME_6_55;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ", " + super.toString();
	}
}
