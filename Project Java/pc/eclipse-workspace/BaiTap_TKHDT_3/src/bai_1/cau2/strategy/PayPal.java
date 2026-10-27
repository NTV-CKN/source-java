package bai_1.cau2.strategy;

public class PayPal implements IPayStrategy {
	private String email, password;

	public PayPal(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
}
