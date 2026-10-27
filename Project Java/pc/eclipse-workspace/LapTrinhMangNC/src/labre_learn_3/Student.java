package labre_learn_3;

public class Student {
	int id;
	String name;
	int bYear;
	double grade;

	public Student(int id, String name, int bYear) {
		super();
		this.id = id;
		this.name = name;
		this.bYear = bYear;
		this.grade = 0;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + bYear + "\t" + grade;
	}
}
