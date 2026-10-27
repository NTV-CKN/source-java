package bai_1.cau2.strategy;

public class CreditCard implements IPayStrategy {
	private String name, cardNumber;// chi luu 4 so cuoi

	public CreditCard(String name, String cardNumber) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

}
