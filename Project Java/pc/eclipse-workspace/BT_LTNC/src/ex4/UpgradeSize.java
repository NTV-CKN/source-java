package ex4;

public class UpgradeSize {
	public static Object[] upgS(Object[] obj) {
		if (obj instanceof Student[]) {
			Student[] students = new Student[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				students[i] = (Student) obj[i];
			}
			return students;
		} else if (obj instanceof Teacher[]) {
			Teacher[] teachers = new Teacher[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				teachers[i] = (Teacher) obj[i];
			}
			return teachers;
		} else if (obj instanceof Course[]) {
			Course[] courses = new Course[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				courses[i] = (Course) obj[i];
			}
			return courses;
		}
		return null;
	}
}
