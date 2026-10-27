package ex4;

import java.util.Arrays;

public class Classroom {
	private Course[] courses = new Course[1];
	private int iKey = -1;

	// constructor
	public Classroom(Course[] courses) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[courses.length - 1] != null) {
				this.courses = (Course[]) UpgradeSize.upgS(this.courses);
			}
			this.courses[i] = courses[i];
		}
	}

	// check key
	public boolean checkKey(String key) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				break;
			}
			if (courses[i].getKey().equals(key)) {
				this.iKey = i;
				return true;
			}
		}
		this.iKey = -1;
		return false;
	}

	// enroll
	public void enroll(Object obj, String key) {
		if (this.checkKey(key)) {
			if (obj instanceof Student) {
				courses[iKey].enrollStudent((Student) obj);
				iKey = -1;
			} else if (obj instanceof Teacher) {
				courses[iKey].assignTeacher((Teacher) obj);
				iKey = -1;
			}
		}
	}

	// generate schedule
	public void generateSchedule(String key, String time, String des) {
		if (this.checkKey(key)) {
			this.courses[iKey].addSchedule(time, des);
		}
	}

	@Override
	public String toString() {
		return "Classroom:\ncourses:\n" + Arrays.toString(courses);
	}

}
