package ex4;

import java.util.List;

public class LotteryMega4 extends ADigitalLottery {
	private String name;

	public LotteryMega4(String date, String qrCode, String idSaleAgent, List<String> numberString) {
		super(date, qrCode, idSaleAgent, numberString);
		this.name = Utils.NAME_MEGA;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + ", " + super.toString();
	}
}
