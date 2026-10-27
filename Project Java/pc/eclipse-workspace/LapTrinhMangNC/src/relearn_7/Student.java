package relearn_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Student {
	int id;
	String name;
	int bYear;
	double grade;

	public Student(int id, String name, int bYear, double grade) {
		super();
		this.id = id;
		this.name = name;
		this.bYear = bYear;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", bYear=" + bYear + ", grade=" + grade + "]";
	}

	public void writeSt(RandomAccessFile raf, int lenByteName) throws IOException {
		raf.writeInt(id);
		convertNameToChar(raf, lenByteName);
		raf.writeInt(lenByteName);
		raf.writeDouble(lenByteName);
	}

	private void convertNameToChar(RandomAccessFile raf, int lenByteName) throws IOException {
		for (int i = 0; i < lenByteName / 2; i++) {
			char c = 0;
			if (name.length() > i)
				c = name.charAt(i);
			raf.writeChar(c);
		}
	}
}
