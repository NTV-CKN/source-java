package thi_de5;

public class CertificateOfDeposit extends Account {
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	private double interestRate;
	private String maturity;

	public CertificateOfDeposit(String id, String name, double cur, double in, String ma) {
		super(id, name, cur);
		this.interestRate = in;
		this.maturity = ma;
	}

	@Override
	public String toString() {
		return  super.toString() +  "CertificateOfDeposit [interestRate=" + interestRate + ", maturity=" + maturity + "]";
	}

}
