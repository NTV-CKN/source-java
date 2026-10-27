package th18;

public class Students {
	int studentId;
	String fullName;
	double avgGrade;

	public Students(int studentId, String fullName, double avgGrade) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.avgGrade = avgGrade;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return studentId + "\t" + fullName + "\t" + avgGrade;
	}
}
