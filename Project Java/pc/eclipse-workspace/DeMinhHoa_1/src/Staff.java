import java.util.Objects;

public class Staff extends Employee{
	private String department;
	public Staff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, String t) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		this.department= t;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(department, other.department);
	}
	@Override
	public double salary() {
		return salaryUnit * salaryRate;
	}
	@Override
	public int count() {
		return 0;
	}
	@Override
	public boolean isProduce(Produce that) {
		return false;
	}
	@Override
	public String getSaler(Produce that) {
		return null;
	}

}
