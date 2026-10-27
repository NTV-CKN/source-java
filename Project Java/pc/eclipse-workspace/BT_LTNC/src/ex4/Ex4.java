package ex4;

public class Ex4 {
	public static void main(String[] args) {
		Student[] students = { new Student("Vu", "23130390", 23), new Student("Vy", "23130300", 23),
				new Student("Hoa", "23130301", 23) };

		Teacher[] teachers = { new Teacher("DVQ", "dvq1", "Math"), new Teacher("NDCS", "ndcs1", "CNPM") };

		Course[] courses = { new Course(students, teachers, "K-123"), new Course(students, teachers, "K-456") };

		Classroom cm = new Classroom(courses);

		System.out.println(cm.toString());
		System.out.println("==========================================");

		// enroll
		cm.enroll(new Student("Vu", "23130390", 23), "K-123");
		System.out.println(cm);
		System.out.println("==========================================");
		// assign
		cm.enroll(new Teacher("DVQ", "dvq2", "Math"), "K-456");
		System.out.println(cm);
		System.out.println("==========================================");
		// create schedule
		cm.generateSchedule("K-456", "Monday", "Test Math");
		System.out.println(cm);
	}
}
