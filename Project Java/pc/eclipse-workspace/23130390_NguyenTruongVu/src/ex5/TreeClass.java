package ex5;

import java.util.Random;
import java.util.TreeSet;

import ex5.Ex3.Student;

public class TreeClass {
	private static TreeSet<Student> treeSet = new TreeSet<Student>();

	public static TreeSet<Student> create() {
		treeSet.clear();
		Random ran = new Random();
		for (int i = 0; i < 6; i++) {
			Student student = new Student("38 " + i + ran.nextInt(10), "NTV " + i, 2005, 5);
			treeSet.add(student);
		}
		return treeSet;
	}
}
