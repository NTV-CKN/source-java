package ex4;

import java.util.Arrays;

public class Course {
	private Student[] students = new Student[1];
	private Teacher[] teachers = new Teacher[1];
	private String key;
	private StringBuilder strB = new StringBuilder();
	private int iStudent = 0, iTeacher = 0;

	// constructor
	public Course(Student[] listStu, Teacher[] listTea, String key) {
		for (int i = 0; i < listStu.length; i++) {
			if (this.students[this.students.length - 1] != null) {
				this.students = (Student[]) UpgradeSize.upgS(students);
			}
			this.students[i] = listStu[i];
			iStudent++;
		}

		for (int i = 0; i < listTea.length; i++) {
			if (this.teachers[this.teachers.length - 1] != null) {
				this.teachers = (Teacher[]) UpgradeSize.upgS(teachers);
			}
			this.teachers[i] = listTea[i];
			iTeacher++;
		}
		this.key = key;
	}

	public Course(Student student) {
		if (this.students[this.students.length - 1] != null) {
			this.students = (Student[]) UpgradeSize.upgS(students);
		}
		this.students[iStudent++] = student;
	}

	public Course(Teacher teacher) {
		if (this.teachers[this.teachers.length - 1] != null) {
			this.teachers = (Teacher[]) UpgradeSize.upgS(teachers);
		}
		this.teachers[iTeacher++] = teacher;
	}

	@Override
	public String toString() {
		return "students: " + Arrays.toString(students) + "\nteachers: " + Arrays.toString(teachers) + "\nkey: " + key
				+ "\nSchedule: " + strB.toString();
	}

	// getter
	public String getKey() {
		return key;
	}

	// enroll student
	public void enrollStudent(Student student) {
		if (this.students[this.students.length - 1] != null) {
			this.students = (Student[]) UpgradeSize.upgS(students);
		}
		this.students[iStudent++] = student;
	}

	// assign
	public void assignTeacher(Teacher teacher) {
		if (this.teachers[this.teachers.length - 1] != null) {
			this.teachers = (Teacher[]) UpgradeSize.upgS(teachers);
		}
		this.teachers[iTeacher++] = teacher;
	}

	// add schedule
	public void addSchedule(String time, String des) {
		strB.append(time + " " + des + "\n");
	}
}
