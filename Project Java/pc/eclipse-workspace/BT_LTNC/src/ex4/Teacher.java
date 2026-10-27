package ex4;

public class Teacher {
	private String name, id, major;

//constructor
	public Teacher(String name, String id, String major) {
		this.name = name;
		this.id = id;
		this.major = major;
	}

	// getter
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getMajor() {
		return major;
	}

	@Override
	public String toString() {
		return "Teacher: name: " + name + ", id: " + id + ", major: " + major + "\n";
	}
}
