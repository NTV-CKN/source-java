package relearn_6;

public class Student {
	int id;
	String name;
	double grade;
	int bYear;
	double maxGrade, minGrade;

	

	public Student(int id, String name, double grade, int bYear, double maxGrade, double minGrade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.bYear = bYear;
		this.maxGrade = maxGrade;
		this.minGrade = minGrade;
	}



	@Override
	public String toString() {
		return id + "\t" + name + "\t" + bYear + "\t" + grade + "\t" + maxGrade + "\t" + minGrade;
	}
}
