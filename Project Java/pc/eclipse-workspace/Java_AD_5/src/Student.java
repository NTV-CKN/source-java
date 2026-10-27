import java.util.Objects;

public class Student {
	@Override
	public int hashCode() {
		return Objects.hash(idCode, name, yearBorn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return idCode == other.idCode && Objects.equals(name, other.name) && yearBorn == other.yearBorn;
	}
	private String name;
	private int yearBorn;
	private int idCode;
	public Student(String name, int yearBorn, int idCode) {
		super();
		this.name = name;
		this.yearBorn = yearBorn;
		this.idCode = idCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearBorn() {
		return yearBorn;
	}
	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}
	public int getIdCode() {
		return idCode;
	}
	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", yearBorn=" + yearBorn + ", idCode=" + idCode + "]";
	}
	
	
}
