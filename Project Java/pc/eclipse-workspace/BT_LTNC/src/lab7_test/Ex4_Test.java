package lab7_test;

import junit.framework.TestCase;
import ex4.*;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		Student[] students = { new Student("Vu", "23130390", 23), new Student("Vy", "23130300", 23),
				new Student("Hoa", "23130301", 23) };

		Teacher[] teachers = { new Teacher("DVQ", "dvq1", "Math"), new Teacher("NDCS", "ndcs1", "CNPM") };

		Course[] courses = { new Course(students, teachers, "K-123"), new Course(students, teachers, "K-456") };

		Classroom cm = new Classroom(courses);

		StringBuilder strB = new StringBuilder();
		strB.append(cm.toString());

		// enroll
		cm.enroll(new Student("Vu", "23130390", 23), "K-123");
		assertFalse(strB.toString().equals(cm.toString()));
		strB.append(cm.toString());
		// assign
		cm.enroll(new Teacher("DVQ", "dvq2", "Math"), "K-456");
		assertFalse(strB.toString().equals(cm.toString()));
		strB.append(cm.toString());
		// create schedule
		cm.generateSchedule("K-456", "Monday", "Test Math");
		assertFalse(strB.toString().equals(cm.toString()));
	}
}
