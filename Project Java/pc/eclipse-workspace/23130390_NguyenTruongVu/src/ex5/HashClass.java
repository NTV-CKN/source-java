package ex5;

import java.util.HashSet;

import ex5.Ex3.Student;

public abstract class HashClass {
	private static HashSet<Student> hashSet = new HashSet<Student>();

	public static HashSet<Student> create() {
		hashSet.clear();
		for (int i = 0; i < 6; i++) {
			Student student = new Student("38 " + i, "NTV " + i, 2005, 5);
			hashSet.add(student);
		}
		return hashSet;
	}
}
