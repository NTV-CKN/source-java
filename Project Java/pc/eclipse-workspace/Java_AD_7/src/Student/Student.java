package Student;

import java.util.Comparator;

public class Student implements Comparator<Student>{
	private String name, address;
	private String id;
	private String xepLoai;
	public Student(String name, String address, String id, String xepLoai) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
		this.xepLoai = xepLoai;
	}
	@Override
	public String toString() {
		return   name + ", " + address + ", " + id + ", " + xepLoai+"\n";
	}
	public boolean isId(String id) {
		return this.id.equals(id);
	}
	@Override
	public int compare(Student o1, Student o2) {
		String ar1[] = o1.name.split(" ");
		String ar2[] = o2.name.split(" ");
		return ar1[ar1.length-1].compareToIgnoreCase(ar2[ar2.length-1]);
	}
}
