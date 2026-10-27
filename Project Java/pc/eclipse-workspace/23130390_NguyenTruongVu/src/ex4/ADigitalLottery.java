package ex4;

import java.util.List;

public abstract class ADigitalLottery {
	public String date, qrCode, idSaleAgent;
	public List<String> numberString;

	public ADigitalLottery(String date, String qrCode, String idSaleAgent, List<String> numberString) {
		super();
		this.date = date;
		this.qrCode = qrCode;
		this.idSaleAgent = idSaleAgent;
		this.numberString = numberString;
	}

	public List<String> getList() {
		return numberString;
	}

	@Override
	public String toString() {
		return "Date " + date + ", qr code " + qrCode + ", id sale agent " + idSaleAgent;
	}
}
