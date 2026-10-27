package re_learn_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bai11 {
	public final int LEN_NAME_BY_BYTE = 100;
	private RandomAccessFile raf;

	public Bai11() throws FileNotFoundException {
		raf = new RandomAccessFile("C:\\Users\\pc\\Downloads\\Newfolder\\st.dat", "rw");
	}

	public void addStudent(Student st) throws IOException {
		raf.seek(0);
		int numEntry = 0;
		int recSize;
		if (raf.length() == 0) {
			recSize = 4 + LEN_NAME_BY_BYTE + 4 + 8;
		} else {
			numEntry = raf.readInt();
			recSize = raf.readInt();
		}
		// update header
		raf.seek(0);
		raf.writeInt(numEntry + 1);
		raf.writeInt(recSize);
		// write data
		long lastIndex = 8 + (recSize * numEntry);
		raf.seek(lastIndex);
		st.writeSt(raf, LEN_NAME_BY_BYTE);
	}

	public Student getStudent(int index) throws IOException {
		raf.seek(0);
		int numEntry = 0;
		int recSize;
		if (raf.length() == 0) {
			return null;
		} else {
			numEntry = raf.readInt();
			recSize = raf.readInt();
			if (numEntry <= index)
				return null;
		}
		// write data
		raf.seek(8 + (index * recSize));
		int id = raf.readInt();
		String name = convertCharsToStr(raf, LEN_NAME_BY_BYTE);
		int bYear = raf.readInt();
		double grade = raf.readDouble();
		return new Student(id, name, bYear, grade);
	}

	public void updateStudent(int index, Student newSt) throws IOException {
		raf.seek(0);
		int numEntry = 0;
		int recSize;
		if (raf.length() == 0) {
			return;
		} else {
			numEntry = raf.readInt();
			recSize = raf.readInt();
			if (numEntry <= index)
				return;
		}
		// write data
		raf.seek(8 + (index * recSize));
		newSt.writeSt(raf, LEN_NAME_BY_BYTE);
	}

	public Student findById(int idTmp) throws IOException {
		raf.seek(0);
		int numEntry = 0;
		int recSize;
		if (raf.length() == 0) {
			return null;
		} else {
			numEntry = raf.readInt();
			recSize = raf.readInt();
		}

		// write data
		for (int i = 0; i < numEntry; i++) {
			raf.seek(8 + (i * recSize));
			int id = raf.readInt();
			if (id == idTmp) {
				String name = convertCharsToStr(raf, LEN_NAME_BY_BYTE);
				int bYear = raf.readInt();
				double grade = raf.readDouble();
				return new Student(id, name, bYear, grade);
			}
		}
		return null;
	}

	private String convertCharsToStr(RandomAccessFile raf2, int lEN_NAME_BY_BYTE2) throws IOException {
		String name = "";
		for (int i = 0; i < lEN_NAME_BY_BYTE2 / 2; i++) {
			char c = raf.readChar();
			if (c != 0)
				name += c;
		}
		return name;
	}

	public static void main(String[] args) throws IOException {
		Bai11 b = new Bai11();
//		b.addStudent(new Student(1, "Nguyen Duc Cống", 1992 , 10));
//		b.addStudent(new Student(2, "Ngo Ba Kha", 1292 , 10));
//		b.addStudent(new Student(12, "Nguyen Truong Vu", 2992 , 10));
//		b.updateStudent(2, new Student(13, "Vu dep trai", 1110, 10));
//		System.out.println(b.findById(13));
		System.out.println(b.getStudent(1));
	}
}
