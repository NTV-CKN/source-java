package thuc_hanh_buoi_1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Student {
	int id;
	String name;
	int bYear;
	double grade;

	public Student() {
	}

	public Student(int id, String name, int bYear, double grade) {
		super();
		this.id = id;
		this.name = name;
		this.bYear = bYear;
		this.grade = grade;
	}

	public void addStudent(RandomAccessFile raf, int lenName) throws IOException {
		raf.writeInt(id);
		convertStrToChars(raf, lenName);
		raf.writeInt(bYear);
		raf.writeDouble(grade);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", bYear=" + bYear + ", grade=" + grade + "]";
	}

	private void convertStrToChars(RandomAccessFile raf, int lenName) throws IOException {
		for (int i = 0; i < lenName / 2; i++) {
			char c = 0;
			if (i < this.name.length())
				c = this.name.charAt(i);
			raf.writeChar(c);
		}
	}
}
