package bai_1.cau2;

import java.util.Date;
import java.util.Objects;

import bai_1.cau2.strategy.IPayStrategy;

public class Customer {
	private String id, name, phoneNumber, address;
	private Date dob;
	private IPayStrategy payment;

	public Customer(String id, String name, String phoneNumber, String address, Date dob, IPayStrategy payment) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public Date getDob() {
		return dob;
	}

	public IPayStrategy getPayment() {
		return payment;
	}

	public void setPayment(IPayStrategy payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, dob, id, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(dob, other.dob) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

}
