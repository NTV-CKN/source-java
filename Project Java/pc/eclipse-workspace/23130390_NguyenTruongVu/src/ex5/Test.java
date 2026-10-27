package ex5;

import java.util.HashSet;
import java.util.TreeSet;

import ex5.Ex3.Student;

public class Test {
	public static void main(String[] args) {
		Ex1 ex1 = new Ex1();
		Ex2 ex2 = new Ex2();
		HashSet<Student> hash = HashClass.create();
		TreeSet<Student> tree = TreeClass.create();

		System.out.println("Ex1");
		System.out.println(ex1.hashCodeJava("AA"));
		System.out.println(ex1.hashCodeJava(""));
		System.out.println(ex1.hashCodeJava("AABBGSSSDDDEHE"));
		System.out.println(ex1.hashCodeJava(null));
		System.out.println("Ex2");
		System.out.println(ex2.hashCodeNatureKey("CLRS"));
		System.out.println(ex2.hashCodeNatureKey(""));
		System.out.println(ex2.hashCodeNatureKey("AABBGSSSDDDEHE"));
		System.out.println(ex2.hashCodeNatureKey(null));
		System.out.println("Ex3\nHash");
		for (Student student : hash) {
			System.out.println(student);
		}
		System.out.println("Tree");
		for (Student student : tree) {
			System.out.println(student);
		}
	}
}
