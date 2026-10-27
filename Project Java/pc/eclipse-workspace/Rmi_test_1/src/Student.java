import java.io.Serializable;

public class Student implements Serializable {
	int id;
	String name;
	double avgGrade;

	public Student() {
	}

	public Student(int id, String name, double avgGrade) {
		super();
		this.id = id;
		this.name = name;
		this.avgGrade = avgGrade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", avgGrade=" + avgGrade + "]";
	}
	
}
