package thide2;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String id, name;
	private Subject monHoc;
	private double diem;

	public Student(String id, String name, Subject monHoc, double diem) {
		super();
		this.id = id;
		this.name = name;
		this.monHoc = monHoc;
		this.diem = diem;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Subject getMonHoc() {
		return monHoc;
	}

	public double getDiem() {
		return diem;
	}

	@Override
	public String toString() {
		return "Student:  id " + id + ", name " + name + ", monHoc " + monHoc + ", diem " + diem;
	}

	@Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(diem) == Double.doubleToLongBits(other.diem) || Objects.equals(id, other.id)
				|| Objects.equals(monHoc, other.monHoc) || Objects.equals(name, other.name);
	}
}
