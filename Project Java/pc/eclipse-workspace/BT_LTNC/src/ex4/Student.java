package ex4;

public class Student {
	private String name, id;
	private int course;

//constructor
	public Student(String name, String id, int course) {
		this.name = name;
		this.id = id;
		this.course = course;
	}

	// getter
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Student: name: " + name + ", id: " + id + ", course: " + course + "\n";
	}

}
